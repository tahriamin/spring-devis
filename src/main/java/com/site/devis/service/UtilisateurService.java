package com.site.devis.service;

import com.site.devis.dto.UtilisateurDto;
import com.site.devis.model.Utilisateur;
import com.site.devis.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    private PasswordHasher passwordHasher;

    public Utilisateur register(UtilisateurDto utilisateurDto) {
        String hashedPassword = passwordHasher.hashPassword(utilisateurDto.getPassword());

        Utilisateur utilisateurToSave = Utilisateur.builder().
                email(utilisateurDto.getEmail())
                .password(hashedPassword)
                .nom(utilisateurDto.getNom()).
                build();

        Utilisateur savedUser = utilisateurRepository.save(utilisateurToSave);
        log.info("utilisateur saved id is {}", savedUser.getId());

        return savedUser;
    }


    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> findUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }
}

