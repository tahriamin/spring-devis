package com.site.devis.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static String hashPassword(String password) {
        try {
            // Création d'un MessageDigest pour SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Hachage du mot de passe
            byte[] hashedBytes = messageDigest.digest(password.getBytes());

            // Conversion du tableau d'octets en chaîne hexadécimale
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString(); // Retourne le mot de passe haché
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
