# ECE_BOOKING_PROJET

ECE Booking est une application de réservation d'hébergements de vacances qui permet aux utilisateurs de rechercher, filtrer et réserver des logements comme des hôtels, appartements, villas, etc. Le projet a été développé dans le cadre du cours de Java à l'ECE. Il s'agit d'un projet réalisé par 4 étudiants en 3ème année d'école d'ingénieurs. 


## Objectif du projet
Le but est de proposer une application qui facilite la réservation de vacances pour les clients tout en permettant aux employés de gérer les hébergements et les dossiers clients.

## Fonctionnalités principales
### Pour les clients :
- **Recherche d'hébergements :** Filtrer par catégorie, prix, dates, lieu, et autres critères comme le WiFi, le parking, etc.
- **Réservation :** Sélection d'une destination, des dates, du nombre de personnes et de chambres.
- **Types de clients :** Invités occasionnels ou membres réguliers avec réductions pour les membres.
- **Paiement :** Simulation d'une interface de traitement de paiement.
### Pour les employés :
- **Gestion des hébergements :** Mise à jour des disponibilités et des offres.
- **Réductions :** Gestion des promotions et des réductions pour les membres.
- **Gestion des dossiers clients :** Maintenir à jour les informations des clients et des réservations.


## Architecture du projet
L'application suit le modèle **MVC (Modèle-Vue-Contrôleur)** pour une meilleure structuration du code et de l'interface utilisateur.

- **Modèle :** Gestion des données et interactions avec la base de données.
- **Vue :** Interface utilisateur graphique (GUI) pour les clients et les employés.
- **Contrôleur :** Gestion des événements et de la logique de l'application.


## Exigences techniques
- **Langage :** 100% Java
- **Base de données :** MySQL pour gérer les informations sur les hébergements et les clients.
- **Frameworks :** Utilisation d'un framework Java pour l'interface graphique (Swing ou autre).
- **DAO :** Utilisation du modèle Data Access Object pour accéder aux données.
- **JFreeChart :** Génération de graphiques statistiques pour le reporting.


## Structure de la base de données
La base de données contient des tables pour :

- Les hébergements (hôtels, villas, appartements, etc.)
- Les clients (membres ou invités)
- Les réservations
- Les paiements
- Chaque table contient au moins 6 enregistrements pour simuler les interactions.

## Installation
1. Clonez le projet depuis GitHub :

```
git clone https://github.com/candic0504/ECE_Booking.git

```

2. Importez le projet dans votre IDE Java (IntelliJ, Eclipse, etc.).

3. Configurez la base de données MySQL avec les tables fournies dans le fichier SQL.

4. Exécutez l'application en lançant le fichier principal.



