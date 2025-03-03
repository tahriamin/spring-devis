package com.site.devis.controller;

import com.site.devis.model.Utilisateur;
import com.site.devis.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Utilisateur utilisateur) {
        utilisateurService.register(utilisateur);
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }
}
