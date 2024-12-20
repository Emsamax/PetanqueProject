

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Table structure for table `terrain`
--

CREATE TABLE `terrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `quantite` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `point_geo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `utilisateur_id` int(11) NOT NULL,
  `terrain_id` int(11) NOT NULL,
  `reservation` int(11) NOT NULL,
  PRIMARY KEY (`utilisateur_id`,`terrain_id`),
  KEY `terrain_id` (`terrain_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`terrain_id`) REFERENCES `terrain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
