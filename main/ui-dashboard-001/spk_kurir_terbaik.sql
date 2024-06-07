-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 07 Jun 2024 pada 14.47
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
-- Database: `spk_kurir_terbaik`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_data_kurir`
--

CREATE TABLE `tbl_data_kurir` (
  `id_kurir` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `no_telp` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_bergabung` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_data_kurir`
--

INSERT INTO `tbl_data_kurir` (`id_kurir`, `nama`, `alamat`, `email`, `no_telp`, `tgl_bergabung`) VALUES
('0124.4459', 'Alviansyah Riyandi Niode', 'Jl. Diponegoro No. 20', 'alviansyah@gmail.com', '0834567890', '2024-01-23'),
('0224.4078', 'Aliv Pratama', 'Jl. Merdeka No. 10', 'alivpratama@gmail.com', '0812345678', '2024-02-21'),
('0224.4094', 'Amin Faoji Putra Pratama', 'Jl. Sudirman No. 25', 'aminpratama@gmail.com', '0845678901', '2024-02-21'),
('0321.2523', 'Andhika Pandu Abi Manyu', 'Jl. Hayam Wuruk No. 40', 'andhikapandu@gmail.com', '0878901234', '2021-03-15'),
('0321.2561', 'Angga Darmawan', 'Jl. Pemuda No. 95', 'anggadarmawan@gmail.com', '0887654321', '2021-03-22'),
('0324.5232', 'Amirul Ramadhan', 'Jl. Gajah Mada No. 30', 'amirulramadhan@gmail.com', '0856789012', '2024-03-21'),
('0324.5233', 'Anggi Dio Rizki Saputra', 'Jl. Dipati Ewang No. 100', 'anggidio@gmail.com', '0876543210', '2024-03-21'),
('0324.5260', 'Raby Muhamad Hadi', 'Jl. Dipati Ukur No. 70', 'rabymuhamad@gmail.com', '0932109876', '2024-03-21'),
('0324.5280', 'Andika', 'Jl. Raden Saleh No. 55', 'andika@gmail.com', '0965432109', '2024-03-21'),
('0324.5281', 'Andika Nova Suryadi', 'Jl. WR Supratman No. 60', 'andikanovasuryadi@gmail.com', '0954321098', '2024-03-21'),
('0423.3561', 'Anggoro Dwi Cahyono', 'Jl. Riau No. 105', 'anggorodwi@gmail.com', '0865432109', '2023-04-05'),
('0521.2626', 'Andika Saputra', 'Jl. Cikini No. 65', 'andikasaputra@gmail.com', '0943210987', '2021-05-07'),
('0623.2697', 'Andrie Pratama', 'Jl. Dr. Setiabudi No. 85', 'andriepratama@gmail.com', '0909876543', '2023-06-22'),
('0623.2698', 'Andri Setia Budi', 'Jl. Gatot Subroto No. 75', 'andrisetiabudi@gmail.com', '0921098765', '2023-06-22'),
('0623.2699', 'Andi Maulana', 'Jl. Veteran No. 50', 'andimaulana@gmail.com', '0976543210', '2023-06-22'),
('0718.1254', 'Ananda Lilahi Raffanelly', 'Jl. Asia Afrika No. 35', 'anandalilahi@gmail.com', '0867890123', '2018-07-11'),
('0719.1771', 'Andri Suryadi', 'Jl. Cimanuk No. 80', 'andrisuryadi@gmail.com', '0910987654', '2019-07-10'),
('1221.1634', 'Andi Leo', 'Jl. Pahlawan No. 45', 'andileo@gmail.com', '0987654321', '2021-12-12'),
('1222.3157', 'Andry Prasetyo', 'Jl. Hang Jebat No. 90', 'andryprasetyo@gmail.com', '0898765432', '2023-01-02'),
('1223.4216', 'Alvian Saputra', 'Jl. Cendana No. 15', 'alviansaputra@gmail.com', '0823456789', '2023-12-21');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kriteria`
--

CREATE TABLE `tbl_kriteria` (
  `kode_kriteria` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_kriteria` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nilai` int NOT NULL,
  `jenis` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`kode_kriteria`, `nama_kriteria`, `nilai`, `jenis`) VALUES
('K01', 'Kecepatan Pengiriman', 6, 'Benefit'),
('K02', 'Keandalan', 7, 'Benefit'),
('K03', 'Kepuasan Pelanggan', 7, 'Benefit'),
('K04', 'Jumlah Pengiriman Perbulan', 5, 'Benefit'),
('K05', 'Komunikasi dengan pelanggan', 4, 'Benefit'),
('K06', 'Disiplin dan kehadiran', 5, 'Benefit'),
('K07', 'Pemahaman rute', 7, 'Benefit'),
('K08', 'Tingkat Pengembalian Perbulan', 2, 'Cost');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penilaian`
--

CREATE TABLE `tbl_penilaian` (
  `id_kurir` varchar(30) NOT NULL,
  `nama_kurir` varchar(30) NOT NULL,
  `kecepatan_pengiriman` int NOT NULL,
  `keandalan` int NOT NULL,
  `kepuasan_pelanggan` int NOT NULL,
  `jml_pengiriman_perbulan` int NOT NULL,
  `komunikasi_dengan_pelanggan` int NOT NULL,
  `disiplin_kehadiran` int NOT NULL,
  `pemahaman_rute` int NOT NULL,
  `tingkat_pengembalian_perbulan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tbl_penilaian`
--

INSERT INTO `tbl_penilaian` (`id_kurir`, `nama_kurir`, `kecepatan_pengiriman`, `keandalan`, `kepuasan_pelanggan`, `jml_pengiriman_perbulan`, `komunikasi_dengan_pelanggan`, `disiplin_kehadiran`, `pemahaman_rute`, `tingkat_pengembalian_perbulan`) VALUES
('0124.4459', 'Alviansyah Riyandi Niode', 5, 4, 5, 1820, 3, 26, 4, 130),
('0224.4078', 'Aliv Pratama', 3, 4, 5, 2236, 5, 26, 5, 78),
('0224.4094', 'Amin Faoji Putra Pratama', 4, 5, 6, 1976, 2, 25, 2, 156),
('0321.2523', 'Andhika Pandu Abi Manyu', 5, 2, 3, 1820, 5, 23, 1, 26),
('0321.2561', 'Angga Darmawan', 2, 5, 1, 2054, 5, 26, 5, 52);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_data_kurir`
--
ALTER TABLE `tbl_data_kurir`
  ADD PRIMARY KEY (`id_kurir`),
  ADD KEY `id_kurir` (`id_kurir`);

--
-- Indeks untuk tabel `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  ADD PRIMARY KEY (`kode_kriteria`);

--
-- Indeks untuk tabel `tbl_penilaian`
--
ALTER TABLE `tbl_penilaian`
  ADD PRIMARY KEY (`id_kurir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
