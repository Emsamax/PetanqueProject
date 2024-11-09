-- Réservation 1
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (1, 1, UNIX_TIMESTAMP('2024-11-05 15:00:00'));

-- Réservation 2
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (2, 3, UNIX_TIMESTAMP('2024-11-06 10:00:00'));

-- Réservation 3
INSERT INTO `reservation` (`utilisateur_id`, `terrain_id`, `reservation`) 
VALUES (3, 2, UNIX_TIMESTAMP('2024-11-07 12:00:00'));
