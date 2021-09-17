package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //Method untuk menambah bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar Bioskop yang tersimpan
    List<BioskopModel> getBioskopList();

    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
    BioskopModel getBioskopByIdBioskop(String idBioskop);
}
