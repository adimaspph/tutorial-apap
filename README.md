# Tutorial APAP

## Authors
* Adimas Putra Pratama Hendrata - 1906305575 - C

---
## Tutorial 1
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