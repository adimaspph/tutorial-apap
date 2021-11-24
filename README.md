# Tutorial APAP

## Authors

* Adimas Putra Pratama Hendrata - 1906305575 - C

---
## PERTANYAAN TUTORIAL 7

### Pertanyaan 1
Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
- Nomor 1: Menghapus item pada My Cart ketika button delete di click atau dipencet. Kemudian pada list item tombol keranjang akan muncul kembali.
    ![image](https://cdn.discordapp.com/attachments/751758743418437706/913083553472974868/unknown.png)

- Nomor 2: Membuat account balance menjadi bekurang seteleh user memasukan item kedalam keranjang. Kemudian saat user mengeluarkan barang dari keranjang, maka balance akan bertambah kembali sesuai dengan harga barang tersebut.
    Pada add item:
    ![image](https://cdn.discordapp.com/attachments/751758743418437706/913084353502924820/unknown.png)
    Pada remove item:
    ![image](https://cdn.discordapp.com/attachments/751758743418437706/913084672974651392/unknown.png)

- Nomor 3: Membuat alert (peringatan) jika item yang akan dimasukan melebihi balance yang dimiliki user, sehingga item tersebut tidak dapat di masukkan pada keranjang belanjaan.
    ![image](https://cdn.discordapp.com/attachments/751758743418437706/913085097538879578/unknown.png)


### Pertanyaan 2
Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
- Props adalah variabel yang didefinisikan pada parent class dan diteruskan pada komponen lain (jadi penghubung dan bisa digunakan oleh komponen parentnya)
- State adalah variabel yang terdapat pada komponen

### Pertanyaan 3
Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
- Sebaiknya kita menggunakan component karena component dapat digunakan berkali-kali sehingga tidak terjadi redudansi code pada react. Dengan memakai component, kita juga bisa menuliskan apa saja isi dari componen tersebut. Sebagai contoh pada tutorial kali ini kita menggunakan component item berulang kali sehingga home/index.js menjadi sangat singkat karena tidak perlu code yang duplikat.

### Pertanyaan 4
Apa perbedaan class component dan functional component?
#### Class Component
- Komponen dan buat fungsi render yang mengembalikan elemen React
- kelas ES6 reguler yang memperluas perpustakaan reaksi bentuk kelas komponen
- Juga dikenal sebagai komponen “stateful” karena mengimplementasikan logika dan state.
- Itu harus memiliki metode render() yang mengembalikan html
- Ini memiliki Logika UI yang kompleks
- Mengakses props menggunakan this.props

#### Funtional Component
- hanyalah fungsi JavaScript biasa yang menerima props sebagai argumen dan mengembalikan elemen React
- fungsi javascript sederhana yang hanya mengembalikan UI html
- disebut komponen "stateless" karena mereka hanya menerima data dan menampilkannya dalam beberapa bentuk yang terutama bertanggung jawab untuk merender UI.
- menerima properti (alat peraga) dalam fungsi dan mengembalikan html (JSX)
- memberikan solusi tanpa menggunakan status
- Tidak ada metode render yang digunakan dalam komponen fungsional.
- biasanya dapat didefinisikan menggunakan fungsi panah tetapi juga dapat dibuat dengan kata kunci fungsi reguler.

### Pertanyaan 5
Dalam react, apakah perbedaan component dan element?
- React Element adalah objek sederhana yang menggambarkan simpul DOM dan atribut atau propertinya yang dapat Anda katakan. Ini adalah objek deskripsi yang tidak dapat diubah dan Anda tidak dapat menerapkan metode apa pun di atasnya.
- React Component adalah fungsi atau kelas yang menerima input dan mengembalikan elemen React. Itu harus menyimpan referensi ke node DOM dan ke instance komponen anak.

----

## PERTANYAAN TUTORIAL 6

### Pertanyaan 1
Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kodeyang telah anda buat) konsep tersebut diimplementasi?
- Otorisasi adalah proses menentukan apakah pengguna saat ini diperbolehkan untuk melakukan tugas tertentu atau tidak. Contoh dalam implementasi adalah bagaimana hanya seorang admin yang dapat melihat dan menambah user, serta manager yang dapat mengatur penjaga bioskop.
- Hal tersebut berada pada bagian .antMatchers("/user/viewall/**").hasAnyAuthority("ADMIN") dan .antMatchers("/penjaga/add/**").hasAnyAuthority("MANAGER")
- Otentikasi adalah proses identifikasi pengguna. Ada beberapa aplikasi web memberikan kombinasi nama user/password atau email, melalui pihak ketiga, seperti lewat akun Twitter atau Facebook. Pengguna yang tampa melalui otentikasi disebut anonymous, atau guest/tamu. Terkait dengan otentikasi otorisasi. Contoh dalam implementasi adalah pengguna dapat login dalam dengan memasukan username dan password.
- Hal tersebut berada pada bagian auth.userDetailsService(userDetailsService).passwordEncoder(encoder())

### Pertanyaan 2
Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
- BCryptPasswordEncoder berguna untuk mengenkripsi sehingga password tidak diketahui walaupun sudah dilihat di databse. BCryptPasswordEncoder mengencrypt Password Raw menjadi String yang sudah di acak agar tidak mudah dilihat admin.

### Pertanyaan 3
Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
- Hashing adalah fungsi satu arah (yah, pemetaan). Ini tidak dapat diubah, Anda menerapkan algoritma hash aman dan Anda tidak bisa mendapatkan kembali string asli.
- Enkripsi adalah fungsi yang tepat (dua arah). Ini dapat dibalik, Anda dapat mendekripsi string yang rusak untuk mendapatkan string asli jika Anda memiliki kuncinya.
- Dalam hal password lebih aman jika menggunakan hashing karena setelah di hashing, password tidak dapat dilihat kembali. Jika user lupa dengan password lama, mereka bisa mereplace password dengan yang baru.

### Pertanyaan 4
Jelaskan secara singkat apa itu UUID beserta penggunaannya!
- Universally unique identifier (UUID) digunakan untuk mengidentifikasi secara unik beberapa objek atau entitas di Internet. Bergantung pada mekanisme spesifik yang digunakan, UUID dijamin berbeda atau, paling tidak, sangat mungkin berbeda dari UUID lain yang ada. UUID digunakan untuk meningkatkan keamanan data pengguna dikarenakan id pengguna akan digenerate secara unik dengan hashing sebanyak 32 karakter secara acak sehingga id pengguna aman dan tidak mudah untuk diretas.

### Pertanyaan 5
Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
- UserDetailsService adalah interface inti dalam Spring Security. UserDetailsService digunakan untuk mengambil informasi otentikasi dan otorisasi pengguna. Ini memiliki metode baca-saja tunggal bernama loadUserByUsername() yang mencari pengguna berdasarkan nama pengguna.


---
## PERTANYAAN TUTORIAL 5

### Pertanyaan 1
Apa itu Postman? Apa kegunaannya?
- Postman adalah aplikasi yang digunakan untuk pengujian API. Ini adalah klien HTTP yang menguji permintaan HTTP, menggunakan antarmuka pengguna grafis, yang melaluinya kami memperoleh berbagai jenis respons yang perlu divalidasi selanjutnya.

### Pertanyaan 2
Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
- @JsonProperty untuk menunjukkan nama properti di JSON.
- @JsonIgnoreProperties mengabaikan properti logis yang ditentukan dalam serialisasi dan deserialisasi JSON. Hal ini dijelaskan di tingkat kelas. Temukan cuplikan kode.

### Pertanyaan 3
Apa kegunaan atribut WebClient?
- WebClient adalah antarmuka yang mewakili titik masuk utama untuk melakukan permintaan web. Webclient digunakan untuk mendapatkan hasil API dari url yang telah didefinisikan.

### Pertanyaan 4
Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
- BindingResult adalah antarmuka yang menentukan bagaimana objek yang menyimpan hasil validasi harus menyimpan dan mengambil hasil validasi (kesalahan, upaya untuk mengikat ke bidang yang tidak diizinkan, dll)
- ResponseEntity mewakili respons HTTP, termasuk header, isi, dan status. Sementara @ResponseBody menempatkan nilai kembalian ke dalam isi respons, ResponseEntity juga memungkinkan kita untuk menambahkan header dan kode status.

---

## PERTANYAAN TUTORIAL 4

### Pertanyaan 1
Jelaskan perbedaan th:include dan th:replace!
- th:replace -> Akan menggantikan tag host dengan fragmen. Itu berarti, Ini akan menghapus tag host dan sebagai ganti tag host, yang berarti akan menambahkan fragmen yang ditentukan termasuk tag fragmen
- th:include -> Akan menyisipkan fragmen yang ditentukan sebagai badan tag hostnya tetapi mengecualikan tag fragmen

### Pertanyaan 2
Jelaskan apa fungsi dari th:object!
- th:object digunakan untuk menentukan objek yang akan diikat oleh data formulir yang dikirimkan. Masing-masing bidang dipetakan menggunakan atribut th:field="*{name}", di mana nama adalah properti objek yang cocok

### Pertanyaan 3
Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
- $ digunakan untuk mengambil atribut yang dipassing kedalam templat. Dengan dolar kita harus mendefinisikan objectnya terlebih dahulu untuk mengakses attributnya
- \* digunakan untuk mengambil atribut didalam object yang telah didefinisikan sebelumnya pada th:object
- Jika kita ingin mengakses atribut pada th:object, disarankan menggunakan * agar tidak perlu menyebutkan ulang objectnya sehingga memangkas program
- Jika artibut yang ingin kita akses tidak ada dalam th:object gunakanlah $ agar dapat mengakses object tersebut

---

## PERTANYAAN TUTORIAL 3

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

