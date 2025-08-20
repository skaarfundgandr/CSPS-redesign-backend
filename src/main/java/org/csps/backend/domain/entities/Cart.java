package org.csps.backend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "StudentCart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    private String cartId; // same as studentId

    @OneToOne
    @MapsId  // tells JPA to use the same value as student_id for the primary key
    @JoinColumn(name = "student_id") // FK and PK at the same time
    private Student student;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> items;
}
