package com.cib.back.api.controllers;

import com.cib.back.api.models.payload.PartnerPayload;
import com.cib.back.api.services.PartnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/partner")
@Tag(name = "Partner Management", description = "APIs for managing partner")
public class PartnerController {
    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping()
    @Operation(summary = "Add partner", description = "Add one partner in database")
    public ResponseEntity<List<PartnerPayload>> addPartner(@Valid @RequestBody PartnerPayload partnerPayload) {
        List<PartnerPayload> partnerPayloads = partnerService.addPartner(partnerPayload);

        return ResponseEntity.created(URI.create("api/partner/id")).body(partnerPayloads);
    }

    @GetMapping()
    @Operation(summary = "Get partners", description = "Retrieve all partner in database")
    public ResponseEntity<List<PartnerPayload>> getAllPartner() {
        List<PartnerPayload> partnerPayloads = partnerService.getAllPartner();

        return ResponseEntity.ok().body(partnerPayloads);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete partner", description = "Delete one partner in database by id")
    public ResponseEntity<Null> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);

        return ResponseEntity.noContent().build();
    }
}
