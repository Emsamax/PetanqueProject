# API Endpoints for Terrain

| Method      | Endpoint                                                  |
| ----------- | --------------------------------------------------------- |
| GET         | /terrain/{id}                                             |
| Used for    | Retrieve the data of a terrain by its identifier.        |
| JSON Output |
{
  `id`: integer,
  `name`: string,
  `quantity`: int,
  `description`: string (optional),
  `geo_point`: string
}                                                       |
| Error Output| `404 Not Found`                                          |
| Status      | Implemented ✔️                                            |
| Unit Test   | TODO ⏳                                                   |

| GET         | /terrain                                                 |
| ----------- | --------------------------------------------------------- |
| Used for    | Retrieve the list of all terrains.                       |
| JSON Output | 
{
  `id`: integer,
  `name`: string,
  `quantity`: int,
  `description`: string (optional),
  `geo_point`: string
}                                                       |
| Error Output| `404 Not Found`                                          |
| Status      | Implemented ✔️                                            |
| Unit Test   | TODO ⏳                                                   |

| DELETE      | /terrain/{id}                                            |
| ----------- | -------------------------------------------------------- |
| Used for    | Delete a terrain by its identifier.                      |
| JSON Output | `None`                                                   |
| Error Output| `404 Not Found`                                          |
| Status      | Implemented ✔️                                            |
| Unit Test   | TODO ⏳                                                   |

| PUT         | /terrain/{id}                                            |
| ----------- | -------------------------------------------------------- |
| Used for    | Update the data of an existing terrain.                  |
| JSON Output | `None`                                                   |
| Error Output| `404 Not Found` or `400 Bad Request`                     |
| Status      | Implemented ✔️                                            |
| Unit Test   | TODO ⏳                                                   |
