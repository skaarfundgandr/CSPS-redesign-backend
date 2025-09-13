 package org.csps.backend.service.impl;

import java.util.List;

import org.csps.backend.domain.dtos.request.MerchRequestDTO;
import org.csps.backend.domain.dtos.response.MerchResponseDTO;
import org.csps.backend.domain.dtos.response.MerchVariantResponseDTO;
import org.csps.backend.domain.entities.Merch;
import org.csps.backend.domain.entities.MerchVariant;
import org.csps.backend.mapper.MerchMapper;
import org.csps.backend.mapper.MerchVariantMapper;
import org.csps.backend.repository.MerchRepository;
import org.csps.backend.service.MerchService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerchServiceImpl implements MerchService {

    private final MerchRepository merchRepository;
    private final MerchMapper merchMapper;

    private final MerchVariantMapper merchVariantMapper;

    @Override
    @Transactional
    public MerchResponseDTO createMerch(MerchRequestDTO request) {
        // Step 1: Convert request → entity
        Merch merch = merchMapper.toEntity(request);

        // Step 2: Convert variant DTOs → entities
        List<MerchVariant> merchVariants = request.getMerchVariantRequestDto()
            .stream()
            .map(merchVariantMapper::toEntity)
            .toList();

        // Attach each variant back to merch
        merchVariants.forEach(variant -> variant.setMerch(merch));
        merch.setMerchVariantList(merchVariants);

        // Step 3: Save entity
        Merch savedMerch = merchRepository.save(merch);

        // Step 4: Convert back to response DTO
        MerchResponseDTO responseDTO = merchMapper.toResponseDTO(savedMerch);

        // Fill in the variants manually using MerchVariantMapper
        List<MerchVariantResponseDTO> variantResponseDTOs = savedMerch.getMerchVariantList()
            .stream()
            .map(merchVariantMapper::toResponseDTO)
            .toList();

        responseDTO.setVariants(variantResponseDTOs);

        return responseDTO;
    }


    
    @Override
    public List<MerchResponseDTO> getAllMerch() {
        return merchRepository.findAll()
                .stream()
                .map(merchMapper::toResponseDTO)
                .toList();
    }

    @Override
    public MerchResponseDTO getMerchById(Long id) {
        Merch merch = merchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merch not found with id: " + id));
        return merchMapper.toResponseDTO(merch);
    }
}
