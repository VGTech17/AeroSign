package com.aerosign.pdf;

import com.aerosign.entity.secondary.FlightLog;
import com.aerosign.security.KeyStoreService;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.*;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Collections;

@Service
public class PdfSigner {

    private static final Logger log = LoggerFactory.getLogger(PdfSigner.class);


    private final KeyStoreService keyStoreService;

    public PdfSigner(KeyStoreService keyStoreService) {
        this.keyStoreService = keyStoreService;
    }

    public byte[] signPdf(byte[] pdfBytes, FlightLog flightLog) {
        try {
            PrivateKey privateKey = keyStoreService.getPrivateKey();
            Certificate certificate = keyStoreService.getCertificate();

            CMSTypedData cmsData = new CMSProcessableByteArray(pdfBytes);

            ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withRSA")
                    .setProvider("BC")
                    .build(privateKey);

            CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
            generator.addSignerInfoGenerator(
                    new JcaSignerInfoGeneratorBuilder(
                            new JcaDigestCalculatorProviderBuilder().setProvider("BC").build()
                    ).build(contentSigner, (java.security.cert.X509Certificate) certificate)
            );
            generator.addCertificates(new JcaCertStore(Collections.singletonList(certificate)));

            CMSSignedData signedData = generator.generate(cmsData, false);
            log.info("PDF-документ успешно подписан: {}", flightLog.getStudentName());
            return signedData.getEncoded();

        } catch (Exception e) {
            log.error("Ошибка при подписании PDF-документа для студента {}", flightLog.getStudentName(), e);
            throw new RuntimeException("Не удалось подписать PDF-документ", e);
        }
    }
}