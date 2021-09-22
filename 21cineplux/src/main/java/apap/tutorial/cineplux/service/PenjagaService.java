package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);

    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);

    public void updatePenjaga(PenjagaModel penjaga);

    public void deletePenjaga(Long noPenjaga);
}
