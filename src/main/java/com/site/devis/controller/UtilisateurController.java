package com.site.devis.controller;

import com.site.devis.dto.UtilisateurDto;
import com.site.devis.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
