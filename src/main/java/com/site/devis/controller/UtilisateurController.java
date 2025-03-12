package com.site.devis.controller;

import com.site.devis.dto.UtilisateurDto;
import com.site.devis.model.Devis;
import com.site.devis.model.Utilisateur;
import com.site.devis.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurService.register(utilisateurDto);
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurList = utilisateurService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurList);
    }
}
