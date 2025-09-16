package org.csps.backend.controller;

import org.csps.backend.domain.dtos.request.MerchVariantRequestDTO;
import org.csps.backend.domain.dtos.response.MerchVariantResponseDTO;
import org.csps.backend.service.MerchVariantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/merchVariant")
@RequiredArgsConstructor
public class MerchVariantController {
    private final MerchVariantService merchVariantService;

    @PostMapping("/{merchId}/add")
    public ResponseEntity<MerchVariantResponseDTO> addVariant(
            @PathVariable Long merchId,
            @RequestBody MerchVariantRequestDTO variantRequest) {
        MerchVariantResponseDTO newVariant = merchVariantService.addVariantToMerch(merchId, variantRequest);
        return ResponseEntity.ok(newVariant);
}
}

