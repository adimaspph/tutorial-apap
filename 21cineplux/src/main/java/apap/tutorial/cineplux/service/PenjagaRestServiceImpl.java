package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.*;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService{
    @Autowired
    private PenjagaDB penjagaDB;

    @Autowired
    private BioskopDB bioskopDB;

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public List<PenjagaModel> retrieveListPenjagaKelamin(Integer kelamin) {
        return  penjagaDB.findAllByJenisKelamin(kelamin);

//        List<PenjagaModel> result = new LinkedList<>();
//
//        for (PenjagaModel penjaga : listPenjaga) {
//             if (penjaga.getJenisKelamin() == kelamin) {
//                 result.add(penjaga);
//             }
//        }
//        return result;
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findById(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);

        penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
        penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
        penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
        penjaga.setBioskop(penjagaUpdate.getBioskop());

        return penjagaDB.save(penjaga);
    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        LocalTime now = LocalTime.now();
        BioskopModel bioskop = bioskopDB.findByNoBioskop(penjaga.getBioskop().getNoBioskop()).get();
        if (now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup())) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }

    private final WebClient webClient;

    public PenjagaRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.penjagaUrl).build();
    }
    @Override
    public PenjagaModel predictUmur(Long noPenjaga) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);

        String[] splitedName = penjaga.getNamaPenjaga().split(" ");

        Mono<Map> umur = this.webClient.get().uri("/?name=" + splitedName[0])
                .retrieve()
                .bodyToMono(Map.class);

        Map<String, Integer> umurMap = umur.block();
        penjaga.setUmur(umurMap.get("age"));
        return penjaga;
    }
}
