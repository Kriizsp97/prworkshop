SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `dosen` (
  `nama` varchar(15) NOT NULL,
  `id_dosen` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `dosen` (`nama`, `id_dosen`) VALUES
('Bintang Timur', 55511),
('Rendy Bintang', 55512),
('Putri Lestari', 55513),
('Dinda Ayu', 55514);

CREATE TABLE IF NOT EXISTS `matakuliah` (
  `id_mtkuliah` int(5) NOT NULL,
  `id_dosen` int(5) NOT NULL,
  `nama` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `matakuliah` (`id_mtkuliah`, `id_dosen`, `nama`) VALUES
(10001, 55513, 'Inggris Bisnis'),
(10002, 55513, 'Inggris Formal'),
(20001, 55514, 'Sejarah'),
(20002, 55512, 'Pemrograman Das'),
(30001, 55511, 'Pemrograman Das'),
(30002, 55512, 'Sistem Komputer');

CREATE TABLE IF NOT EXISTS `mhs` (
  `id_mhs` int(5) NOT NULL,
  `id_mtkuliah` int(5) NOT NULL,
  `nama` varchar(15) NOT NULL,
  `sem` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `mhs` (`id_mhs`, `id_mtkuliah`, `nama`, `sem`) VALUES
(12511, 10001, 'Rio Bayu', 1),
(22511, 20001, 'Bayu Reno', 2),
(22512, 20001, 'Tiara Nia', 2),
(32511, 30001, 'Bintang Aji', 3),
(32512, 30001, 'Yana Marti', 3),
(32513, 30002, 'Agus Murti', 3);


ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`id_mtkuliah`);

ALTER TABLE `mhs`
  ADD PRIMARY KEY (`id_mhs`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
