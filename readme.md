# Objectifs du projet

Vous devez réaliser un projet qui consiste à créer une plateforme de gestion de covoiturage.

# Les entités

Pour gérer ce projet vous aurez besoin de quelques entités ...

## Utilisateur

Un utilisateur identifié sera capable de s'identifier sur la plateforme et pourra créer son profil (**User**) et renseigner les informations sur sa **Car**

## Illustration

Il s'agit simplement d'une illustration, une image, identifiée par un simple nom de fichier, ce nom de fichier sera utilisé en conjonction avec des chemins stockés dans les fichiers de configuration pour composer le chemin interne (path) et le chemin externe (url)

## Car

Il s'agit de l'entité en charge des données concernant la **Car** de l'**User**, on aurait pu tout regrouper dans **User** mais cette solution nous donne la possibilité d'avoir plusieurs **Cars** pour un même **User**

## Trajet

Cette entitée servira à stocker les **Trajets** de l'**User**, localisation et timing de départ et d'arrivée seront stockés dans la table correspondante

## Rating

Cette entitée gèrera les **Rating** déposés par des **User**

# Ce qui est attendu

## Backend

Vous devez produire une plateforme permettant de ...
- Créer
- Voir de manière unitaire ou en liste
- Modifier
- Supprimer


  ... des **User**, vous fournirez un moyen au travers de cette interface de définir les éléments relatifs à la **Car** de ce dernier
  ... des **Trajets** qui feront eux même référence à des **Address**
  ... et enfin des **Rating** à propos des **User** de la plateforme

Ces pages devront être ergonomiquement respectables, présenter toutes les informations utiles et donner la possibilité de modifier les **Illustrations** des **Users** et **Cars** dans leurs formulaire respectifs

Pour les illustrations, un upload de fichier est attendu.

## Api

Vous devrez produire une API REST répondant aux requêtes suivantes :
- GET, PUT, PATCH et DELETE sur /api/user/{id}
- GET, POST sur /api/users
- GET, PUT, PATCH et DELETE sur /api/trajet/{id}
- GET, POST sur /api/trajets
- GET, PUT, PATCH et DELETE sur /api/rating/{id}
- GET, POST sur /api/ratings

Les requêtes seront faites avec un corps en JSON et la réponse pourra être alternativement du JSON ou du XML selon l'encodage demandé lors de l'appel

Les réponses devront retourner les codes d'erreur appropriés accompagnés de messages lorsque le problème n'est pas trivial

### Tests
Vous devrez implémenter une série de tests pour l'API que vous aurez produit, au minimum un test valide et invalide pour chaque point d'entrée

Le format des tests est à votre discrétion (curl, Postman, ...) mais vous devrez les jouer pendant la démonstration


### Documentation

Votre API devra être documentée sur le modèle suivant

#### Get un parcours

```http
  GET /api/user/{id}
```

| Parameter | Type     | Description                                  |
| :-------- | :------- |:---------------------------------------------|
|   `id`    | `string` | **Required**. L'identifiant de l'utilisateur |


# Livraison

La livraison se fera **impérativement** sur un Github Classroom qui vous sera communiqué, la date de rendu sera précisée dans l'assignment que vous rejoindrez, aucune livraison ne sera acceptée par mail ou autre

La livraison contiendra :
- Le code de votre projet incluant le backend et l'API
- Les tests d'API que vous aurez réalisé
- Une vidéo de démonstration qui respectera le scénario suivant :
      - Création d'un utilisateur (U1)
      - Renseignement du profil et des informations relatives à sa voiture (+Illustrations) 
      - Création d'un trajet
      - Logout
      - Création d'un autre utilisateur (U2)
      - Inscription au trajet de U1 en tant que passager
      - Ajout d'un avis sur U1
      - Logout
      - Login avec un compte administrateur
      - Suppression des comptes U1 et U2
- Présentation des tests de l'API
- Un readme clair qui expliquera ce que vous avez fait, ce que vous n'avez pas pu faire et qui donnera des précisions sur le projet (versions utilisées) ainsi que les manipulations à effectuer afin que je puisse faire tourner votre projet sans problème

# Notation

Vous partez d'un capital de 20 points et vous pourrez en perdre pour plusieurs raison : 
- Le code est de mauvaise qualité (jusqu'à -5 points)
- L'ergonomie est franchement mauvaise / le rendu est franchement mauvais (jusqu'à -3 points)
- Vous n'avez pas fourni de readme avec votre projet (-5 points)
- Vous n'avez pas fourni un des éléments demandés dans la section du dessus (-1 à -5 points par élément)
- Plagiat (-10 à -25 points), vous avez le droit de prendre du code en ligne tant que vous le comprenez mais ne prenez pas le code d'un camarade, la sentence vaut pour les deux groupes

Si vous réalisez des fonctionnalités non demandées, je rajoute des bonus, par exemple : 
- Une carte qui présente le trajet
- Un formulaire d'upload drag & drop en ajax avec preview
- ...
