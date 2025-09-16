package org.csps.backend.mapper;


import org.csps.backend.domain.dtos.request.MerchVariantRequestDTO;
import org.csps.backend.domain.dtos.response.MerchVariantResponseDTO;
import org.csps.backend.domain.entities.MerchVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MerchVariantMapper {

    // Maps the merchId of DTO to merch.merchId
    // Entity -> DTO
    @Mapping (target = "merchId", source="merch.merchId")
    MerchVariantResponseDTO toResponseDTO (MerchVariant merchVariant);

    // DTO -> Entity
    @Mapping(target = "merch", ignore = true)
    @Mapping(target = "merchVariantId", ignore = true)
    MerchVariant toEntity(MerchVariantRequestDTO merchVariantResponseDTO);
}
