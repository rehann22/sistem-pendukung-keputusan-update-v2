-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jun 2024 pada 00.12
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

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
  `id_kurir` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `email` varchar(30) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `tgl_bergabung` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_data_kurir`
--

INSERT INTO `tbl_data_kurir` (`id_kurir`, `nama`, `alamat`, `email`, `no_telp`, `tgl_bergabung`) VALUES
('2021.0524', 'Rian', 'Lorem Ipsim', 'email', '023121', '2024-06-02'),
('2023.5544', 'mmm', 'mmmm', 'mmm', 'mmm', '2024-01-25'),
('2024.5648', 'Ahmad', 'Lorem Ipsim', 'adfsf', '5151', '2024-04-05');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kriteria`
--

CREATE TABLE `tbl_kriteria` (
  `kode_kriteria` varchar(15) NOT NULL,
  `nama_kriteria` varchar(50) NOT NULL,
  `nilai` int(11) NOT NULL,
  `jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`kode_kriteria`, `nama_kriteria`, `nilai`, `jenis`) VALUES
('K01', 'A', 6, 'BENEFIT'),
('K02', 'B', 7, 'COST'),
('K03', 'C', 6, 'COST'),
('K04', 'D', 8, 'BENEFIT'),
('K05', 'E', 2, 'COST'),
('K06', 'F', 9, 'BENEFIT');

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
