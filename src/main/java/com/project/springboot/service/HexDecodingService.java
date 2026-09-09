package com.project.springboot.service;

import com.project.springboot.config.HexDecodingProperties;
import com.project.springboot.exception.InvalidHexException;
import com.project.springboot.util.HexUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HexDecodingService {

    private final HexDecodingProperties properties;

    public HexDecodingService(HexDecodingProperties properties) {
        this.properties = properties;
    }

    public void decode(Map<String, Object> request) {

        if (!properties.isEnabled()) {
            return;
        }

        if (request == null || request.isEmpty()) {
            return;
        }

        for (String field : properties.getFields()) {

            if (!request.containsKey(field)) {
                continue;
            }

            Object value = request.get(field);

            if (!(value instanceof String stringValue)) {
                continue;
            }

            try {
                request.put(field, HexUtil.decode(stringValue));
            } catch (InvalidHexException ex) {

                if (properties.isFailOnInvalidHex()) {
                    throw new InvalidHexException(
                            "Invalid Hex value for parameter: " + field);
                }
            }
        }
    }
}
