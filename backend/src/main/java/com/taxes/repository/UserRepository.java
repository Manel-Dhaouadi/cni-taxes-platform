package com.taxes.repository;

import com.taxes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByCin(String cin);
    boolean existsByEmail(String email);
    boolean existsByCin(String cin);
    List<User> findByStatut(User.StatutUser statut);
    List<User> findByRole(User.Role role);
}
