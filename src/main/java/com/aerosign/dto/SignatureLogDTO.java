package com.aerosign.dto;

import java.time.LocalDateTime;

public class SignatureLogDTO {
    private LocalDateTime signedAt;
    private String userName;
    private String algorithm;
    private String keySerialNumber;

    public SignatureLogDTO(LocalDateTime signedAt, String userName, String algorithm, String keySerialNumber) {
        this.signedAt = signedAt;
        this.userName = userName;
        this.algorithm = algorithm;
        this.keySerialNumber = keySerialNumber;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
