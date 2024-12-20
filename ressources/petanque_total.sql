-- Drop the database if it already exists
DROP DATABASE IF EXISTS petanque;

-- Create a new database named "petanque"
CREATE DATABASE petanque;

-- Use the newly created "petanque" database
USE petanque;

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

INSERT INTO `terrain` VALUES 
(1,"Zone Sportive des Mesliers",3,NULL,"47.3391800013, 0.7174200006"),
(2,"Les Charmes",1,NULL,"47.4923500008, 0.6983300011"),
(3,"Foot - Tennis -Petanque",7,NULL,"47.3061799994, 0.5372999993"),
(4,"Complexe Sportif du Moulin A Vent",14,NULL,"47.4016399996, 0.6013300001"),
(5,"Plan d'Eau de la Membrolle",4,NULL,"47.4404999995, 0.641219999"),
(6,"Stade George Romien",3,NULL,"47.4580590007, 0.7056720008"),
(7,"Terrains de Petanque",8,NULL,"47.45935, 0.7078100011"),
(8,"Terrain de Loisir de l'Ile Buda",2,NULL,"47.3650040009, 0.5063989991"),
(9,"Boulodrome (Amicale Bouliste)",1,NULL,"47.3617680876, 0.7035419714"),
(10,"Stade Municipal de l'Ile Aucard",7,NULL,"47.3716962238, 0.7062003938"),
(11,"Place Meffre",1,NULL,"47.379570001, 0.6996300017"),
(12,"Stade du Danemark",6,NULL,"47.4302500001, 0.6798500011"),
(13,"Usc Petanque",1,NULL,"47.3392380011, 0.7162219998"),
(14,"Complexe Sportif de la Haye",5,NULL,"47.3300100011, 0.6120900019"),
(15,"Salle de Boules de Fort Les Paletots Rapes",1,NULL,"47.3840400008, 0.5548299997"),
(16,"Parc des Sports",15,NULL,"47.4355880008, 0.639192"),
(17,"Stade",3,NULL,"47.4136900014, 0.7565500017"),
(18,"Boulodrome G.Primault",1,NULL,"47.4112400011, 0.6698700014"),
(19,"Plaine de Jeux",1,NULL,"47.3770400007, 0.6000100009"),
(20,"Tennis et Petanque en Face du Camping",9,NULL,"47.3494299994, 0.5499000009"),
(21,"Ferme de la Miletiere",4,NULL,"47.4350400009, 0.7042000013"),
(22,"Tennis Couvert Isabelle Demongeot",1,NULL,"47.4570550011, 0.7003110017"),
(23,"Terrains de Petanque",2,NULL,"47.4413207032, 0.747529456"),
(24,"Stade Municipal",14,NULL,"47.4733799994, 0.7073700017"),
(25,"Boulodrome",1,NULL,"47.3482000005, 0.6674990002"),
(26,"Terrains de Petanque Gallieni",9,NULL,"47.3496200004, 0.6563500018"),
(27,"Salle de Boules de Fort N°1",1,NULL,"47.3852224325, 0.5553555838"),
(28,"Boulodrome Georges Tulasne",1,NULL,"47.3817700001, 0.557240001"),
(29,"Terrain de Boules de la Plage",1,NULL,"47.3694900013, 0.7330200014"),
(30,"Complexe Les Grands Champs",21,NULL,"47.35169, 0.7217500017"),
(31,"Complexe Sportif Guy Drut",7,NULL,"47.4173383017, 0.65311839"),
(32,"Aspo Petanque",3,NULL,"47.3910099993, 0.7361299991"),
(33,"Complexe Pierre Semard",2,NULL,"47.3953700007, 0.7341300002"),
(34,"Complexe Sportif des Tourettes",13,NULL,"47.4117148211, 0.6958727854"),
(35,"Boulodrome (Boules Lyonnaises)",2,NULL,"47.3766733512, 0.6990401446"),
(36,"Boulodrome Degas",2,NULL,"47.37044, 0.7134390003"),
(37,"Stadium de pétanque et sports de boules de la ville de Tours",0,NULL,"47.3783450397, 0.7354783352");

--
-- Insertions
--

-- Utilisateur 1, mot de passe : password
INSERT INTO `utilisateur` (`nom`, `prenom`, `mail`, `password`, `username`) 
VALUES ('BRUNET', 'Sylvain', 'sylvain.brunet@etu.univ-tours.fr', 'e662ee5862b55e79cc3b9454cf2689359620a6e6411ea9be9ef9b6268958019e5d60aae1f64d6aaeb53b142d979cb008', 'S');

-- Utilisateur 2, mot de passe : password
INSERT INTO `utilisateur` (`nom`, `prenom`, `mail`, `password`, `username`) 
VALUES ('Martin', 'Alice', 'alice.martin@example.com', 'e662ee5862b55e79cc3b9454cf2689359620a6e6411ea9be9ef9b6268958019e5d60aae1f64d6aaeb53b142d979cb008', 'amartin');

-- Utilisateur 3, mot de passe : password
INSERT INTO `utilisateur` (`nom`, `prenom`, `mail`, `password`, `username`) 
VALUES ('Bernard', 'Luc', 'luc.bernard@example.com', 'e662ee5862b55e79cc3b9454cf2689359620a6e6411ea9be9ef9b6268958019e5d60aae1f64d6aaeb53b142d979cb008', 'lbernard');

-- Réservation 1
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (1, 1, 1);

-- Réservation 2
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (2, 3, 1);

-- Réservation 3
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (3, 2, 1);
