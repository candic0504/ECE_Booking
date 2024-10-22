-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 16 avr. 2023 à 20:41
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ece_booking`
--

-- --------------------------------------------------------

--
-- Structure de la table `activites`
--

DROP TABLE IF EXISTS `activites`;
CREATE TABLE IF NOT EXISTS `activites` (
  `ID_ACTIVITE` int NOT NULL,
  `ID_VILLE` int NOT NULL,
  `NOM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `TYPE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PRESENTATION` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`ID_ACTIVITE`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `activites`
--

INSERT INTO `activites` (`ID_ACTIVITE`, `ID_VILLE`, `NOM`, `TYPE`, `PRESENTATION`) VALUES
(0, 2, 'Aiguille du Midi ', ' Vue panoramique ', ' L  Aiguille du Midi est un pic des Alpes françaises qui culmine à 3 842 mètres d  altitude. On peut y accéder par un téléphérique et profiter d  une vue imprenable sur le massif du Mont'),
(1, 2, 'Ski ', ' Activité sportive ', ' Chamonix est une destination de ski populaire et réputée, offrant des pistes pour tous les niveaux de skieurs. Les sites les plus célèbres incluent les pistes de Vallée Blanche, Grands Montets et Les Houches.'),
(2, 2, 'Mer de Glace ', ' Randonnée ', ' La Mer de Glace est le plus grand glacier de France, avec une longueur de 7 km. On peut y accéder par un train à crémaillère depuis Chamonix, puis parcourir un sentier de randonnée qui offre une vue magnifique sur le glacier et les montagnes environnantes.'),
(3, 1, 'Le musée Matisse ', ' Musée ', ' Le musée Matisse est un musée consacré à l  artiste français Henri Matisse, qui a vécu à Nice de 1917 à 1954. Le musée présente une collection de plus de 300 œuvres de l  artiste, ainsi que des expositions temporaires consacrées à d  autres artistes.'),
(4, 1, 'La Promenade des Anglais ', ' Promenade en bord de mer ', ' Celebre avenue qui longe la plage de Nice.'),
(5, 1, 'Le marché aux fleurs de Cours Saleya ', ' Marché ', ' Le marché aux fleurs de Cours Saleya est un marché extérieur populaire situé dans le centre'),
(6, 3, 'La Sagrada Familia ', ' Architecture ', ' La Sagrada Familia est l  un des sites les plus célèbres de Barcelone. Cette basilique est un chef'),
(7, 3, 'Parc Güell ', ' Parc et Architecture ', ' Le parc Güell est un parc public et un site du patrimoine mondial de l  UNESCO. Conçu également par Antoni Gaudí, le parc offre des vues imprenables sur la ville et des structures architecturales uniques, notamment la fameuse Salamandre.'),
(8, 3, 'La Rambla ', ' Promenade en ville ', ' La Rambla est une avenue animée et touristique de Barcelone, qui relie la Place de Catalogne au port de la ville. Elle est bordée de boutiques, de restaurants et de bars, et est un lieu de promenade populaire pour les visiteurs et les habitants de la ville.'),
(9, 4, 'Louvre ', ' Musée ', ' Le Louvre est l  un des musées les plus célèbres et les plus visités au monde. Il abrite une vaste collection d  œuvres d  art, allant de l  Antiquité au XIXe siècle, dont la célèbre Joconde de Léonard de Vinci.'),
(10, 4, 'Promenade le long de la Seine ', ' Activité en plein air ', ' La Seine est une rivière emblématique de Paris, et une promenade le long de ses rives offre une vue magnifique sur certains des sites les plus célèbres de la ville, tels que Notre'),
(11, 4, 'Opéra Garnier ', ' Spectacle ', ' L  Opéra Garnier est un théâtre magnifique et emblématique de Paris, célèbre pour son architecture somptueuse et ses spectacles de ballets et d  opéras de renommée mondiale. Les visites guidées permettent de découvrir les coulisses de ce bâtiment historique.'),
(12, 5, 'Le lac de Zurich ', ' Activité en plein air ', ' Le lac de Zurich est un lac magnifique situé en plein cœur de la ville. Les visiteurs peuvent faire des promenades en bateau, des pique'),
(13, 5, 'Le musée national suisse ', ' Musée ', ' Le musée national suisse est le musée le plus important de Suisse, présentant une collection d  artefacts historiques, culturels et scientifiques. Les visiteurs peuvent découvrir l  histoire de la Suisse à travers des expositions interactives et des présentations multimédias.'),
(14, 5, 'La vieille ville de Zurich ', ' Promenade dans la ville ', ' La vieille ville de Zurich est un quartier historique qui regorge de charme et d  histoire. Les visiteurs peuvent se promener dans les rues pavées, admirer l  architecture médiévale et goûter aux spécialités culinaires suisses dans les nombreux restaurants et cafés.'),
(15, 6, 'Les ruines de Pompéi ', ' Visite historique ', ' Pompéi est une ville antique célèbre pour avoir été ensevelie sous la cendre du Vésuve en l  an 79. Les visiteurs peuvent explorer les ruines de la ville, y compris les maisons, les temples et les thermes, pour découvrir la vie quotidienne des Romains il y a plus de 2000 ans.'),
(16, 6, 'Le musée archéologique national de Naples ', ' Musée ', ' Le musée archéologique national de Naples est l  un des musées les plus importants d  Italie. Il présente une vaste collection d  artefacts et d  œuvres d  art de l  Antiquité, notamment des sculptures, des mosaïques et des fresques provenant de Pompéi et d  autres sites archéologiques.'),
(17, 6, 'Le quartier historique de Spaccanapoli ', ' Promenade dans la ville ', ' Spaccanapoli est un quartier historique de Naples qui traverse la ville du nord au sud. Les visiteurs peuvent se promener dans les rues étroites, admirer l  architecture baroque et gothique, et découvrir des boutiques, des restaurants et des cafés locaux.'),
(18, 7, 'Le Colisée ', ' Visite historique ', ' Le Colisée est un amphithéâtre romain célèbre pour ses combats de gladiateurs. Les visiteurs peuvent explorer les niveaux inférieurs de l  amphithéâtre et en apprendre davantage sur l  histoire de l  ancienne Rome.'),
(19, 7, 'La Chapelle Sixtine ', ' Visite culturelle ', ' La Chapelle Sixtine est une célèbre chapelle du Vatican célèbre pour ses fresques peintes par Michel'),
(20, 7, 'La Fontaine de Trevi ', ' Promenade dans la ville ', ' La Fontaine de Trevi est une célèbre fontaine de Rome, située dans le centre historique de la ville. Les visiteurs peuvent jeter une pièce dans la fontaine pour s  assurer de revenir à Rome, se promener dans les rues environnantes et découvrir les boutiques et les restaurants locaux.'),
(21, 8, 'Le Malecón ', ' Promenade en bord de mer ', ' Le Malecón est une promenade en bord de mer de plus de 8 kilomètres qui longe la côte de La Havane. Les visiteurs peuvent profiter de la vue sur l  océan et la ville, se promener ou faire du vélo, et découvrir la vie locale.'),
(22, 8, 'Le quartier de la Vieille Havane ', ' Promenade dans la ville ', ' Le quartier de la Vieille Havane est un quartier historique de la ville, classé au patrimoine mondial de l  UNESCO. Les visiteurs peuvent se promener dans les rues pavées, admirer l  architecture coloniale espagnole, visiter des musées et des galeries d  art, et découvrir des restaurants et des bars locaux.'),
(23, 8, 'La Fabrica de Arte Cubano ', ' Galerie d  art ', ' La Fabrica de Arte Cubano est une galerie d  art contemporain située dans une ancienne usine de gaz. Les visiteurs peuvent découvrir des expositions d  art, des spectacles en direct, des projections de films, des installations multimédias, ainsi que des restaurants et des bars.'),
(24, 9, 'Le Musée de l  Or ', ' Musée ', ' Le Musée de l  Or est un musée célèbre pour sa collection d  objets en or précolombiens du Costa Rica. Les visiteurs peuvent admirer des pièces uniques, telles que des figurines, des bijoux, des plaques et des sculptures, qui témoignent de la richesse de la culture indigène du pays.'),
(25, 9, 'Le marché central ', ' Marché ', ' Le marché central est un marché traditionnel situé dans le centre de San Jose. Les visiteurs peuvent y découvrir une grande variété de produits locaux, tels que des fruits, des légumes, des épices, des produits artisanaux et des souvenirs, ainsi que déguster des plats typiques de la cuisine costaricienne.'),
(26, 9, 'Le parc national du volcan Poás ', ' Parc naturel ', ' Le parc national du volcan Poás est situé à environ une heure de route de San Jose. Les visiteurs peuvent y découvrir l  un des plus grands cratères de volcan actifs du monde, ainsi que de beaux sentiers de randonnée, des cascades et une faune et une flore abondantes.'),
(27, 10, 'La montagne de la Table ', ' Randonnée ', ' La montagne de la Table est une célèbre montagne située au cœur du Cap. Les visiteurs peuvent y accéder en empruntant le téléphérique ou en faisant une randonnée. Au sommet, les visiteurs peuvent profiter d  une vue panoramique sur la ville et la mer.'),
(28, 10, 'Le quartier de Bo', 'Kaap ', ' Visite culturelle '),
(29, 10, 'Le Cap de Bonne', 'Espérance ', ' Parc naturel '),
(30, 11, 'L  opéra de Sydney ', ' Visite culturelle ', ' L  opéra de Sydney est un emblème de la ville, célèbre pour son architecture unique en forme de coquillage. Les visiteurs peuvent y assister à des spectacles de théâtre, d  opéra ou de danse, ou tout simplement visiter l  intérieur de l  édifice et découvrir son histoire.'),
(31, 11, 'Le pont du port de Sydney ', ' Expérience unique ', ' Le pont du port de Sydney est un célèbre pont suspendu, offrant une vue panoramique sur la ville et la baie. Les visiteurs peuvent y faire une expérience unique en grimpant jusqu  au sommet de l  arche du pont pour profiter d  une vue imprenable, ou en faisant une promenade en traversant le pont.'),
(32, 11, 'Le jardin botanique royal de Sydney ', ' Promenade dans la nature ', ' Le jardin botanique royal de Sydney est un grand parc situé dans le centre'),
(33, 12, 'Le Musée de Brisbane ', ' Musée ', ' Le Musée de Brisbane est un musée d  art et d  histoire situé dans le centre'),
(34, 12, 'Le South Bank Parklands ', ' Parc et promenade ', ' Le South Bank Parklands est un grand parc situé le long de la rive de Brisbane. Les visiteurs peuvent y faire une promenade, pique'),
(35, 12, 'Le Lone Pine Koala Sanctuary ', ' Parc animalier ', ' Le Lone Pine Koala Sanctuary est un parc animalier situé à environ 12 km du centre'),
(36, 13, 'Le Jardin botanique de Singapour ', ' Parc naturel ', ' Le Jardin botanique de Singapour est un grand parc naturel situé dans le centre de la ville. Les visiteurs peuvent y découvrir une grande variété de plantes, fleurs et arbres, ainsi que des serres abritant des orchidées. Le parc est également connu pour abriter le parcours de marche et de course à pied Treetop Walk.'),
(37, 13, 'Le Marina Bay Sands ', ' Site touristique ', ' Le Marina Bay Sands est un célèbre complexe hôtelier situé sur la baie de Singapour. Les visiteurs peuvent y accéder pour profiter d  une vue panoramique sur la ville depuis l  observatoire situé au sommet de la tour ou se baigner dans la piscine à débordement située sur le toit.'),
(38, 13, 'Les jardins de la baie ', ' Jardins artificiels ', ' Les jardins de la baie sont des jardins artificiels situés le long de la baie de Singapour. Les visiteurs peuvent y découvrir des jardins verticaux, des serres de plantes rares et exotiques, ainsi qu  une grande variété de sculptures et d  installations artistiques. Le site est également connu pour abriter le spectacle nocturne de lumières et de son et la promenade de l  arbre Supertree Grove.'),
(39, 14, 'La Statue de la Liberté ', ' Visite culturelle ', ' La Statue de la Liberté est un monument emblématique situé sur Liberty Island dans le port de New York. Les visiteurs peuvent y accéder en ferry et visiter le monument pour découvrir son histoire et profiter d  une vue imprenable sur la ville.'),
(40, 14, 'Le Metropolitan Museum of Art ', ' Musée ', ' Le Metropolitan Museum of Art, également connu sous le nom de \"Met\", est un musée d  art situé sur la Cinquième Avenue à Manhattan. Les visiteurs peuvent y découvrir une grande variété d  art et d  antiquités de différentes cultures et époques, allant de l  Egypte ancienne à l  art contemporain.'),
(41, 14, 'Central Park ', ' Parc ', ' Central Park est un grand parc situé au cœur de Manhattan. Les visiteurs peuvent y faire une promenade paisible, pique'),
(42, 15, 'Hollywood Walk of Fame ', ' Visite culturelle ', ' Le Hollywood Walk of Fame est une attraction touristique populaire située le long de Hollywood Boulevard. Les visiteurs peuvent y découvrir les étoiles célèbres de la télévision, du cinéma, de la musique et de la radio incrustées dans le trottoir, ainsi que les bâtiments historiques et les théâtres de la région.'),
(43, 15, 'Venice Beach ', ' Plage ', ' Venice Beach est une plage populaire située sur la côte ouest de Los Angeles. Les visiteurs peuvent y profiter du soleil, de la mer et des activités nautiques, ainsi que de la vie de plage animée avec ses magasins, restaurants et artistes de rue.'),
(44, 15, 'Universal Studios Hollywood ', ' Parc d  attractions ', ' Universal Studios Hollywood est un parc d  attractions situé à Universal City, près de Los Angeles. Les visiteurs peuvent y découvrir les coulisses du cinéma, faire des attractions basées sur les films et séries télévisées, assister à des spectacles en direct et rencontrer des personnages célèbres du cinéma.');

