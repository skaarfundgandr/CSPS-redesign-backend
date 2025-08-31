package org.csps.backend.repository;

import java.util.Optional;

import org.csps.backend.domain.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByEmail(String email);
    Optional<UserProfile> findByEmail(String email);
}
