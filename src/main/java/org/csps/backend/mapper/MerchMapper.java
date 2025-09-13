package org.csps.backend.mapper;

import org.csps.backend.domain.dtos.request.MerchRequestDTO;
import org.csps.backend.domain.dtos.response.MerchResponseDTO;
import org.csps.backend.domain.entities.Merch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MerchVariantMapper.class})
public interface MerchMapper {
    // Entity -> DTO
    @Mapping(target = "variants", source = "merchVariantList")
    MerchResponseDTO toResponseDTO (Merch merch);

    // DTO -> Entity
    @Mapping(target = "merchVariantList", source = "merchVariantRequestDto")
    Merch toEntity(MerchRequestDTO dto);
}
