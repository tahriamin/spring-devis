package com.site.devis.controller;

import com.site.devis.dto.UtilisateurDto;
import com.site.devis.model.Devis;
import com.site.devis.model.Utilisateur;
import com.site.devis.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurService.register(utilisateurDto);
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> allUtilisateurs = utilisateurService.findAllUtilisateurs();
        return ResponseEntity.ok(allUtilisateurs);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Void> getUtilisateurByEmail(@PathVariable String email) {
        Optional<Utilisateur> utilisateurByEmail = utilisateurService.findUtilisateurByEmail(email);
        if (utilisateurByEmail.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}