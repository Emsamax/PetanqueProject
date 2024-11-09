# API Reservation Endpoints

| Méthode     | Endpoint                                                  |
| ----------- | --------------------------------------------------------- |
| GET         | /reservation/{id}                                         |
| Utilisé pour| Récupère les données d'une réservation par son identifiant. |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found`                                          |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |

| GET         | /reservation                                              |
| ----------- | --------------------------------------------------------- |
| Utilisé pour| Récupère la liste de toutes les réservations.             |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found`                                          |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |

| DELETE      | /reservation/{id}                                          |
| ----------- | -------------------------------------------------------- |
| Utilisé pour| Supprime une réservation par son identifiant.            |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found`                                          |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |

| PUT         | /reservation/{id}                                          |
| ----------- | -------------------------------------------------------- |
| Utilisé pour| Met à jour les données d'une réservation existante.      |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found` or `400 Bad Request`                      |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |
