package com.project.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "billing.hex-decoding")
public class HexDecodingProperties {

    private boolean enabled = true;

    private boolean failOnInvalidHex = true;

    private List<String> fields = new ArrayList<>();

}
