package com.project.springboot.service;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptionAndDecryptionService {

    //logic for encryption
    public String encryptMethod(String originialKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        // how to generate Secret Key with AES algorithm
        SecretKey key  = genrateSecretkey();

        String screctKey = Base64.getEncoder().encodeToString(key.getEncoded());

        // logic for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encryptionBytsData = cipher.doFinal(originialKey.getBytes());
        return "encryption Key :: "  + Base64.getEncoder().encodeToString(encryptionBytsData) + "SecretKey ::  " + screctKey;

    }


    // Secret Key generation code
    private SecretKey genrateSecretkey() throws NoSuchAlgorithmException {
        //logic part below

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();

    }


    public String DecryptMethod(String encryptionKey, String scerectKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] decodeKey = Base64.getDecoder().decode(scerectKey);

        SecretKey secretKey = new SecretKeySpec(decodeKey,0,decodeKey.length,"AES");



        //logic Decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);

        byte[] decodeBytes = Base64.getDecoder().decode(encryptionKey);
        byte[] decryptedByte = cipher.doFinal(decodeBytes);

        return new String(decryptedByte);


    }
}
