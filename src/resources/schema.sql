-- Suppression des tables si elles existent déjà (évite les conflits lors du redémarrage)
DROP TABLE IF EXISTS devis;
DROP TABLE IF EXISTS utilisateur;

-- Création de la table Utilisateur
CREATE TABLE utilisateur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'USER'
);

-- Création de la table Devis
CREATE TABLE devis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    utilisateur_id BIGINT NOT NULL,
    client_nom VARCHAR(255) NOT NULL,
    details TEXT NOT NULL,
    budget DECIMAL(10,2) NOT NULL,
    date_limite DATE NOT NULL,
    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE
);
