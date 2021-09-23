# Tutorial APAP

## Authors

* Adimas Putra Pratama Hendrata - 1906305575 - C

---

## PERTANYAAN TUTORIAL 2
### Pertanyaan 1
Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
- @Getter @Setter digunakan agar kita tidak perlu membuat getter dan setter lagi untuk class yang kita buat. Hal ini akan memudahkan developer untuk membaca code yang penting saja.
- @NoArgsConstructor akan menghasilkan konstruktor tanpa parameter.
- @AllArgsConstructor menghasilkan konstruktor dengan 1 parameter untuk setiap field di class. Field yang ditandai dengan @NonNull menghasilkan pemeriksaan nol pada parameter tersebut.
- @Entity untuk mendefinisikan bahwa class tersebut adalah entity pada databases.
- @Table: Secara default, entitas yang kita definisikan akan dipetakan ke tabel dnegan nama yang telah ditentukan. Jika ingin menamai table dengan yang kita inginkan, maka kita harus menambahkan @Table

### Pertanyaan 2
Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?
- Method tersebut berguna untuk mencari dan mengembalikan objek bioskop yang sesuai dnegan noBioskop yang ditentukan

### Pertanyaan 3
Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
- @JoinTable menyimpan id dari kedua tabel ke dalam tabel terpisah.
- @JoinColumn menyimpan id dari tabel lain di kolom yang baru.

### Pertanyaan 4
Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
- name: untuk mendefinisikan nama kolom (foreignKey).
- referencedColumnName: mendefinisikan dari colom mana yang akan dijoin.
- nullable: untuk mendefinisikan boleh null apa tidak pada hasil joinnya.
- @NotNull: Agar kolom tidak boleh null.

### Pertanyaan 5
Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
- FetchType.LAZY : pola desain yang digunakan untuk menunda inisialisasi objek selama mungkin. Jika kita mengambil objek, maka tidak akan diinisialisasi dan dimuat ke dalam memori hingga panggilan eksplisit dibuat untuk itu.
- FetchType.EAGER : pola desain di mana inisialisasi data terjadi secara on spot. Jika kita membuat sebuah objek, maka semua data yang berhubungan dengan objek tersebut akan tersimpan di memory.
- EAGER lebih cepat namun boros memori, sedangkan LAZY lambat namun hemat memori
- CascadeType.ALL: Melakukan semua operasi cascade yang ada. (Persist: mempertahankan suatu entitas beserta entitas pada field, Remove: menghapus sebuah entity pada field, Refresh: refresh sebuah entitas pada field, dan merge: menggabungkan sebuah entitas pada field.


---


## PERTANYAAN TUTORIAL 2

### Pertanyaan 1
Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
- Terjadi error karena belum pada controller saya telah menyantumkan "view" pada *Controller* namun belum membuatnya pada *Templates*.

### Pertanyaan 2
Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
- Spring Framework menyediakan fitur component-scan, yaitu dia akan melihat isi package yang kita sebutkan, kemudian akan mencari class-class yang diberi anotasi berikut: @Repository, @Service, @Controller, @Component
- @Autowired digunakan untuk melakukan inject instance dari suatu bean ke objek yang memiliki dependency.

### Pertanyaan 3
Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
- Terjadi error karena tidak terdapat jumlah studio pada link diatas.

### Pertanyaan 4
Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
- Pertama saya asumsikan Bioskop dengan nama Bioskop Maung telah berada pada data base. Kita bisa melihat nomor ID dengan mengakses  http://localhost:8080/bioskop/viewall.
- Asumsikan Bioskop Maung memiliki ID 1, maka untuk melihat kita dapat mengakses http://localhost:8080/bioskop/view?idBioskop=1

### Pertanyaan 5
Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
- Karena saya telah membuat method pada controller untuk menghandle URL tersebut, maka browser akam menampilkan semua list bioskop yang ada pada data base.
- Berikut screenshotnya https://cdn.discordapp.com/attachments/751758743418437706/887651841666580500/unknown.png

----

## Pertanyaan Tutorial 1
### What I have learned today
Springboot adalah framework dari java yang memiliki cara kerja MVC (model, view, controller) dimana model sebagai otak dari aplikasi dan view adalah tempat untuk mengatur tampilan dari aplikasi, sedangkan controller sebagai jembatan yang menjembatani model dengan view. 

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue tracker dapat bekerja sebagai to do list. Masalah-masalah yang ada dapat ditampilkan disana dan dapat dikerjakan bersama tim

2. Apa perbedaan dari git merge dan git merge --squash?
- **git merge** akan merge dengan commit-commitnya
- **git merge --squash** adalah merge yang lebih rapih karena commit commit sebelumnya akan hilang dan hanya menyisakan commit akhir saja

4. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Terdapat beberapa manfaat menggunakan Version Control System seperti git atara lain adalah
- Developer dapat mengulang versi sebelumnya jika memang diperlukan
- Tim dapat mengembangkan versi programnya masing-masing yang nanti akhirnya akan dimerge menjadi satu kesatuan
- Dapat mengerjakan program dimanapun karena data disimpan pada cloud
- Developer dapat melihat apa saja yang diubah dan dihapus pada versi yang baru

### Spring
4. Apa itu library & dependency?
Dependency yang sangat dibutuhkan oleh suatu library lain. Contohnya adalah library spring yang membutuhkan library lain agar bisa berjalan, maka hal tersebut dapat disebut dependency.

6. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah Java Build Tools yang menggunakan konsep Project Object Model (POM). POM tersebut berisi informasi dan konfigurasi yang digunakan Maven untuk membuat project. Pada dasarnya POM adalah sebuath XML File yang terdapat di dalam project Maven dan di dalam File inilah konfigurasi dari project kita berada. Maven dapat kita gunakan untuk membuat struktur projek sendiri sehingga projek tersebut dapat dibukan oleh berbagai macam IDE lain. Selain itu, dengan adanya maven, memanage dependency jadi lebih mudah. Untuk springboot kita dapat menggunakan gradle sebagai alternatif maven.

8. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Selain untuk membuat web, springboot framework dapat digunakan untuk membuat API. Selain itu framework ini juga dapat membuat aplikasi berbasis java seperti discord.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
Kedua cara ini sebenarnya dapat digunakan untuk passing data menggunakan methode GET.
- @RequestParam digunakan untuk mengekstrak suatu nilai dari query string, data terencode.
- @PathVariable digunakan untuk mengekstrak suatu nilai dari URI Path, data tidak terencode.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Cara membuat aplikasi berbasis website dengan springboot
- [ ] Membuat atau memakai API

----

