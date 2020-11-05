package com.bkmexpress.sim.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;


public class BKMSignatureImpl  {

    private static final String PRIVATE_KEY = "privkey.der";
    private static final String PUBLIC_KEY = "pubkey.der";
    private static final Logger logger = LoggerFactory.getLogger(BKMSignatureImpl.class);

    public String sign(String message) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {
            InputStream privateKeyStream = this.retrieveInputStream(PRIVATE_KEY);
            PrivateKey privateKey = this.retrievePrivateKey(privateKeyStream);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] signedResult = signature.sign();
            logger.info("Message signed.");
            return Base64.encodeBase64String(signedResult);
    }

    public boolean verify(String signatureString, String appendedString) throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
            InputStream publicKeyStream = this.retrieveInputStream(PUBLIC_KEY);
            byte[] keyBytes = IOUtils.toByteArray(publicKeyStream);

            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(keyBytes));
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(cert);
            signature.update(appendedString.getBytes());
            byte[] decodedResult = Base64.decodeBase64(signatureString);
            logger.info("Message verified.");
            return signature.verify(decodedResult);
    }

    private PrivateKey retrievePrivateKey(InputStream inputStream) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = IOUtils.toByteArray(inputStream);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        logger.info("Private key is retrieved.");
        return kf.generatePrivate(spec);
    }

    private InputStream retrieveInputStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }


//  560  openssl genrsa -out privkey.pem
//  563  openssl req -new -x509 -key privkey.pem -outform DER -out pubkey.der
//  565  openssl pkcs8 -topk8 -nocrypt -in privkey.pem -outform der -out privkey.der
}
