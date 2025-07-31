package com.aerosign.repository.secondary;

import com.aerosign.entity.secondary.SignatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureRepository extends JpaRepository<SignatureRecord, Long> {
}