-- --------------------------------------------------------

--
-- Structure de la table `aeroport`
--

DROP TABLE IF EXISTS `aeroport`;
CREATE TABLE IF NOT EXISTS `aeroport` (
  `ID_AEROPORT` int NOT NULL AUTO_INCREMENT,
  `ID_VILLE` int DEFAULT NULL,
  `NOM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `INTERNATIONAL` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_AEROPORT`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `aeroport`
--

INSERT INTO `aeroport` (`ID_AEROPORT`, `ID_VILLE`, `NOM`, `INTERNATIONAL`) VALUES
(2, 2, 'Aéroport Chamonix', 1),
(1, 1, 'Aéroport Nice Côte d Azur', 1),
(3, 3, 'Aéroport international de Barcelone-El Prat', 1),
(4, 4, 'Aéroport Paris Charles De Gaulle', 1),
(5, 5, 'Aéroport international de Zurich', 1),
(6, 6, 'Aéroport de Capodichino', 1),
(7, 7, 'Aéroport de Rome Fiumicino', 1),
(8, 8, 'La Habana Airport', 1),
(9, 9, 'Aéroport international Juan Santamaría', 1),
(10, 10, 'Aéroport international du Cap', 1),
(11, 11, 'Aéroport Kingsford-Smith de Sydney', 1),
(12, 12, 'Aéroport international de Brisbane', 0),
(13, 13, 'Aéroport Changi de Singapour', 1),
(14, 14, 'Aéroport international John F. Kennedy', 1),
(15, 15, 'Aéroport international de Los Angeles ', 1);

-- --------------------------------------------------------

--
-- Structure de la table `hebergement`
--

DROP TABLE IF EXISTS `hebergement`;
CREATE TABLE IF NOT EXISTS `hebergement` (
  `ID_HEBERGEMENT` int NOT NULL,
  `ID_VILLE` int DEFAULT NULL,
  `NOM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ADRESSE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CAPACITE` int NOT NULL,
  `NOMBRE_DE_CHAMBRE` int NOT NULL,
  `TARIF_ADULTE` int NOT NULL,
  `TARIF_ENFANT` int NOT NULL,
  `CATEGORIE` text NOT NULL,
  `ETAGES` int DEFAULT NULL,
  `NUMERO_APPARTEMENT` int DEFAULT NULL,
  `NOMBRE_BALCON` int DEFAULT NULL,
  `NOM_MONTAGNE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ALTITUDE` int DEFAULT NULL,
  `NOM_COMPAGNIE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `NOMBRE_ETOILE` int DEFAULT NULL,
  `PISCINE` tinyint(1) DEFAULT NULL,
  `JARDIN` tinyint(1) DEFAULT NULL,
  `SAUNA` tinyint(1) DEFAULT NULL,
  `SALLE_DE_CINEMA` tinyint(1) DEFAULT NULL,
  `DISCOTHEQUE` tinyint(1) DEFAULT NULL,
  `WIFI` tinyint(1) NOT NULL,
  `SERVICE_MENAGE` tinyint(1) NOT NULL,
  `CLIMATISATION` tinyint(1) NOT NULL,
  `FUMEUR` tinyint(1) NOT NULL,
  `COFFREFORT` tinyint(1) NOT NULL,
  `DESCRIPTION_VUE` text NOT NULL,
  `PARKING` tinyint(1) NOT NULL,
  `BAR` tinyint(1) NOT NULL,
  `URL` text NOT NULL,
  `PROMOTION` int NOT NULL,
  PRIMARY KEY (`ID_HEBERGEMENT`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `hebergement`
--

INSERT INTO `hebergement` (`ID_HEBERGEMENT`, `ID_VILLE`, `NOM`, `ADRESSE`, `CAPACITE`, `NOMBRE_DE_CHAMBRE`, `TARIF_ADULTE`, `TARIF_ENFANT`, `CATEGORIE`, `ETAGES`, `NUMERO_APPARTEMENT`, `NOMBRE_BALCON`, `NOM_MONTAGNE`, `ALTITUDE`, `NOM_COMPAGNIE`, `NOMBRE_ETOILE`, `PISCINE`, `JARDIN`, `SAUNA`, `SALLE_DE_CINEMA`, `DISCOTHEQUE`, `WIFI`, `SERVICE_MENAGE`, `CLIMATISATION`, `FUMEUR`, `COFFREFORT`, `DESCRIPTION_VUE`, `PARKING`, `BAR`, `URL`, `PROMOTION`) VALUES
(0, 2, 'Le Desert Oasis ', ' 456 Desert Drive', 22, 19, 482, 241, 'Chalet', NULL, NULL, NULL, 'Cowlin', 1035, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est situé dans une zone résidentielle tranquille.', 1, 0, 'https://i.pinimg.com/564x/2e/53/68/2e536888e87284937b0c4c84e2f2e6dc.jpg', 22),
(1, 2, 'Le Lodging of Le Prairie ', ' 789 Chemin de la Prairie', 48, 11, 905, 231, 'Chalet', NULL, NULL, NULL, 'Grastye', 1035, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est facile d accès pour les personnes à mobilité réduite.', 1, 0, 'https://i.pinimg.com/564x/5d/b0/42/5db04253fcfb503225a8022298da22b7.jpg', 16),
(2, 2, 'La Mountain Lodge ', ' 1234 Mountainview Road', 12, 14, 835, 176, 'Chalet', NULL, NULL, NULL, 'Westnedge', 1035, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a une belle cheminée dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/55/ab/df/55abdf32146e1d1611fa621574f5a5aa.jpg', 9),
(3, 2, 'Le Garden Bungalow ', ' 789 Green Avenue', 6, 4, 56, 34, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est équipé de lave-vaisselle.', 1, 0, 'https://i.pinimg.com/564x/20/0e/58/200e58c13399ff2c8629631e069c594b.jpg', 38),
(4, 2, 'La Lake House ', ' 1234 Rue du Lac', 6, 4, 6, 4, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a beaucoup de lumière naturelle dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/a1/06/c7/a106c7e0256afac9d2e4295c42bf0163.jpg', 14),
(5, 1, 'Le Coastal Cottage ', ' 456 Oceanview Drive', 4, 3, 572, 344, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est proche des écoles.', 1, 1, 'https://i.pinimg.com/564x/ca/dc/26/cadc268c032a8b68353a05d00955cb99.jpg', 48),
(6, 1, 'La Cabin of Le Woods ', ' 789 Chemin des Bois', 3, 2, 1685, 1011, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est parfait pour les couples.', 1, 0, 'https://i.pinimg.com/564x/eb/c7/4a/ebc74ab32258338a2ab03de325c50874.jpg', 31),
(7, 1, 'Le Seaside Retreat ', ' 1234 Beachfront Avenue', 3, 2, 211, 127, 'Appartement', 1, 36, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une grande cuisine dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/84/6b/90/846b908f21c2b79341e671ea55a8979b.jpg', 9),
(8, 1, 'Les Alpes ', ' 456 Rue des Alpes', 6, 4, 279, 168, 'Appartement', 1, 79, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'La chambre d \n enfant de ce logement est spacieuse et confortable.', 1, 1, 'https://i.pinimg.com/564x/29/61/00/2961004a4459c3ea7e39a9aedc98fcdd.jpg', 8),
(9, 1, 'La Waterfall ', ' 1234 Rue de la Cascade', 18, 10, 694, 417, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 0, 0, 1, 1, 1, 1, 1, 'Il y a beaucoup d espace pour travailler dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/24/56/af/2456afa96147b87ece25fd28bf11e1b5.jpg', 23),
(10, 3, 'La Cliff ', ' 456 Rue de la Falaise', 6, 4, 660, 396, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est équipé de haut-parleurs intégrés.', 1, 1, 'https://i.pinimg.com/564x/7a/a1/94/7aa19415266b8ad0ad570b7d2ecc3e8e.jpg', 20),
(11, 3, 'La Retreat ', ' 789 Forest Lane', 12, 7, 259, 156, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a une grande baignoire dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/80/42/24/804224faec854e77938dcfcb06c5d08b.jpg', 10),
(12, 3, 'Le Provençal ', ' 1234 Chemin des Oliviers', 5, 3, 264, 159, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a un grand jardin dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/37/e9/74/37e974cc5a8e18faf484bcaeeaaf2919.jpg', 47),
(13, 3, 'Le Cottage ', ' 456 Lakeview Drive', 12, 7, 277, 167, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est idéal pour les familles avec animaux de compagnie.', 1, 0, 'https://i.pinimg.com/564x/83/f9/74/83f9749236aba0e62af582ea1d622f58.jpg', 23),
(14, 3, 'La Tropical town ', ' 789 Avenue des Tropiques', 10, 6, 826, 496, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 1, 1, 1, 1, 1, 1, 0, 'Il y a un grand dressing dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/be/68/28/be68285f85551fa12778ffeaa7b72929.jpg', 35),
(15, 4, 'La Countryside ', ' 1234 Country Road', 5, 3, 1690, 1014, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est équipé de volets électriques.', 1, 0, 'https://i.pinimg.com/564x/41/8e/9d/418e9d9fe54df704e4d316980692ef61.jpg', 25),
(16, 4, 'Le Refuge ', ' 456 Chemin de Montagne', 5, 3, 344, 207, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est parfait pour les jeunes professionnels.', 1, 0, 'https://i.pinimg.com/564x/83/e1/be/83e1be3c454085429418d6b455b98280.jpg', 12),
(17, 4, 'La Beach ', ' 789 Beach Avenue', 2, 2, 120, 72, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est situé dans un quartier historique.', 1, 1, 'https://i.pinimg.com/564x/78/49/56/784956f971839cb2ae02f2c332851343.jpg', 25),
(18, 4, 'La Country ', ' 1234 Route de la Campagne', 4, 3, 1116, 670, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a une bibliothèque dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/d4/3a/c9/d43ac9d878d73b347f9ef013319cf6fe.jpg', 48),
(19, 4, 'Le Loft ', ' 456 Loft Street', 2, 2, 792, 476, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a une grande salle de séjour dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/ba/90/42/ba9042769197aea07b37c6344c569114.jpg', 33),
(20, 5, 'Le Sea ', ' 456 Avenue de l Océan', 5, 3, 264, 159, 'Appartement', 1, 45, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est idéal pour les familles nombreuses.', 1, 0, 'https://i.pinimg.com/564x/0b/99/f7/0b99f7035b15be05d0c1a93bb0f63251.jpg', 26),
(21, 5, 'L Island ', ' 789 Islandview Road', 6, 4, 276, 166, 'Appartement', 1, 48, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a une belle terrasse sur le toit dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/56/0d/fb/560dfb05e09a88f4375df7e02a22d175.jpg', 32),
(22, 5, 'Le Cottage of Le Wood ', ' 1234 Rue de la Forêt', 5, 3, 217, 131, 'Appartement', 1, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est bien situé pour les commerces et les restaurants.', 1, 0, 'https://i.pinimg.com/564x/ef/f9/fb/eff9fb2f987c389d99e7e7ef9ca21878.jpg', 41),
(23, 5, 'Le Lake ', ' 789 Chemin du Lac', 4, 3, 268, 161, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est doté d un grand balcon.', 1, 0, 'https://i.pinimg.com/564x/d9/3e/a8/d93ea80e68e370bdcb11fa243c53f97b.jpg', 21),
(24, 5, 'Le Tropical ', ' 1234 Palm Tree Lane', 13, 7, 206, 124, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, 1, 0, 1, 1, 0, 'Il y a beaucoup d espace pour les invités dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/d8/92/f9/d892f9ffb3f5892f555cbb5073e5f826.jpg', 35),
(25, 6, 'Le Riverside Cabin ', ' 456 Riverfront Drive', 4, 3, 213, 128, 'Appartement', 3, 43, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'La chambre d \n amis de ce logement est confortable et accueillante.', 1, 1, 'https://i.pinimg.com/564x/a6/5d/81/a65d81531ddbb5be73482c8b9893b72b.jpg', 11),
(26, 6, 'La Villa of Le Mountain ', ' 789 Chemin de la Montagne', 5, 3, 247, 149, 'Appartement', 1, 52, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une vue imprenable sur la ville depuis ce logement.', 1, 1, 'https://i.pinimg.com/564x/ff/08/c4/ff08c49d7a3ad48360c2e25e0cd09cbd.jpg', 7),
(27, 6, 'Le Lakeside Lodge ', ' 1234 Lakeview Road', 3, 2, 223, 134, 'Appartement', 1, 62, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a beaucoup de lumière naturelle dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/c7/44/fc/c744fceb7a25e4c2ac5095032805855c.jpg', 49),
(28, 6, 'Le Castle of Country ', ' 456 Route de Campagne', 5, 3, 236, 142, 'Appartement', 2, 56, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une salle de sport dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/71/17/3c/71173ce59cfd9e41576c939605c0de8f.jpg', 24),
(29, 6, 'Le Cliffside Cottage ', ' 789 Cliffside Drive', 2, 2, 272, 164, 'Appartement', 1, 29, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est parfait pour les amateurs d \n art et de culture.', 1, 1, 'https://i.pinimg.com/564x/ee/07/d1/ee07d1dbcb62748b2c4352c2b6466581.jpg', 20),
(30, 7, 'Le Garden ', ' 1234 Rue du Jardin', 2, 2, 690, 414, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est parfait pour les couples retraités.', 1, 0, 'https://i.pinimg.com/564x/c7/8b/96/c78b968bf41fb07a40ece9d1abbdd7ea.jpg', 35),
(31, 7, 'Le Sky ', ' 456 Ski Run Road', 2, 2, 1164, 699, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a une belle terrasse ombragée dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/a2/c6/f8/a2c6f8f6acf1f5a120131e75e225a716.jpg', 16),
(32, 7, 'Le Manor of Le River ', ' 789 Chemin de la Rivière', 3, 2, 231, 139, 'Appartement', 1, 80, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une grande chambre principale dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/7c/27/2d/7c272d36542e3d719d5054861af872d3.jpg', 23),
(33, 7, 'Le Vineyard Cottage ', ' 1234 Vineyard Road', 5, 3, 270, 162, 'Appartement', 2, 1, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est idéal pour les familles avec enfants.', 1, 1, 'https://i.pinimg.com/564x/ee/ac/03/eeac0349ce9578361544e3bb5743430e.jpg', 46),
(34, 7, 'Le Sunset Inn ', ' 1234 Sunset Blvd', 5, 3, 227, 137, 'Appartement', 3, 19, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une belle vue sur la ville depuis ce logement.', 1, 1, 'https://i.pinimg.com/564x/3f/7c/e4/3f7ce409dfe174ddccb0ac59596e5772.jpg', 35),
(35, 8, 'La River House ', ' 456 Riverfront Dr', 5, 3, 828, 497, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est situé à proximité des parcs et des espaces verts.', 1, 0, 'https://i.pinimg.com/564x/a5/9f/4f/a59f4f1706036125bcc884699ce8f882.jpg', 23),
(36, 8, 'L Ocean Breeze ', ' 789 Oceanview Ave', 23, 12, 784, 471, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 1, 1, 1, 1, 1, 1, 1, 'Il y a une grande véranda dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/64/3f/af/643faf28bfa37f438f3ad2e77280bd38.jpg', 14),
(37, 8, 'La Beach House ', ' 456 Beachfront Dr', 3, 2, 1545, 927, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est situé à proximité des commerces et des restaurants.', 1, 0, 'https://i.pinimg.com/564x/13/68/c0/1368c0cc4e348e47c70cd3b13bc04ea2.jpg', 8),
(38, 8, 'La Forest Retreat ', ' 789 Forest Ln', 5, 3, 1332, 800, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'La salle de bain de ce logement est élégante et moderne.', 1, 0, 'https://i.pinimg.com/564x/ac/b6/54/acb654fc3453716729128001c1054f69.jpg', 22),
(39, 8, 'La Mountain View Lodge ', ' 1234 Mountainview Rd', 5, 3, 915, 549, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est idéal pour les personnes âgées.', 1, 0, 'https://i.pinimg.com/564x/2e/f7/fd/2ef7fddc308f1c391fea80f7814e5ad1.jpg', 46),
(40, 9, 'Le Hillside Retreat ', ' 789 Hillside Ave', 4, 3, 174, 105, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a une vue sur le parc depuis ce logement.', 1, 0, 'https://i.pinimg.com/564x/25/8b/85/258b85914e8fdac22db6dab8ddcce112.jpg', 28),
(41, 9, 'Le Lakeside Cabin ', ' 1234 Lakeside Dr', 2, 2, 1104, 663, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est idéal pour les amateurs de cinéma.', 1, 1, 'https://i.pinimg.com/564x/d0/f8/f0/d0f8f057da0357baadd90de3c6584452.jpg', 23),
(42, 9, 'Le Garden Oasis ', ' 456 Garden Way', 14, 8, 483, 290, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 1, 1, 1, 1, 1, 0, 'Ce logement est parfait pour les amateurs de sport nautique.', 1, 1, 'https://i.pinimg.com/736x/a8/eb/9a/a8eb9a11adce4763ce1822ef35d27b0b.jpg', 15),
(43, 9, 'Le Country Cottage ', ' 1234 Country Rd', 3, 2, 568, 341, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est situé à proximité des transports en commun.', 1, 1, 'https://i.pinimg.com/564x/e3/cd/7d/e3cd7d7f5aa4f824d7885c89a67aa86d.jpg', 43),
(44, 9, 'Le Seaside Bungalow ', ' 456 Seaside Blvd', 5, 3, 633, 380, 'Complexe Hotelier', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est situé dans un quartier historique et culturel.', 1, 0, 'https://i.pinimg.com/564x/f0/89/bd/f089bd28d9372132b983eec088a21faf.jpg', 33),
(45, 10, 'Le Forest Lodge ', ' 1234 Forest Rd', 5, 3, 15, 9, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 0, 'La chambre principale de ce logement est spacieuse et confortable.', 1, 0, 'https://i.pinimg.com/564x/8e/da/e3/8edae30cf186249e5db62fa557038976.jpg', 17),
(46, 10, 'La Beach Retreat ', ' 789 Beachfront Ave', 2, 2, 335, 201, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 0, 1, 1, 0, 'Ce logement est équipé d \n une connexion internet haut débit.', 1, 1, 'https://i.pinimg.com/564x/51/29/bb/5129bb1017aef5d4b3bbfdc0e492b8db.jpg', 12),
(47, 10, 'L Island Villa ', ' 789 Islandview Rd', 6, 4, 289, 174, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est récemment rénové et en parfait état.', 1, 0, 'https://i.pinimg.com/564x/e8/bc/0f/e8bc0ff0a13cbb99134433fc4a416cac.jpg', 30),
(48, 10, 'Le Sunset Cottage ', ' 1234 Sunset Blvd', 10, 6, 299, 180, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est facilement accessible en transports en commun.', 1, 0, 'https://i.pinimg.com/564x/39/78/a6/3978a67e053ab028f2e291de6b4c0a9b.jpg', 47),
(49, 10, 'Le Mountain Cabin ', ' 456 Mountainview Rd', 11, 6, 209, 126, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a un grand bureau dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/27/1a/2f/271a2f37461f53e877b90a5696261103.jpg', 21),
(50, 11, 'Le Riverfront Retreat ', ' 456 Riverfront Dr', 6, 4, 168, 101, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Ce logement est équipé de la climatisation.', 1, 1, 'https://i.pinimg.com/564x/e6/5c/f1/e65cf1a25200393cf6d54ed7cb42c130.jpg', 17),
(51, 11, 'L Ocean View Inn ', ' 789 Oceanview Ave', 3, 2, 277, 167, 'Appartement', 1, 65, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une terrasse ensoleillée dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/c6/24/51/c62451cfe09b5cb809f04acf3e6f139b.jpg', 20),
(52, 11, 'Le Country Manor ', ' 1234 Country Rd', 4, 3, 299, 180, 'Appartement', 1, 21, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est proche de toutes les commodités.', 1, 1, 'https://i.pinimg.com/564x/78/cf/14/78cf14d042897580f1bb8da5655fcd69.jpg', 46),
(53, 11, 'Le Seaside Escape ', ' 456 Seaside Blvd', 2, 2, 299, 180, 'Appartement', 1, 3, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Il y a une place de parking réservée pour ce logement.', 1, 1, 'https://i.pinimg.com/564x/32/fe/1a/32fe1ac1773af12becf5f952f2b7fe92.jpg', 9),
(54, 11, 'Le Hilltop Retreat ', ' 789 Hilltop Rd', 5, 3, 254, 153, 'Appartement', 3, 54, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est meublé avec goût.', 1, 1, 'https://i.pinimg.com/564x/dc/52/4d/dc524da3800bc98fac1f705265f8e310.jpg', 42),
(55, 12, 'Le Lakeside Lodge ', ' 1234 Lakeside Dr', 20, 11, 417, 251, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 0, 1, 1, 1, 1, 1, 1, 'Ce logement est spacieux et lumineux.', 1, 1, 'https://i.pinimg.com/564x/c6/dd/08/c6dd08e244c5dad3980a845d0e04c466.jpg', 34),
(56, 12, 'Le Garden Cottage ', ' 456 Garden Way', 15, 8, 753, 452, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 1, 1, 1, 1, 1, 1, 1, 'Il y a beaucoup de rangement dans ce logement.', 1, 1, 'https://i.pinimg.com/564x/d2/e0/da/d2e0daf55ac03f53dde4d5eae649c43c.jpg', 20),
(57, 12, 'L Island Oasis ', ' 789 Islandview Rd', 10, 6, 477, 287, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 0, 0, 1, 1, 1, 1, 0, 'La vue depuis ce logement est incroyable.', 1, 0, 'https://i.pinimg.com/564x/4b/da/7b/4bda7b66c5f4cf33f9777c3cc23a365e.jpg', 10),
(58, 12, 'Le Sunset Villa ', ' 1234 Sunset Blvd', 17, 9, 621, 373, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 1, 1, 1, 1, 1, 1, 0, 'Ce logement est situé dans un quartier calme et agréable.', 1, 1, 'https://i.pinimg.com/564x/d5/a1/55/d5a155f85a84a35cc9bb6966e2e02a10.jpg', 38),
(59, 12, 'Le Mountain Retreat ', ' 456 Mountainview Rd', 15, 8, 573, 344, 'Villa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 1, 0, 1, 1, 1, 1, 0, 'Les finitions de ce logement sont de haute qualité.', 1, 1, 'https://i.pinimg.com/564x/cf/e9/69/cfe969f1a7008e636be0eb6de791af84.jpg', 12),
(60, 13, 'L Oceanfront Inn ', ' 789 Oceanview Ave', 5, 3, 5, 3, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est idéalement situé pour les transports en commun.', 1, 0, 'https://i.pinimg.com/564x/2c/4e/14/2c4e14f431a1d14988395d99a8d9c8fb.jpg', 17),
(61, 13, 'Le Country Cottage Retreat ', ' 1234 Country Rd', 3, 2, 330, 198, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a une cuisine entièrement équipée dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/0d/6b/3c/0d6b3ccb89bede70efff1ffff7540c33.jpg', 32),
(62, 13, 'Le Beachside Cottage ', ' 789 Beachfront Ave', 5, 3, 207, 125, 'Appartement', 1, 79, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est parfait pour une famille.', 1, 1, 'https://i.pinimg.com/564x/69/56/66/69566638a60573595c4a3f251faea61d.jpg', 20),
(63, 13, 'Le Forest Cabin ', ' 1234 Forest Rd', 5, 3, 241, 145, 'Appartement', 3, 71, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est équipé de toutes les commodités modernes.', 1, 1, 'https://i.pinimg.com/564x/89/ed/e0/89ede04781dfb937e862b5bf9de58f4d.jpg', 37),
(64, 13, 'Le Riverfront Lodge ', ' 456 Riverfront Dr', 3, 2, 256, 154, 'Appartement', 3, 64, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'La décoration de ce logement est élégante et moderne.', 1, 1, 'https://i.pinimg.com/564x/08/19/94/0819948663a12da1dd62b49f3fda8aaf.jpg', 42),
(65, 14, 'Le Lakeside Cabin Retreat ', ' 1234 Lakeside Dr', 2, 2, 185, 111, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 4, 1, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est confortable et accueillant.', 1, 0, 'https://i.pinimg.com/564x/7c/96/c3/7c96c3ff91a8b9640e1ac238c08df64f.jpg', 30),
(66, 14, 'Le Garden Villa ', ' 456 Garden Way', 2, 2, 384, 231, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 0, 'Il y a beaucoup de place pour se détendre dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/45/fe/20/45fe20abfb392bf88f5650693664fd4d.jpg', 8),
(67, 14, 'L Island Hideaway ', ' 789 Islandview Rd', 3, 2, 266, 160, 'Hotel', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'La salle de bain de ce logement est spacieuse et moderne.', 1, 0, 'https://i.pinimg.com/564x/a9/94/5c/a9945c8ac02716777d759dc5798d82a0.jpg', 11),
(68, 14, 'Le Seaside B&B ', ' 456 Seaside Blvd', 2, 2, 255, 153, 'Appartement', 3, 3, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Ce logement est bien isolé pour les températures froides.', 1, 1, 'https://i.pinimg.com/564x/d5/86/25/d58625aa9257e230724bef88f97bd902.jpg', 47),
(69, 14, 'Le Hillside Lodge ', ' 789 Hillside Ave', 6, 4, 296, 178, 'Appartement', 3, 53, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 'Le quartier est sûr et sécurisé pour ce logement.', 1, 1, 'https://i.pinimg.com/564x/da/d8/66/dad866419bdb5c629c5334d55a74d43f.jpg', 49),
(70, 15, 'Le Sunset Retreat ', ' 1234 Sunset Blvd', 6, 4, 220, 132, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est parfait pour les étudiants.', 1, 0, 'https://i.pinimg.com/564x/e6/2b/ed/e62bedfecba35f8ce2edc4aa49fb597f.jpg', 8),
(71, 15, 'Le Mountain View Cottage ', ' 456 Mountainview Rd', 13, 7, 294, 177, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Il y a une laverie dans ce logement.', 1, 0, 'https://i.pinimg.com/564x/ed/54/ee/ed54ee6042818e740e042dfc1f63c75f.jpg', 26),
(72, 15, 'Le Beachfront Lodge ', ' 789 Beachfront Ave', 4, 3, 272, 164, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est facile d entretien.', 1, 0, 'https://i.pinimg.com/564x/98/60/e8/9860e837536ab5383528cc4ef1e3c818.jpg', 8),
(73, 15, 'Le Forest Retreat House ', ' 1234 Forest Rd', 7, 4, 201, 121, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Les voisins de ce logement sont amicaux et accueillants.', 1, 0, 'https://i.pinimg.com/564x/f7/7e/b5/f77eb5f6d2263ccedc063f24997db2d6.jpg', 25),
(74, 15, 'Le Ciel Étoilé ', ' 456 Rue du Ciel Étoilé', 7, 4, 228, 137, 'Maison', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, 1, 0, 1, 1, 1, 'Ce logement est situé dans une rue calme.', 1, 0, 'https://i.pinimg.com/564x/e5/9c/9d/e59c9daec13a89cf499d17348f9410d6.jpg', 0);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `ID_RESERVATION` int NOT NULL,
  `ID_HEBERGEMENT` int DEFAULT NULL,
  `ID_CLIENT` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `RESERVATION_PASSEE` tinyint(1) NOT NULL,
  `DATE_DEBUT` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DATE_FIN` text NOT NULL,
  `MONTANT` int NOT NULL,
  `CARTE_BANCAIRE` bigint NOT NULL,
  `NOTE_CLIENT` int NOT NULL,
  `AVIS_CLIENT` text NOT NULL,
  `NOM_TITULAIRE` text NOT NULL,
  `DATE_EXPIRATION` text NOT NULL,
  `NUM_SECU` int NOT NULL,
  PRIMARY KEY (`ID_RESERVATION`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`ID_RESERVATION`, `ID_HEBERGEMENT`, `ID_CLIENT`, `RESERVATION_PASSEE`, `DATE_DEBUT`, `DATE_FIN`, `MONTANT`, `CARTE_BANCAIRE`, `NOTE_CLIENT`, `AVIS_CLIENT`, `NOM_TITULAIRE`, `DATE_EXPIRATION`, `NUM_SECU`) VALUES
(0, 1, 'arthur_fabas@gmail.com', 1, '02/07/4009', '20/09/4010', 700, 111122223333, 4, 'Hotel très propre', 'Fabas', '11/10/4017', 999),
(1, 1, 'exemple@gmail.com', 1, '18/01/4019', '02/08/4008', 1000, 111122223333, 4, 'Hotel sympatique', 'exemple', '11/10/4017', 999),
(2, 2, 'arthur_fabas@gmail.com', 1, '27/01/4034', '16/03/4008', 900, 111122223333, 3, 'Hotel OK', 'Fabas', '11/10/4017', 999),
(3, 50, 'arthur_fabas@gmail.com', 1, '27/01/4034', '16/03/4008', 900, 111122223333, 3, 'Hotel OK', 'Fabas', '11/10/4017', 999),
(4, 74, 'arthur_fabas@gmail.com', 1, '17/08/4018', '16/03/4008', 900, 111122223333, 3, 'Hotel OK', 'Fabas', '11/10/4017', 999),
(5, 74, 'arthur_fabas@gmail.com', 1, '17/08/4018', '17/03/4008', 900, 111122223333, 3, 'Hotel OK', 'Fabas', '11/10/4017', 999);

-- --------------------------------------------------------

--
-- Structure de la table `transport`
--

DROP TABLE IF EXISTS `transport`;
CREATE TABLE IF NOT EXISTS `transport` (
  `ID_TRANSPORT` int NOT NULL,
  `ID_VILLE` int NOT NULL,
  `TYPE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NOM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ARRET1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET2` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET3` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET4` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET5` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET6` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET7` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET8` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET9` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ARRET10` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`ID_TRANSPORT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `transport`
--

INSERT INTO `transport` (`ID_TRANSPORT`, `ID_VILLE`, `TYPE`, `NOM`, `ARRET1`, `ARRET2`, `ARRET3`, `ARRET4`, `ARRET5`, `ARRET6`, `ARRET7`, `ARRET8`, `ARRET9`, `ARRET10`) VALUES
(0, 2, 'BUS', 'ligne C', 'Lakeland', ' Lillian', ' Warner', ' Hazelcrest', ' Buena Vista', ' Bluestem', ' Colorado', ' Portage', ' Heffernan', ' Harper'),
(1, 2, 'TRAM', 'ligne A', 'Pepper Wood', ' Porter', ' Melvin', ' Hollow Ridge', ' Ilene', ' Ohio', ' Kropf', ' Longview', ' Rieder', ' Ryan'),
(2, 2, 'BUS', 'ligne B', 'Lighthouse Bay', ' Magdeline', ' Meadow Valley', ' Vermont', ' Sugar', ' Pawling', ' Darwin', ' American', ' Colorado', ' Troy'),
(3, 1, 'BUS', 'ligne 3', 'Saint Paul', ' Merry', ' Shopko', ' Sage', ' Corben', ' Huxley', ' Fallview', ' Fulton', ' Union', ' Mcbride'),
(4, 1, 'BUS', 'ligne 2', 'Mccormick', ' Shelley', ' Dahle', ' Tomscot', ' Clyde Gallagher', ' Red Cloud', ' Autumn Leaf', ' Oxford', ' Cascade', ' Westerfield'),
(5, 1, 'BUS', 'ligne 1', 'Alpine', ' Green', ' Sycamore', ' Weeping Birch', ' Moose', ' Village', ' Browning', ' 7th', ' Clemons', ' Harbort'),
(6, 3, 'METRO', 'ligne 3', 'Comanche', ' Merchant', ' Meadow Ridge', ' Doe Crossing', ' Rieder', ' Spohn', ' Memorial', ' Clove', ' Sloan', ' Fordem'),
(7, 3, 'METRO', 'ligne 2', 'Oak', ' Judy', ' Artisan', ' Bobwhite', ' Bultman', ' Fremont', ' Fordem', ' Dayton', ' Killdeer', ' Dawn'),
(8, 3, 'METRO', 'ligne 1', 'Weeping Birch', ' Golf', ' Graceland', ' Fremont', ' Blackbird', ' Tennyson', ' Lighthouse Bay', ' Mockingbird', ' Dryden', ' Swallow'),
(9, 4, 'METRO', 'ligne C', 'Gerald', ' Arrowood', ' Longview', ' Crescent Oaks', ' Eagle Crest', ' Thierer', ' Dunning', ' Rieder', ' Crest Line', ' Carioca'),
(10, 4, 'METRO', 'ligne A', 'Carey', ' Magdeline', ' Kipling', ' Crownhardt', ' Weeping Birch', ' Spenser', ' Rigney', ' Valley Edge', ' Golf Course', ' 1st'),
(11, 4, 'METRO', 'ligne B', 'Nancy', ' Dennis', ' Sherman', ' Cottonwood', ' Warrior', ' Barnett', ' Toban', ' Erie', ' Monument', ' Toban'),
(12, 5, 'BUS', 'ligne 3', 'Jenifer', ' Sullivan', ' Monument', ' Holy Cross', ' Logan', ' Ohio', ' Vermont', ' Schiller', ' Kensington', ' Farragut'),
(13, 5, 'BUS', 'ligne 1', 'Helena', ' Gerald', ' Debra', ' Monument', ' Ohio', ' Dawn', ' Pine View', ' Anderson', ' Rieder', ' Jackson'),
(14, 5, 'TRAM', 'ligne 2', 'Hanover', ' Homewood', ' Sullivan', ' Monument', ' International', ' Brentwood', ' Twin Pines', ' Calypso', ' Northridge', ' Mosinee'),
(15, 6, 'BUS', 'ligne C', 'Lunder', ' Pennsylvania', ' Iowa', ' Summit', ' Veith', ' Karstens', ' Claremont', ' Pleasure', ' Sachs', ' Alpine'),
(16, 6, 'BUS', 'ligne A', 'Fairview', ' Vernon', ' Badeau', ' Lukken', ' Elmside', ' Vahlen', ' Truax', ' Transport', ' Esker', ' Artisan'),
(17, 6, 'TRAM', 'ligne B', 'Cardinal', ' Clove', ' Pawling', ' Trailsway', ' Monterey', ' Kipling', ' Debs', ' Farragut', ' Mockingbird', ' Bonner'),
(18, 7, 'BUS', 'ligne 3', 'Scott', ' Anderson', ' Starling', ' Loeprich', ' Columbus', ' Fairview', ' Bultman', ' Lakewood Gardens', ' Toban', ' Harbort'),
(19, 7, 'BUS', 'ligne 1', 'Kensington', ' Manley', ' Crescent Oaks', ' Buell', ' Crest Line', ' Acker', ' Loftsgordon', ' Carioca', ' Lawn', ' Hintze'),
(20, 7, 'BUS', 'ligne 2', 'Katie', ' Petterle', ' Dennis', ' Delladonna', ' Mandrake', ' Jackson', ' American Ash', ' 6th', ' Fairfield', ' Barnett'),
(21, 8, 'BUS', 'ligne B', 'Mosinee', ' Jenna', ' Twin Pines', ' Pleasure', ' Sundown', ' Kedzie', ' Northridge', ' Del Sol', ' Morning', ' Kipling'),
(22, 8, 'BUS', 'ligne C', 'Memorial', ' Monument', ' Canary', ' Walton', ' Hauk', ' 2nd', ' Linden', ' Butterfield', ' Orin', ' Debra'),
(23, 8, 'BUS', 'ligne A', 'Del Sol', ' Sutherland', ' Spohn', ' Hermina', ' South', ' Quincy', ' Barby', ' Crescent Oaks', ' Manitowish', ' Glendale'),
(24, 9, 'BUS', 'ligne 2', 'Lotheville', ' Kensington', ' 4th', ' Donald', ' Homewood', ' Swallow', ' Elka', ' Arkansas', ' Dovetail', ' 3rd'),
(25, 9, 'TRAM', 'ligne 3', 'Haas', ' Bay', ' Moose', ' Kennedy', ' Clarendon', ' Kim', ' Clemons', ' Meadow Ridge', ' Marquette', ' Helena'),
(26, 9, 'BUS', 'ligne 1', 'Hintze', ' Ramsey', ' Almo', ' Becker', ' Ridgeview', ' Norway Maple', ' Arapahoe', ' Lillian', ' Nova', ' Rieder'),
(27, 10, 'BUS', 'ligne B', 'Spaight', ' Muir', ' Caliangt', ' Sutteridge', ' Fordem', ' Elgar', ' Ryan', ' Iowa', ' Towne', ' Farmco'),
(28, 10, 'TRAM', 'ligne C', 'Loftsgordon', ' Blaine', ' Fulton', ' Drewry', ' Center', ' Becker', ' Mitchell', ' Monica', ' Main', ' Lyons'),
(29, 10, 'BUS', 'ligne A', 'Lien', ' Roxbury', ' Norway Maple', ' Ryan', ' Blue Bill Park', ' Hoard', ' Bluejay', ' 3rd', ' Vernon', ' Hauk'),
(30, 11, 'BUS', 'ligne 2', 'High Crossing', ' Golden Leaf', ' High Crossing', ' Lakewood', ' Golden Leaf', ' Farragut', ' Canary', ' Sunnyside', ' Mayfield', ' Mcguire'),
(31, 11, 'BUS', 'ligne 3', 'Maywood', ' Coolidge', ' Crescent Oaks', ' Fordem', ' Leroy', ' Rutledge', ' Springs', ' Meadow Valley', ' Eastlawn', ' Hintze'),
(32, 11, 'TRAM', 'ligne 1', 'Manufacturers', ' Glacier Hill', ' Mccormick', ' Prairieview', ' Doe Crossing', ' 2nd', ' Barby', ' Loomis', ' Truax', ' Fallview'),
(33, 12, 'TRAM', 'ligne C', 'Chinook', ' Ruskin', ' Vermont', ' Moland', ' Portage', ' Debs', ' Morrow', ' Golf View', ' Anhalt', ' Nobel'),
(34, 13, 'METRO', 'ligne 2', 'Badeau', ' Sutteridge', ' Tony', ' Carpenter', ' Cambridge', ' Eagle Crest', ' Schmedeman', ' Carey', ' Lakewood Gardens', ' Calypso'),
(35, 13, 'METRO', 'ligne 3', 'Algoma', ' Fisk', ' Cody', 'Sutteridge', ' Tony', ' Carpenter', 'Crownhardt', ' Londonderry', ' Nancy', 'Eagle Crest'),
(36, 13, 'METRO', 'ligne 1', 'Algoma', ' Fisk', ' Cody', ' Onsgard', ' Riverside', ' Browning', ' 5th', ' Crownhardt', ' Londonderry', ' Nancy'),
(37, 14, 'METRO', 'ligne B', 'Wayridge', ' Reindahl', ' Holy Cross', ' Little Fleur', ' Tomscot', ' Merry', ' Eliot', ' Nelson', ' La Follette', ' Glendale'),
(38, 14, 'METRO', 'ligne A', 'Elmside', ' Waywood', ' Montana', ' Waxwing', ' Kim', ' Lerdahl', ' Carberry', ' Eagle Crest', ' Shasta', ' Menomonie');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID UTILISATEUR` int NOT NULL,
  `NOM` text NOT NULL,
  `PRENOM` text NOT NULL,
  `IDENTIFIANT` text NOT NULL,
  `PASSWORD` text NOT NULL,
  `Type` tinyint(1) NOT NULL,
  `CLIENT REGULIER` tinyint(1) NOT NULL,
  `NOMBRE DE LOCATION` int NOT NULL,
  PRIMARY KEY (`ID UTILISATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID UTILISATEUR`, `NOM`, `PRENOM`, `IDENTIFIANT`, `PASSWORD`, `Type`, `CLIENT REGULIER`, `NOMBRE DE LOCATION`) VALUES
(1, 'Fabas', 'Arthur', 'arthur_fabas@gmail.com', '0', 1, 1, 0),
(2, 'Jacquis', 'Severin', 'Jacquis.severin@gmail.com', 'aaaa', 1, 0, 0),
(3, 'exemple', 'exemple', 'exemple@gmail.com', 'A', 1, 1, 2),
(4, 'exemple5', 'exemple5', 'exemple5', 'exemple5', 1, 1, 5),
(5, 'delarbre', 'ysee', 'yd', '1209', 1, 0, 0),
(6, 'Fabas', 'Arthur', 'arthur_fabas@gmail.com', '0', 0, 0, 0),
(7, 'Jacquis', 'Severin', 'Jacquis.severin@gmail.com', 'aaaa', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `ID_VILLE` int NOT NULL,
  `NOM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NOM_PAYS` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DESCRIPTION` text NOT NULL,
  PRIMARY KEY (`ID_VILLE`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`ID_VILLE`, `NOM`, `NOM_PAYS`, `DESCRIPTION`) VALUES
(2, 'Chamonix-Mont-Blanc', 'France', 'Chamonix est une ville située dans les Alpes françaises, dans la région Auvergne-Rhône-Alpes. Elle est célèbre pour sa vue panoramique sur le Mont-Blanc, le plus haut sommet d Europe occidentale. '),
(1, 'Nice', 'France', 'Capitale de la France offrant monuments historiques, beaux jardins, merveilleux restaurant et animations'),
(3, 'Barcelone', 'Espagne', 'Barcelone est une ville située dans le nord-est de l Espagne, sur la côte méditerranéenne. Elle est la capitale de la Catalogne et l une des destinations touristiques les plus populaires d Europe. '),
(4, 'Paris', 'France', 'Paris est la capitale de la France et l une des villes les plus emblématiques du monde. Elle est située dans le nord de la France, sur les rives de la Seine. '),
(5, 'Zurich', 'Suisse', 'Zurich est la plus grande ville de Suisse, située dans le nord-est du pays, sur les rives de la Limmat. La ville est un important centre économique et financier, avec de nombreuses banques et institutions financières internationales. '),
(6, 'Naples', 'Italie', 'Naples est une ville située dans le sud de l Italie, sur la côte ouest du golfe de Naples. Elle est la troisième plus grande ville d Italie et est réputée pour sa riche histoire, sa cuisine délicieuse et son architecture baroque. '),
(7, 'Rome', 'Italie', 'Rome est la capitale de l Italie et l une des villes les plus historiques et culturelles du monde. Située au centre de l Italie, sur les rives du Tibre, Rome est célèbre pour son architecture ancienne, ses monuments emblématiques et sa cuisine délicieuse. '),
(8, 'La Havane', 'Cuba', 'La Havane est la capitale de Cuba et l une des villes les plus fascinantes des Caraïbes. Située sur la côte nord de l île, La Havane est réputée pour son architecture coloniale espagnole bien conservée, ses voitures classiques colorées et son atmosphère nostalgique. '),
(9, 'San José', 'Costa Rica', 'San José est la capitale et la plus grande ville du Costa Rica, située dans la vallée centrale du pays. La ville est un centre culturel, politique et économique important, ainsi qu une plaque tournante pour les voyageurs visitant le pays. '),
(10, 'Le Cap', 'Afrique du Sud', 'Le Cap est la deuxième ville la plus peuplée d Afrique du Sud et une destination touristique populaire pour ses belles plages, ses paysages spectaculaires, son histoire riche et sa culture vibrante. '),
(11, 'Sydney', 'Australie', 'Sydney est la plus grande ville d Australie et la capitale de l État de Nouvelle-Galles du Sud. La ville est célèbre pour son emblématique opéra de Sydney, son pont du port de Sydney et ses plages de sable blanc magnifiques. '),
(12, 'Brisbane', 'Australie', 'Brisbane est la capitale de l État du Queensland, dans le nord-est de l Australie. La ville est célèbre pour son climat tropical chaud et ensoleillé, ainsi que pour son mode de vie décontracté et détendu.'),
(13, 'Singapour', 'Singapour', 'Singapour est une ville-État située dans le sud-est de l Asie. La ville est célèbre pour ses gratte-ciel modernes, ses centres commerciaux luxueux, ses jardins botaniques, ses parcs et ses attractions culturelles. Les visiteurs peuvent explorer les différents quartiers de la ville, tels que le quartier colonial de Chinatown, le quartier de la rivière de Clarke Quay et le quartier de l Orchard Road, le plus grand centre commercial de la ville.'),
(14, 'New York', 'USA', 'New York est la ville la plus peuplée des États-Unis et l une des villes les plus emblématiques au monde. La ville est connue pour son architecture impressionnante, ses musées de renommée mondiale, ses quartiers dynamiques et sa vie nocturne animée.'),
(15, 'Los Angeles', 'USA', 'Los Angeles est une ville côtière située dans le sud de la Californie, aux États-Unis. La ville est célèbre pour ses plages, son climat chaud et ensoleillé, ses collines emblématiques, ses studios de cinéma et ses quartiers dynamiques.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
