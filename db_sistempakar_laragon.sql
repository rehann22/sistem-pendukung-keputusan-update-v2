-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 20 Bulan Mei 2024 pada 10.37
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sistempakar`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `nama`, `email`, `password`) VALUES
('id01', 'Gibran', 'gibranraka@gmail.com', 'abc'),
('id02', 'Rehan', 'rehan@gmail.com', 'abc');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_gejala`
--

CREATE TABLE `tbl_gejala` (
  `kode_gejala` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `organ` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `gejala` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_gejala`
--

INSERT INTO `tbl_gejala` (`kode_gejala`, `organ`, `gejala`) VALUES
('G01', 'Insang', 'Selalu Terbuka '),
('G02', 'Insang', 'Bintik Putih Kemerahan '),
('G03', 'Insang', 'Bintik Putih '),
('G04', 'Insang', 'Berlendir '),
('G05', 'Insang', 'Bercak Merah '),
('G06', 'Insang', 'Penebalan '),
('G07', 'Insang', 'Pendarahan '),
('G08', 'Insang', 'Terselimuti Kapas '),
('G09', 'Kepala', 'Terselimuti Kapas '),
('G10', 'Kulit', 'Bercak Merah '),
('G11', 'Kulit', 'Pendarahan '),
('G12', 'Kulit', 'Borok '),
('G13', 'Organ Dalam', 'Pendarahan '),
('G14', 'Punggung ', 'Pendarahan '),
('G15', 'Sirip', 'Bercak Merah '),
('G16', 'Sirip', 'Rontok '),
('G17', 'Sirip', 'Terselimuti Kapas '),
('G18', 'Sirip', 'Rontok '),
('G19', 'Sisik', 'Terkelupas '),
('G20', 'Sisik', 'Melepuh '),
('G21', 'Sisik', 'Kusam '),
('G22', 'Sisik', 'Kesat '),
('G23', 'Tubuh', 'Bintik Putih '),
('G24', 'Tubuh', 'Berlendir '),
('G25', 'Tubuh', 'Kurus ');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_gejalapenyakit`
--

CREATE TABLE `tbl_gejalapenyakit` (
  `kode_gejala` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `kode_penyakit` varchar(15) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_gejalapenyakit`
--

INSERT INTO `tbl_gejalapenyakit` (`kode_gejala`, `kode_penyakit`) VALUES
('G01,G02,G14', 'P01'),
('G03,G04,G23,G24', 'P02'),
('G05,G10,G15,G25', 'P03'),
('G06,G16,G17,G19,G25', 'P04'),
('G08,G09,G17', 'P05'),
('G11,G12,G18', 'P07'),
('G13,G20,G21,G22', 'P06');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_hasil_diagnosa`
--

CREATE TABLE `tbl_hasil_diagnosa` (
  `id_user` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `id_konsultasi` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `kode_penyakit` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tanggal` date NOT NULL DEFAULT (curdate())
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_hasil_diagnosa`
--

INSERT INTO `tbl_hasil_diagnosa` (`id_user`, `id_konsultasi`, `kode_penyakit`, `tanggal`) VALUES
('Id02', 'K01', 'P06', '2024-04-09'),
('Id08', 'K02', 'P07', '2024-04-08'),
('Id06', 'K03', 'P02', '2024-04-18'),
('Id05', 'K04', 'p04', '2024-02-15'),
('Id02', 'K05', 'P07', '2024-02-15'),
('Id04', 'K06', 'P04', '2024-02-15'),
('Id04', 'K07', 'P04', '2024-03-02'),
('Id05', 'K08', 'P05', '2024-03-02'),
('Id07', 'K09', 'P07', '2024-04-05'),
('Id13', 'K10', 'P01', '2024-05-19'),
('Id09', 'K100', 'P04', '2024-05-19'),
('Id09', 'K101', 'P03', '2024-05-19'),
('Id09', 'K102', 'P03', '2024-05-19'),
('Id09', 'K103', 'P05', '2024-05-19'),
('Id09', 'K104', 'P05', '2024-05-19'),
('Id14', 'K105', 'P01', '2024-05-19'),
('Id02', 'K106', 'P01', '2024-05-19'),
('Id03', 'K107', 'P01', '2024-05-19'),
('Id03', 'K108', 'P05', '2024-05-19'),
('Id03', 'K109', 'P05', '2024-05-19'),
('Id05', 'K11', 'P05', '2024-04-05'),
('Id03', 'K110', 'P05', '2024-05-19'),
('Id03', 'K111', 'P01', '2024-05-19'),
('Id02', 'K112', 'P02', '2024-05-20'),
('Id13', 'K113', 'P02', '2024-05-20'),
('Id13', 'K114', 'P05', '2024-05-20'),
('Id14', 'K115', 'P01', '2024-05-20'),
('Id14', 'K116', 'P01', '2024-05-20'),
('Id14', 'K117', 'P02', '2024-05-20'),
('Id14', 'K118', 'P05', '2024-05-20'),
('Id14', 'K119', 'P05', '2024-05-20'),
('Id04', 'K12', 'P04', '2024-04-05'),
('Id02', 'K13', 'P06', '2024-04-05'),
('Id01', 'K14', 'P07', '2024-02-01'),
('Id01', 'K15', 'P03', '2024-02-08'),
('Id01', 'K16', 'P04', '2024-02-15'),
('Id06', 'K17', 'P05', '2024-03-20'),
('Id04', 'K18', 'P07', '2024-03-20'),
('Id01', 'K19', 'P03', '2024-02-08'),
('Id01', 'K20', 'P06', '2024-02-14'),
('Id05', 'K21', 'P03', '2024-03-20'),
('Id05', 'K22', 'P05', '2024-03-20'),
('Id02', 'K23', 'P02', '2024-03-20'),
('Id01', 'K24', 'P01', '2024-01-01'),
('Id02', 'K25', 'P03', '2024-01-01'),
('Id02', 'K26', 'P05', '2024-01-02'),
('Id02', 'K27', 'P02', '2024-03-06'),
('Id02', 'K28', 'P07', '2024-01-02'),
('Id01', 'K29', 'P03', '2024-01-02'),
('Id02', 'K30', 'P02', '2024-01-02'),
('Id01', 'K31', 'P04', '2024-01-02'),
('Id01', 'K32', 'P04', '2024-01-02'),
('Id03', 'K33', 'P01', '2024-01-02'),
('Id03', 'K34', 'P05', '2024-01-02'),
('Id04', 'K35', 'P03', '2024-01-03'),
('Id04', 'K36', 'P04', '2024-01-03'),
('Id01', 'K37', 'P06', '2024-01-04'),
('Id05', 'K38', 'P01', '2024-03-07'),
('Id05', 'K39', 'P07', '2024-03-08'),
('Id05', 'K40', 'P06', '2024-03-07'),
('Id07', 'K41', 'P06', '2024-03-09'),
('Id07', 'K42', 'P02', '2024-03-09'),
('Id06', 'K43', 'P01', '2024-03-09'),
('Id06', 'K44', 'P05', '2024-01-17'),
('Id01', 'K45', 'P05', '2024-04-04'),
('Id02', 'K46', 'P02', '2024-04-04'),
('Id02', 'K47', 'P05', '2024-04-04'),
('Id01', 'K48', 'P01', '2024-05-04'),
('Id07', 'K49', 'P10', '2024-05-04'),
('Id07', 'K50', 'P03', '2024-05-04'),
('Id07', 'K51', 'P04', '2024-05-04'),
('Id07', 'K52', 'P05', '2024-05-04'),
('Id07', 'K53', 'P01', '2024-05-05'),
('Id07', 'K54', 'P03', '2024-05-05'),
('Id07', 'K55', 'P04', '2024-05-05'),
('Id08', 'K56', 'P07', '2024-05-05'),
('Id08', 'K57', 'P06', '2024-04-03'),
('Id08', 'K58', 'P01', '2024-04-03'),
('Id08', 'K59', 'P02', '2024-04-03'),
('Id01', 'K60', 'P05', '2024-04-03'),
('Id07', 'K61', 'P07', '2024-04-03'),
('Id05', 'K62', 'P07', '2024-04-03'),
('Id01', 'K63', 'P01', '2024-04-03'),
('Id08', 'K64', 'P01', '2024-04-03'),
('Id06', 'K65', 'P01', '2024-04-03'),
('Id06', 'K66', 'P03', '2024-04-03'),
('Id06', 'K67', 'P01', '2024-04-03'),
('Id06', 'K68', 'P04', '2024-04-03'),
('Id06', 'K69', 'P03', '2024-05-09'),
('Id06', 'K70', 'P06', '2024-05-09'),
('Id06', 'K71', 'P07', '2024-05-09'),
('Id08', 'K72', 'P03', '2024-05-09'),
('Id08', 'K73', 'P04', '2024-05-09'),
('Id02', 'K74', 'P03', '2024-05-09'),
('Id02', 'K75', 'P02', '2024-05-09'),
('Id02', 'K76', 'P05', '2024-05-09'),
('Id02', 'K77', 'P01', '2024-05-09'),
('Id02', 'K78', 'P06', '2024-05-09'),
('Id03', 'K79', 'P01', '2024-05-09'),
('Id04', 'K80', 'P07', '2024-05-19'),
('Id04', 'K81', 'P07', '2024-05-19'),
('Id04', 'K82', 'P01', '2024-05-19'),
('Id04', 'K83', 'P01', '2024-05-19'),
('Id04', 'K84', 'P05', '2024-05-19'),
('Id04', 'K85', 'P05', '2024-05-19'),
('Id13', 'K86', 'P04', '2024-05-19'),
('Id13', 'K87', 'P04', '2024-05-19'),
('Id13', 'K88', 'P05', '2024-05-19'),
('Id13', 'K89', 'P05', '2024-05-19'),
('Id13', 'K90', 'P07', '2024-05-19'),
('Id13', 'K91', 'P07', '2024-05-19'),
('Id06', 'K92', 'P01', '2024-05-19'),
('Id06', 'K93', 'P01', '2024-05-19'),
('Id07', 'K94', 'P04', '2024-05-19'),
('Id07', 'K95', 'P04', '2024-05-19'),
('Id07', 'K96', 'P04', '2024-05-19'),
('Id09', 'K97', 'P01', '2024-05-19'),
('Id09', 'K98', 'P01', '2024-05-19'),
('Id09', 'K99', 'P04', '2024-05-19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penyakit`
--

CREATE TABLE `tbl_penyakit` (
  `kode_penyakit` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_penyakit` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsi` text COLLATE utf8mb4_general_ci NOT NULL,
  `gejala` text COLLATE utf8mb4_general_ci NOT NULL,
  `pencegahan` text COLLATE utf8mb4_general_ci NOT NULL,
  `obat` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_penyakit`
--

INSERT INTO `tbl_penyakit` (`kode_penyakit`, `nama_penyakit`, `deskripsi`, `gejala`, `pencegahan`, `obat`) VALUES
('P01', 'Bengkak Insang / Badan', 'Penyakit bengkak insang/badan adalah gangguan kesehatan ini disebabkan oleh mikrobakteria jenis Myxosporea. Penyakit ini membuat insang selalu terbuka, muncul pendarahan di punggung, dan bintik putih kemerahan', 'Insang selalu terbuka\nInsang bintik putih kemerahan\nPunggung mengalami pendarahan', 'Cara mengatasinya adalah mengeringkan kolam dan menaburkan kapur sebanyak 200 gram/m2 di dasar kolam', 'Kapur Tohor '),
('P02', 'Bintik Putih', 'Penyakit ini disebabkan oleh infeksi parasit jenis Ichthyophthirius multifiliis. Tandanya adalah munculnya bintik putih dan lendir pada insang dan tubuh ikan mas. Hal ini membuat ikan mas kesulitan bernapas dan bergerak', 'Insang terdapat bintik putih\nInsang terdapat lendir\nTubuh terdapat bintik putih\nTubuh terdapat lendir', 'Cara mengatasinya adalah dengan merendam ikan mas dalam larutan air garam (NaCl) sebanyak 1 – 3 gram per 100 cc air. Jangan lupa untuk menguras air kolam dan memberikan sirkulasi secara terus menerus.', 'Larutan air garam (NaCI)'),
('P03', 'Kutu', 'Penyakit kutu atau argulosis adalah masalah kesehatan pada ikan mas yang disebabkan oleh serangan kutu. Hal ini ditandai dengan adanya bercak merah di kulit, insang, dan sirip ikan', 'Insang terdapat bercak merah\nKulit terdapat bercak merah\nSirip terdapat bercak merah\nTubuh Kurus', 'Penyakit ini dapat dicegah dengan merendam ikan di larutan garam dapur berdosis 20 gram/liter air selama 15 menit', 'Larutan garam dapur'),
('P04', 'Cacing Insang & Kulit', 'Cacing insang dan kulit juga termasuk jenis penyakit ikan mas. Masalah kesehatan ini dipicu oleh serangan parasit jenis cacing Gyrodactylus dan Dactylogyrus', 'Tubuh kurus & Sisik terkelupas\nInsang mengalami penebalan\nSirip mengalami kerontokan\nSirip terselimuti kapas', 'Atasi dengan rendaman formalin atau methylene blue yang dicampur dengan air. sebanyak 250 gram/m3 selama 15 menit', 'Methylene Blue / Formalin'),
('P05', 'Jamur Saprolegniasis', 'Infeksi jamur Saprolegniasis terjadi pada insang, kepala, dan sirip, Ikan yang terinfeksi jamur ini akan tampak mempunyai kapas di tubuhnya', 'Insang terselimuti kapas\nKepala terselimuti kapas\nSirip terselimuti kapas', 'Untuk menghilangkan jamur tersebut, kamu bisa merendam ikan mas ke dalam larutan malachite green oxalat dengan dosis 3 gram per meter kubik air selama 30 menit', 'Malachite Green Oxalat  '),
('P06', 'Bakteri Aeromonas Punctata ', 'Bakteri ini termasuk bakteri yang berbahaya karena membuat ikan menjadi kusam, kesat, dan terlihat megap-megap seperti kekurangan oksigen. Tubuh ikan akan menggembung karena terjadi pendarahan organ dalamnya seperti hati dan ginjal', 'Organ dalam pendarahan\nSisik melepuh\nSisik kusam\nSisik kesat', 'Untuk mengatasi bakteri ini, Anda bisa memberikan Terramycine dengan dosis 50 mg/kg per hari. Anda bisa mencampurkan pada pakan ikan dan berikan selama 7 – 10 hari berturut-turut', 'Terramycine 50 mg/kg per hari'),
('P07', 'Bakteri Pseudomas Fluoroscens ', 'Penyakit ini memiliki gejala hampir serupa dengan bakteri Aeromonas yaitu ikan mengalami pendarahan organ dalam. Lambat laun, sirip ikan akan terkikis dan mengalami kerontokan', 'Kulit pendarahan\nKulit borok\nSirip rontok', 'Untuk mengatasinya, kamu bisa mencampurkan Oxytetracycline sebanyak 25-30 mg per 1 kg pakan ikan. Lakukanlah cara tersebut secara rutin selama 7-10 hari', 'Oxytetracycline'),
('P08', 'ggg', 'ggg', 'ggg', 'gg', 'ggg'),
('P09', 'nn', 'nn', 'nnn', 'nn', 'nn');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_users`
--

CREATE TABLE `tbl_users` (
  `id` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `nama`, `username`, `password`) VALUES
('Id01', 'Rehan', 'rehan', 'abc'),
('Id02', 'Keisha', 'eca', 'abc'),
('Id03', 'Anggie', 'angi', 'abc'),
('Id04', 'Ikbal', 'ikbal', 'abc'),
('Id05', 'Nadia', 'nadia', 'abc'),
('Id06', 'Ajeng', 'ajeng', 'abc'),
('Id07', 'Kika', 'kika', 'abc'),
('Id08', 'Rendi', 'rendi', 'abc'),
('Id09', 'Rio', 'rio', 'abc'),
('Id10', 'Anto', 'anto', 'abc'),
('Id11', 'Ariel', 'ariel', 'abc'),
('Id12', 'Samsul', 'samsul', 'abc'),
('Id13', 'Ahmad', 'ahmad', 'abc'),
('Id14', 'Rizki', 'bejo', 'abc'),
('Id15', 'Agil', 'agil', 'abc');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `tbl_gejala`
--
ALTER TABLE `tbl_gejala`
  ADD PRIMARY KEY (`kode_gejala`);

--
-- Indeks untuk tabel `tbl_gejalapenyakit`
--
ALTER TABLE `tbl_gejalapenyakit`
  ADD PRIMARY KEY (`kode_penyakit`),
  ADD KEY `FK_kodeGejala` (`kode_gejala`);

--
-- Indeks untuk tabel `tbl_hasil_diagnosa`
--
ALTER TABLE `tbl_hasil_diagnosa`
  ADD PRIMARY KEY (`id_konsultasi`),
  ADD KEY `fk_hasilDiagnosa_user` (`id_user`);

--
-- Indeks untuk tabel `tbl_penyakit`
--
ALTER TABLE `tbl_penyakit`
  ADD PRIMARY KEY (`kode_penyakit`);

--
-- Indeks untuk tabel `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`id`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tbl_gejalapenyakit`
--
ALTER TABLE `tbl_gejalapenyakit`
  ADD CONSTRAINT `fk_gejala_penyakit` FOREIGN KEY (`kode_penyakit`) REFERENCES `tbl_penyakit` (`kode_penyakit`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_hasil_diagnosa`
--
ALTER TABLE `tbl_hasil_diagnosa`
  ADD CONSTRAINT `fk_hasilDiagnosa_user` FOREIGN KEY (`id_user`) REFERENCES `tbl_users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
