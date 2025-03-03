package com.site.devis.service;

import com.site.devis.model.Utilisateur;
import com.site.devis.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public Utilisateur register(Utilisateur utilisateur) {
//        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }
}

