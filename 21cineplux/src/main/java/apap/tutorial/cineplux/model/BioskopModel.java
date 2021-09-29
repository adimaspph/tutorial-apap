package apap.tutorial.cineplux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "bioskop")
public class BioskopModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noBioskop;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String namaBioskop;

    @NotNull
    @Size(max=50)
    @Column(nullable = false)
    private String alamatBioskop;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahStudio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    //Relasi dengan PenjagaModel
    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenjagaModel> listPenjaga;

    //Relasi dengan FilmModel
    @ManyToMany
    @JoinTable(
            name = "film_bioskop",
            joinColumns = @JoinColumn(name = "no_bioskop"),
            inverseJoinColumns = @JoinColumn(name = "no_film")
    )
    List<FilmModel> listFilm;

//    public Long getNoBioskop() {
//        return noBioskop;
//    }
//
//    public void setNoBioskop(Long noBioskop) {
//        this.noBioskop = noBioskop;
//    }
//
//    public String getNamaBioskop() {
//        return namaBioskop;
//    }
//
//    public void setNamaBioskop(String namaBioskop) {
//        this.namaBioskop = namaBioskop;
//    }
//
//    public String getAlamatBioskop() {
//        return alamatBioskop;
//    }
//
//    public void setAlamatBioskop(String alamatBioskop) {
//        this.alamatBioskop = alamatBioskop;
//    }
//
//    public Integer getJumlahStudio() {
//        return jumlahStudio;
//    }
//
//    public void setJumlahStudio(Integer jumlahStudio) {
//        this.jumlahStudio = jumlahStudio;
//    }
//
//    public LocalTime getWaktuBuka() {
//        return waktuBuka;
//    }
//
//    public void setWaktuBuka(LocalTime waktuBuka) {
//        this.waktuBuka = waktuBuka;
//    }
//
//    public LocalTime getWaktuTutup() {
//        return waktuTutup;
//    }
//
//    public void setWaktuTutup(LocalTime waktuTutup) {
//        this.waktuTutup = waktuTutup;
//    }
//
//    public List<PenjagaModel> getListPenjaga() {
//        return listPenjaga;
//    }
//
//    public void setListPenjaga(List<PenjagaModel> listPenjaga) {
//        this.listPenjaga = listPenjaga;
//    }
}
