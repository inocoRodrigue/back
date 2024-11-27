package com.cib.back.api.controllers;

import com.cib.back.api.models.Response;
import com.cib.back.api.models.payload.PartnerPayload;
import com.cib.back.api.services.PartnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

        return ResponseEntity.created(URI.create("api/partner/id")).body(response);
    }

    @GetMapping()
    public ResponseEntity<Response> getAllPartner() {
        Response response = Response.from(partnerService.getAllPartner());

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);

        return ResponseEntity.noContent().build();
    }
}
