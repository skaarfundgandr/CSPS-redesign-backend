package org.csps.backend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.csps.backend.domain.enums.ClothingSizing;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchVariantId;

    @ManyToOne
    @JoinColumn(name = "merch_id", nullable = false)
    private Merch merch;

    // Variant-specific attributes
    private String color;

    @Enumerated(EnumType.STRING)
    private ClothingSizing size;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stockQuantity;
}
