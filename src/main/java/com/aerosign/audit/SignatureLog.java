package com.aerosign.audit;

import com.aerosign.entity.FlightLog;
import com.aerosign.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "signature_logs")
public class SignatureLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_log_id", nullable = false)
    private FlightLog flightLog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "signed_at", nullable = false)
    private LocalDateTime signedAt;

    @Column(nullable = false)
    private String algorithm;

    @Column(name = "key_serial_number", nullable = false)
    private String keySerialNumber;

    public SignatureLog() {}

    public SignatureLog(Long id, FlightLog flightLog, User user, LocalDateTime signedAt, String algorithm, String keySerialNumber) {
        this.id = id;
        this.flightLog = flightLog;
        this.user = user;
        this.signedAt = signedAt;
        this.algorithm = algorithm;
        this.keySerialNumber = keySerialNumber;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightLog getFlightLog() {
        return flightLog;
    }

    public void setFlightLog(FlightLog flightLog) {
        this.flightLog = flightLog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getKeySerialNumber() {
        return keySerialNumber;
    }

    public void setKeySerialNumber(String keySerialNumber) {
        this.keySerialNumber = keySerialNumber;
    }
}
