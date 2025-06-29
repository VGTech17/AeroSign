package com.aerosign.signature;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Store;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;

@Service
public class SignatureValidator {

    static {
        // Подключаем BouncyCastle как провайдера
        Security.addProvider(new BouncyCastleProvider());
    }

    public boolean validate(Path signaturePath) {
        try {
            byte[] sigBytes = Files.readAllBytes(signaturePath);
            CMSSignedData signedData = new CMSSignedData(sigBytes);

            Store<X509CertificateHolder> certStore = signedData.getCertificates();
            SignerInformationStore signers = signedData.getSignerInfos();

            for (SignerInformation signer : signers.getSigners()) {
                Collection<X509CertificateHolder> certCollection = certStore.getMatches(signer.getSID());
                if (certCollection.isEmpty()) {
                    System.err.println("Сертификат не найден для подписи");
                    return false;
                }

                X509CertificateHolder certHolder = certCollection.iterator().next();
                X509Certificate cert = new JcaX509CertificateConverter()
                        .setProvider("BC")
                        .getCertificate(certHolder);

                if (!signer.verify(new JcaSimpleSignerInfoVerifierBuilder()
                        .setProvider("BC")
                        .build(cert))) {
                    System.err.println("Подпись недействительна");
                    return false;
                }
            }

            return true;

        } catch (IOException | CMSException | CertificateException | org.bouncycastle.operator.OperatorCreationException e) {
            e.printStackTrace();
            return false;
        }
    }
}
