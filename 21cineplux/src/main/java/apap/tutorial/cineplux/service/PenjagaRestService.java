package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.rest.BioskopDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PenjagaRestService {
    PenjagaModel createPenjaga(PenjagaModel penjaga);
    List<PenjagaModel> retrieveListPenjaga();
    List<PenjagaModel> retrieveListPenjagaKelamin(Integer kelamin);
    PenjagaModel getPenjagaByNoPenjaga(long noPenjaga);
    PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate);
    void deletePenjaga(Long noPenjaga);
    PenjagaModel predictUmur(Long noPenjaga);
}
