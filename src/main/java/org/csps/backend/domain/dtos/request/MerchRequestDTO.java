package org.csps.backend.domain.dtos.request;

import java.util.ArrayList;
import java.util.List;

import org.csps.backend.domain.enums.MerchType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MerchRequestDTO {
    private String merchName;
    private String description;
    private MerchType merchType;
    
    @JsonProperty("variants")
    private List<MerchVariantRequestDTO> merchVariantRequestDto = new ArrayList();
}
