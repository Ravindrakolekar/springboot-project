package com.project.springboot.controller;


import com.project.springboot.service.EncryptionAndDecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class EncryptionAndDecryptionController {


    @Autowired
    private EncryptionAndDecryptionService encryptionAndDecryptionService;

    @GetMapping("/encrypt/{originialKey}")
    public String encryptionApi(@PathVariable String originialKey) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {


        String encryptionKey = encryptionAndDecryptionService.encryptMethod(originialKey);

        return encryptionKey;
    }

    @GetMapping("/Decrypt/{encryptionKeyData}/{scerectKey}")
    public String DecryptApi(@PathVariable String encryptionKeyData,@PathVariable String scerectKey) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {


        String decryptionkey = encryptionAndDecryptionService.DecryptMethod(encryptionKeyData,scerectKey);

        return decryptionkey;
    }



}
