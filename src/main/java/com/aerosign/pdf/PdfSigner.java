package com.aerosign.pdf;

import org.springframework.stereotype.Service;

@Service
public class PdfSigner {

    public String sign(String pdfPath){
        //Пока что заглушка
        System.out.println("Документ подписан: " + pdfPath);
        return pdfPath.replace(".pdf", "_signed.pdf");
    }
}
