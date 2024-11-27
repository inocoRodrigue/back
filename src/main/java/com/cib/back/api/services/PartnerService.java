package com.cib.back.api.services;

import com.cib.back.api.mappers.PartnerMapper;
import com.cib.back.api.models.payload.PartnerPayload;
import com.cib.back.domain.models.partner.Partner;
import com.cib.back.domain.services.PartnerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerMapper partnerMapper;
    private final PartnerManager partnerManager;

    @Autowired
    public PartnerService(PartnerMapper partnerMapper, PartnerManager partnerManager) {
        this.partnerMapper = partnerMapper;
        this.partnerManager = partnerManager;
    }

    public List<PartnerPayload> getAllPartner() {
        List<Partner> partners = partnerManager.getAllPartner();

        return partnerMapper.toPayload(partners);
    }

    public List<PartnerPayload> addPartner(PartnerPayload partnerPayload) {
        Partner partner = partnerMapper.toEntity(partnerPayload);

        partnerManager.addPartner(partner);

        return getAllPartner();
    }

    public void deletePartner(Long id) {
        this.partnerManager.deletePartner(id);
    }
}
