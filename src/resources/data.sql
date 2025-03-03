-- Suppression des données existantes (facultatif, utile pour les tests)
DELETE FROM devis;
DELETE FROM utilisateur;

-- Insertion d'un utilisateur ADMIN
INSERT INTO utilisateur (nom, email, mot_de_passe, role) VALUES
('Admin', 'admin@devis.com', 'admin123', 'ADMIN');

-- Insertion d'utilisateurs normaux
INSERT INTO utilisateur (nom, email, mot_de_passe, role) VALUES
('Jean Dupont', 'jean.dupont@email.com', 'password123', 'USER'),
('Sophie Martin', 'sophie.martin@email.com', 'password456', 'USER');

-- Insertion de devis liés aux utilisateurs
INSERT INTO devis (utilisateur_id, client_nom, details, budget, date_limite) VALUES
(1, 'Entreprise A', 'Création d’un site e-commerce', 2500.00, '2024-06-30'),
(2, 'Freelance B', 'Développement d’une API sécurisée', 1800.00, '2024-07-15'),
(2, 'Start-up C', 'Application mobile pour gestion de stock', 3500.00, '2024-08-01');
