package org.csps.backend.repository;

import org.csps.backend.domain.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRespository extends JpaRepository<UserAccount, Long> {
    boolean existsByUsername(String username);
}
