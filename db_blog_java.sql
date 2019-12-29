-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 29 déc. 2019 à 11:35
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `blog_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `description_article` varchar(200) NOT NULL,
  `texte` varchar(400) NOT NULL,
  `date_article` date NOT NULL,
  `id_auteur` int(11) NOT NULL,
  PRIMARY KEY (`id_article`),
  KEY `id_auteur` (`id_auteur`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `titre`, `description_article`, `texte`, `date_article`, `id_auteur`) VALUES
(1, 'messi', 'messi iufzigeogneogerogpoe', 'egziegezzgzg izuigoizgoigoir gnognoie rghueizgz ghozh', '2019-12-31', 1),
(8, 'david', 'teixeira', 'da silva', '2019-12-18', 1),
(10, 'aaaaaaa', 'zzzzzzzzzzzz', 'eeeeeeeeeeeeeeeeeeeeeeee', '2019-12-20', 4),
(3, 'neymar', 'neymar iufzigeogneogerogpoe', 'egziegezzgzg izuigoizgoigoir gnognoie rghueizgz ghozh', '2019-12-29', 1),
(12, 'messi', 'ballon d\'or', 'meilleur joueur de l\'histoire', '2019-12-20', 4),
(11, 'fffffffffffff', 'ggggggggggggh', 'hhhhhhhhhhh', '2019-12-20', 4),
(6, 'victor', 'vidal champion france', 'champion du monde', '2019-12-30', 1),
(13, 'dhgd', 'sxhyhdh', 'yhdudu', '2019-12-24', 4),
(14, 't', 't', 't', '2019-12-20', 4),
(15, 't', 't', 't', '2019-12-20', 4),
(16, 'r', 'r', 'r', '2019-12-20', 4),
(17, 'y', 'y', 'y', '2019-12-20', 4),
(18, 'dqfsgd', 'esrgdtfgh', 'sdfg', '2019-12-22', 4),
(19, 'sfd', 'sxgdf', 'xshdfg', '2019-12-24', 4),
(20, 'qsgdf', 'edrfhgj', 'stedrgfth', '2019-12-24', 4);

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
CREATE TABLE IF NOT EXISTS `auteur` (
  `id_auteur` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(50) NOT NULL,
  `password_auteur` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_auteur`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`id_auteur`, `pseudo`, `password_auteur`) VALUES
(1, 'louis', 'fbibz'),
(2, 'jeremy', 'efzijg'),
(3, 'david', 'grfezh'),
(4, 'yamina', 'aaa'),
(10, 'qgshd', 'a'),
(9, 'qrfsg', 'aze'),
(8, 'gdf', 'g');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
