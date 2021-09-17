package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variable id bioskop ke "idbioskop" untuk di render ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model){
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke "listBioskop" untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            model.addAttribute("messageError", "Bioskop dengan id " + idBioskop + " tidak ditemukan");
            return "error-bioskop";
        }

        //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @RequestMapping(value="/bioskop/view/id-bioskop/{idBioskop}")
    public String viewBioskopWithPathVariable(
            @PathVariable(value = "idBioskop") String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            model.addAttribute("messageError", "Bioskop dengan id " + idBioskop + " tidak ditemukan, VIEW GAGAL");
            return "error-bioskop";
        }

        //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }


    @RequestMapping(value="/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateBioskop(
            @PathVariable(value = "idBioskop") String idBioskop,
            @PathVariable(value = "jumlahStudio") int jumlahStudio,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null){
            model.addAttribute("messageError", "Bioskop dengan id " + idBioskop + " tidak ditemukan, UPDATE GAGAL");
            return "error-bioskop";
        }

        //Update jumlahStudio pada biskop
        bioskopModel.setJumlahStudio(jumlahStudio);

        //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "update-bioskop";
    }

    @RequestMapping(value="/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop") String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Menghapus bioskop jika ada
        for (int i = 0; i < listBioskop.size(); i++) {
            if (listBioskop.get(i).getIdBioskop().equals(idBioskop)) {
                listBioskop.remove(i);
                model.addAttribute("message", "Bioskop dengan id " + idBioskop + " berhasil didelete");
                return "delete-bioskop";
            }
        }
        //Add message untuk dirender dalam thymeleaf
        model.addAttribute("messageError", "Bioskop dengan id " + idBioskop + " tidak ditemukan, DELETE GAGAL");
        return "error-bioskop";
    }
}
