package com.cib.back.api.controllers;

import com.cib.back.api.models.Response;
import com.cib.back.api.models.payload.PartnerPayload;
import com.cib.back.api.services.PartnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping()
    public ResponseEntity<Response> addPartner(@Valid @RequestBody PartnerPayload partnerPayload) {
        Response response = Response.from(partnerService.addPartner(partnerPayload));

        return ResponseEntity.ok().body(response);
    }
}
