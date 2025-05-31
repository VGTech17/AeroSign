package com.aerosign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SignatureRepository extends JpaRepository<SignatureRepository, Long> {
}
