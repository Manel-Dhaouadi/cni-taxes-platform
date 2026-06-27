package com.taxes.repository;

import com.taxes.entity.Municipalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipaliteRepository extends JpaRepository<Municipalite, Long> {
    Optional<Municipalite> findByCodeMunicipalite(String code);
}
