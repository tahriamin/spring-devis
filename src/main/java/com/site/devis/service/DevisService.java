package com.site.devis.service;

import com.site.devis.model.Devis;
import com.site.devis.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DevisService {
    
    private final DevisRepository devisRepository;

    @Autowired
    public DevisService(DevisRepository devisRepository) {
        this.devisRepository = devisRepository;
    }

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
}
