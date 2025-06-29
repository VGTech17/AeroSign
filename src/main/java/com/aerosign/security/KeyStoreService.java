package com.aerosign.security;

import com.aerosign.config.KeyStoreProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

@Service
public class KeyStoreService {

    private final KeyStoreProperties properties;
    private PrivateKey privateKey;
    private X509Certificate certificate;

    public KeyStoreService(KeyStoreProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void init() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream stream = new ClassPathResource(properties.getPath()).getInputStream()){
            keyStore.load(stream, properties.getPassword().toCharArray());
        }

        Key key = keyStore.getKey(properties.getAlias(), properties.getPassword().toCharArray());
        if (key instanceof  PrivateKey) {
            privateKey = (PrivateKey) key;
            certificate = (X509Certificate) keyStore.getCertificate(properties.getAlias());
        }
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public X509Certificate getCertificate() {
        return certificate;
    }
}
