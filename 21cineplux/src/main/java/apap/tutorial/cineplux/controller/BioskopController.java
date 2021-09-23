package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util. ArrayList;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop",new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopsubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.addBioskop(bioskop);
        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute ( "listBioskop", listBioskop);
        return "viewall-bioskop" ;
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();

        model.addAttribute( "bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);

        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop == null) {
            model.addAttribute( "pesan", "Bioskop dengan id " + noBioskop + " tidak ditemukan. GAGAL UPDATE BIOSKOP");
            return "message-error";
        }

        model.addAttribute( "bioskop",bioskop);
        return"form-update-bioskop" ;
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.updateBioskop(bioskop);
        model.addAttribute( "noBioskop",bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskop(
            @PathVariable Long noBioskop,
            Model model
    ){
        LocalTime curWaktu = LocalTime.now();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if (bioskop == null) {
            model.addAttribute( "pesan", "Bioskop dengan id " + noBioskop + " tidak ditemukan. GAGAL UPDATE BIOSKOP");
            return "message-error";
        }

        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        LocalTime waktuBuka = bioskop.getWaktuBuka();
        LocalTime waktuTutup = bioskop.getWaktuTutup();

        if (curWaktu.isAfter(waktuBuka) && curWaktu.isBefore(waktuTutup)){
            model.addAttribute( "pesan", "Bioskop dengan id " + noBioskop + " masih buka. GAGAL DELETE BIOSKOP");
            return "message-error";
        }

        for (PenjagaModel penjaga : listPenjaga) {
            if (penjaga.getBioskop().getNoBioskop() == noBioskop) {
                model.addAttribute( "pesan", "Bioskop dengan id " + noBioskop + " masih memiliki penjaga. GAGAL DELETE BIOSKOP");
                return "message-error";
            }
        }

        // Delete bioskop
        bioskopService.deleteBioskop(noBioskop);

        model.addAttribute( "pesan", "Bioskop dengan id " + noBioskop + " berhasil didelet");
        return"message" ;
    }
}