// MerchService.java
package org.csps.backend.service;

import java.util.List;

import org.csps.backend.domain.dtos.request.MerchRequestDTO;
import org.csps.backend.domain.dtos.response.MerchResponseDTO;

public interface MerchService {
    MerchResponseDTO createMerch(MerchRequestDTO request);
    List<MerchResponseDTO> getAllMerch();
    MerchResponseDTO getMerchById(Long id);
}
