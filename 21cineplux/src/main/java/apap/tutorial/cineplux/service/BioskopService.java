package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //Method untuk menambah bioskop
    void addBioskop(BioskopModel bioskop);

    void updateBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    public void deleteBioskop(Long noBioskop);
}
