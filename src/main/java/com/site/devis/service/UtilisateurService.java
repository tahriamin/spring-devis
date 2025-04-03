package com.site.devis.service;

import com.site.devis.dto.UtilisateurDto;
import com.site.devis.model.Utilisateur;
import com.site.devis.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public Utilisateur register(UtilisateurDto utilisateurDto) {
//        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        Utilisateur utilisateurToSave = Utilisateur.builder().
                email(utilisateurDto.getEmail())
                .password(utilisateurDto.getPassword())
                .nom(utilisateurDto.getNom()).
                build();

        Utilisateur savedUser = utilisateurRepository.save(utilisateurToSave);
        log.info("utilisateur saved id is {}", savedUser.getId());

        return savedUser;
    }
}

