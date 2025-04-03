package com.site.devis.service;

import com.site.devis.dto.DevisDto;
import com.site.devis.model.Devis;
import com.site.devis.repository.DevisRepository;
import com.site.devis.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    public Optional<Devis> getDevisById(Long id) {
        return devisRepository.findById(id);
    }

    public Devis createDevis(Devis devis) {
        return devisRepository.save(devis);
    }

    public void deleteDevis(Long id) {
        devisRepository.deleteById(id);
    }

    public Devis saveDevis(DevisDto devisDto) {
        Devis devis = Devis.builder()
                .details(devisDto.getDetails())
                .budget(devisDto.getBudget())
                .clientNom(devisDto.getClientNom())
                .build();
        return devisRepository.save(devis);
    }

    public List<Devis> getDevisByUtilisateur(Long utilisateurId) {
        return devisRepository.findByUtilisateurId(utilisateurId);
    }

}
