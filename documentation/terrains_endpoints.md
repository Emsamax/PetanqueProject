# API Terrain Endpoints

| Méthode     | Endpoint                                                  |
| ----------- | --------------------------------------------------------- |
| GET         | /terrain/{id}                                             |
| Utilisé pour| Récupère les données d'un terrain par son identifiant.  |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found`                                          |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |

| GET         | /terrain                                                 |
| ----------- | --------------------------------------------------------- |
| Utilisé pour| Récupère la liste de tous les terrains.                 |
| Sortie Json | `None`                                                    |
| Sortie Erreur| `404 Not Found`                                          |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                    |

| DELETE      | /terrain/{id}                                            |
| ----------- | -------------------------------------------------------- |
| Utilisé pour| Supprime un terrain par son identifiant.               |
| Sortie Json | `None`                                                   |
| Sortie Erreur| `404 Not Found`                                         |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                   |

| PUT         | /terrain/{id}                                            |
| ----------- | -------------------------------------------------------- |
| Utilisé pour| Met à jour les données d'un terrain existant.        |
| Sortie Json | `None`                                                   |
| Sortie Erreur| `404 Not Found` or `400 Bad Request`                     |
| Statut      | Implemented ✔️                                            |
| Test Unitaire| TODO ⏳                                                   |
