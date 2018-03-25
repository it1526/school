-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Ned 25. bře 2018, 17:44
-- Verze serveru: 10.1.22-MariaDB
-- Verze PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `slovnik`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `skore`
--

CREATE TABLE `skore` (
  `id` int(11) NOT NULL,
  `jmeno` varchar(64) NOT NULL,
  `pocet_spravne` int(11) NOT NULL,
  `pocet_spatne` int(11) NOT NULL,
  `pocet_neodpovezeno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vypisuji data pro tabulku `skore`
--

INSERT INTO `skore` (`id`, `jmeno`, `pocet_spravne`, `pocet_spatne`, `pocet_neodpovezeno`) VALUES
(1, 'Alpatron', 1, 0, 0),
(2, 'git gud', 1, 1, 1);

-- --------------------------------------------------------

--
-- Struktura tabulky `slovnicek`
--

CREATE TABLE `slovnicek` (
  `id` int(11) NOT NULL,
  `cs` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `en` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `slovni_druh` enum('podstatne_jmeno','pridavne_jmeno','zajmeno','sloveso','prislovce') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vypisuji data pro tabulku `slovnicek`
--

INSERT INTO `slovnicek` (`id`, `cs`, `en`, `slovni_druh`) VALUES
(1, 'počítač', 'computer', 'podstatne_jmeno'),
(4, 'plamen', 'flame', 'podstatne_jmeno'),
(6, 'oheň', 'fire', 'podstatne_jmeno'),
(7, 'slovo', 'word', 'podstatne_jmeno'),
(8, 'léto', 'summer', 'podstatne_jmeno'),
(9, 'stůl', 'table', 'podstatne_jmeno');

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `skore`
--
ALTER TABLE `skore`
  ADD PRIMARY KEY (`id`);

--
-- Klíče pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  ADD PRIMARY KEY (`id`),
  ADD KEY `slovnicek_cs_idx` (`cs`),
  ADD KEY `slovnicek_en_idx` (`en`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `skore`
--
ALTER TABLE `skore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
