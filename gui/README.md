# Kasir Sederhana

Nama: (isi nama)
NIM: (isi NIM)

## 1. Deskripsi Aplikasi

Kasir Sederhana adalah aplikasi desktop berbasis Java Swing untuk membantu mencatat pesanan dan menghitung total belanja. Pengguna dapat memilih menu, memasukkan jumlah pesanan, lalu menambahkannya ke struk. Total belanja dihitung secara otomatis dan pengguna dapat mengaktifkan diskon member sebesar 10%. Aplikasi juga menyediakan fitur reset untuk memulai transaksi baru.

Rumus perhitungan total:

Subtotal = jumlah (harga menu × jumlah pesanan)
Total = subtotal (tanpa member)
Total = subtotal × 90% (dengan member)

Daftar menu yang tersedia:

| Menu | Harga |
|---|---|
| Nasi Goreng | Rp 15.000 |
| Mie Goreng | Rp 13.000 |
| Es Teh | Rp 5.000 |

## 2. Fitur Aplikasi

- Memilih menu dari daftar menu.
- Memasukkan jumlah pesanan.
- Menambahkan pesanan ke struk.
- Menampilkan rincian pesanan pada area struk.
- Menghitung total belanja secara otomatis.
- Memberikan diskon member 10% menggunakan checkbox.
- Menghitung ulang total secara langsung saat status member diubah.
- Mereset transaksi (mengosongkan struk dan total).
- Menampilkan pesan peringatan jika jumlah yang dimasukkan bukan angka.

## 3. Teknologi

- Bahasa pemrograman: Java
- Library GUI: Java Swing
- Library pendukung: Java AWT
- IDE: (isi IDE yang digunakan, misalnya Visual Studio Code)
- JDK: Java Development Kit

## 4. Komponen GUI

### Top-Level Container

- `JFrame`: digunakan sebagai jendela utama aplikasi Kasir Sederhana.
- `JOptionPane`: digunakan untuk menampilkan pesan peringatan kepada pengguna.

### Intermediate Components

- `JPanel`: mengelompokkan komponen berdasarkan bagian tampilan, yaitu panel input pesanan dan panel total di bagian bawah.
- `JScrollPane`: menyediakan area yang dapat digulir untuk melihat struk pesanan.

### Atomic Components

- `JLabel`: menampilkan label input (Menu dan Jumlah) serta total belanja.
- `JComboBox`: menyediakan pilihan menu makanan dan minuman.
- `JTextField`: menerima input jumlah pesanan.
- `JCheckBox`: menentukan status member untuk diskon 10%.
- `JButton`: menjalankan tindakan Tambah dan Reset.
- `JTextArea`: menampilkan rincian pesanan (struk).

## 5. Layout Manager

### BorderLayout

Mengatur komponen pada bagian utara, selatan, timur, barat, dan tengah. Pada aplikasi ini, BorderLayout digunakan pada frame utama: panel input di bagian NORTH, area struk di bagian CENTER, dan panel total di bagian SOUTH.

### GridLayout

Menyusun komponen dalam bentuk baris dan kolom dengan ukuran sel yang sama. Pada aplikasi ini, GridLayout (4 baris × 2 kolom) digunakan untuk menyusun form input yang berisi menu, jumlah, checkbox member, dan tombol.

### FlowLayout

Menyusun komponen secara berurutan dalam satu baris. Pada aplikasi ini, FlowLayout digunakan pada panel bawah untuk menampilkan label total belanja.

## 6. Event Handling

Aplikasi ini menerapkan Delegation Event Model untuk menangani interaksi pengguna. Terdapat dua interface yang digunakan, yaitu `ActionListener` yang diimplementasikan langsung oleh class `KasirApp`, dan `ItemListener` yang dipasang menggunakan anonymous inner class.

### ActionListener

`ActionListener` digunakan untuk menangani aksi ketika tombol ditekan.

- `actionPerformed(ActionEvent e)`: menangani aksi pada tombol Tambah dan Reset.
- `e.getSource()`: digunakan untuk mengetahui tombol yang memicu event.
- Tombol Tambah menghitung harga pesanan, menambahkannya ke struk, dan memperbarui total.
- Tombol Reset mengosongkan struk dan mengembalikan total menjadi nol.
- `Integer.parseInt()` dibungkus `try-catch` untuk menangkap `NumberFormatException` jika jumlah bukan angka.

### ItemListener

`ItemListener` digunakan untuk menangani perubahan status pada checkbox.

- `itemStateChanged(ItemEvent e)`: dijalankan setiap kali checkbox member dicentang atau dilepas.
- Ketika status berubah, program memanggil method `hitungTotal()` sehingga total belanja langsung diperbarui dengan atau tanpa diskon 10%.

## 7. Cara Menjalankan

Pastikan Java Development Kit (JDK) sudah terpasang dan terminal berada di folder tempat file `KasirApp.java` disimpan.

Kompilasi program:

```bash
javac KasirApp.java
```

Jalankan program:

```bash
java KasirApp
```

Jika diperlukan, program juga dapat dijalankan menggunakan:

```bash
java -cp . KasirApp
```

## Struktur Proyek

```
Tugas GUI/
├── KasirApp.java
├── README.md
└── screenshot/
    ├── awal.png
    ├── validasi.png
    └── hasil.png
```

Keterangan:

- `KasirApp.java`: berisi kode sumber aplikasi Kasir Sederhana.
- `README.md`: berisi deskripsi aplikasi, fitur, komponen GUI, event handling, dan cara menjalankan program.
- `screenshot/awal.png`: dokumentasi tampilan awal aplikasi.
- `screenshot/validasi.png`: dokumentasi pesan peringatan ketika jumlah bukan angka.
- `screenshot/hasil.png`: dokumentasi tampilan setelah pesanan ditambahkan dan diskon member aktif.

## Penyimpanan Data

Data pesanan disimpan sementara di memori selama aplikasi berjalan. Rincian pesanan ditampilkan pada komponen `JTextArea`, sedangkan nilai subtotal disimpan menggunakan variabel `subtotal`. Data tidak disimpan ke database atau file permanen, sehingga data transaksi akan hilang ketika aplikasi ditutup atau di-reset.

## Dokumentasi Screenshot

### Tampilan Awal

Menampilkan tampilan awal aplikasi Kasir Sederhana sebelum ada pesanan, termasuk pilihan menu, jumlah, checkbox member, dan total Rp 0.

![Tampilan Awal](screenshot/awal.png)

### Validasi Input

Menampilkan pesan peringatan ketika pengguna memasukkan data yang tidak valid. Pada contoh ini, jumlah diisi dengan huruf sehingga aplikasi menampilkan pesan "Jumlah harus angka!".

![Validasi Input](screenshot/validasi.png)

### Hasil Perhitungan

Menampilkan rincian pesanan pada struk beserta total belanja, termasuk saat diskon member diaktifkan.

![Hasil Perhitungan](screenshot/hasil.png)