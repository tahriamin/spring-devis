package com.site.devis.controller;

import com.site.devis.dto.DevisDto;
import com.site.devis.model.Devis;
import com.site.devis.service.DevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/devis")
public class DevisController {

    @Autowired
    private DevisService devisService;

    // ✅ Récupérer les devis d’un utilisateur
    @GetMapping("/{utilisateurId}")
    public ResponseEntity<List<Devis>> getDevisByUtilisateur(@PathVariable Long utilisateurId) {
        List<Devis> devis = devisService.getDevisByUtilisateur(utilisateurId);
        return ResponseEntity.ok(devis);
    }

    // ✅ Créer un nouveau devis
    @PostMapping
    public ResponseEntity<Devis> createDevis(@RequestBody DevisDto devis) {
        Devis created = devisService.saveDevis(devis);
        return ResponseEntity.ok(created);
    }

    // 🔧 Récupérer tous les devis (sans filtre)
    @GetMapping
    public ResponseEntity<List<Devis>> getAllDevis() {
        List<Devis> devisList = devisService.getAllDevis();
        return ResponseEntity.ok(devisList);
    }

    @DeleteMapping("/{idDevis}")
    public void deleteDevis(@PathVariable Long idDevis) {
        devisService.deleteDevis(idDevis);
    }

}
