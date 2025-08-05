package com.aerosign.entity.secondary;

import jakarta.persistence.*; // или javax.persistence.*
import java.time.LocalDateTime;

@Entity
public class SignatureRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightLogId;
    private String signer;
    private String comment;
    private String status;
    private LocalDateTime signedAt;

    // ✅ Добавь геттеры и сеттеры
    public Long getFlightLogId() {
        return flightLogId;
    }

    public void setFlightLogId(Long flightLogId) {
        this.flightLogId = flightLogId;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }

    // id, toString, equals, hashCode – по желанию
}