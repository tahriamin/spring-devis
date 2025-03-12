package com.site.devis.controller;

import com.site.devis.model.Devis;
import com.site.devis.service.DevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devis")
public class DevisController {

    @Autowired
    private DevisService devisService;

    @GetMapping("/{utilisateurId}")
    public ResponseEntity<List<Devis>> getDevisByUtilisateur(@PathVariable Long utilisateurId) {
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Devis>> getAllDevis() {
        List<Devis> allDevis = devisService.getAllDevis();
        return ResponseEntity.status(HttpStatus.OK).body(allDevis);
    }
}
