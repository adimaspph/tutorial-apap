package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class PenjagaController {

    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagasubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ){
        LocalTime curWaktu = LocalTime.now();
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);

        LocalTime waktuBuka = penjaga.getBioskop().getWaktuBuka();
        LocalTime waktuTutup = penjaga.getBioskop().getWaktuTutup();

        if (curWaktu.isAfter(waktuBuka) && curWaktu.isBefore(waktuTutup)){
            model.addAttribute( "pesan", "Bioskop dengan id " + penjaga.getBioskop().getNoBioskop() + " masih buka. GAGAL UPDATE PENJAGA");
            return "message-error";
        }

        model.addAttribute( "penjaga", penjaga);
        return"form-update-penjaga" ;
    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.updatePenjaga(penjaga);
        model.addAttribute( "pesan", "Penjaga dengan id " + penjaga.getNoPenjaga() + " berhasil diupdate");
        return "message";
    }

    @GetMapping("/penjaga/delete/{noPenjaga}")
    public String deletePenjaga(
            @PathVariable Long noPenjaga,
            Model model
    ){
        LocalTime curWaktu = LocalTime.now();
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        LocalTime waktuBuka = penjaga.getBioskop().getWaktuBuka();
        LocalTime waktuTutup = penjaga.getBioskop().getWaktuTutup();

        if (curWaktu.isAfter(waktuBuka) && curWaktu.isBefore(waktuTutup)){
            model.addAttribute( "pesan", "Bioskop dengan id " + penjaga.getBioskop().getNoBioskop() + " masih buka. GAGAL DELETE PENJAGA");
            return "message-error";
        }

        penjagaService.deletePenjaga(noPenjaga);

        model.addAttribute( "pesan", "Penjaga dengan id " + noPenjaga + " berhasil didelete");
        return "message";
    }
}