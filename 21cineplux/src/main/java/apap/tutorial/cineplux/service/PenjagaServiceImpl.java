package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService{

    @Autowired
    PenjagaDB penjagaDB;
    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public void updatePenjaga(PenjagaModel penjaga) { penjagaDB.save(penjaga); }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        penjagaDB.deleteById(noPenjaga);
    }

    @Override
    public int deletePenjaga(PenjagaModel penjaga) {
        LocalTime now = LocalTime.now();
        BioskopModel bioskop = bioskopDB.findByNoBioskop(penjaga.getBioskop().getNoBioskop()).get();
        if (now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup())) {
            penjagaDB.delete(penjaga);
            return 1;
        }
        return 0;
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findById(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }
}
