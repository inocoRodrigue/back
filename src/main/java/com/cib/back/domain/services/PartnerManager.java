package com.cib.back.domain.services;

import com.cib.back.domain.models.partner.Partner;
import com.cib.back.domain.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerManager {
    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerManager(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<Partner> getAllPartner() {
        return partnerRepository.findAll();
    }

    public void addPartner(Partner partner) {
        // TODO : add verification before adding element (value object or not ?)
        partnerRepository.save(partner);
    }

    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }
}
