package com.site.devis.repository;

import com.site.devis.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevisRepository extends JpaRepository<Devis, Long> {
    List<Devis> findByUtilisateurId(Long utilisateurId);
}
