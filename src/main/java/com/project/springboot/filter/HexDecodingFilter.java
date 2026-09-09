package com.project.springboot.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.service.HexDecodingService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
public class HexDecodingFilter extends OncePerRequestFilter {


    private final ObjectMapper objectMapper;
    private final HexDecodingService hexDecodingService;

    public HexDecodingFilter(
            ObjectMapper objectMapper,
            HexDecodingService hexDecodingService) {

        this.objectMapper = objectMapper;
        this.hexDecodingService = hexDecodingService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (shouldDecode(request)) {

            CachedBodyHttpServletRequest wrappedRequest =
                    new CachedBodyHttpServletRequest(request);

            byte[] body = wrappedRequest.getCachedBody();

            if (body.length > 0) {

                Map<String, Object> requestBody =
                        objectMapper.readValue(body, Map.class);

                hexDecodingService.decode(requestBody);

                byte[] decodedBody =
                        objectMapper.writeValueAsBytes(requestBody);

                wrappedRequest.setCachedBody(decodedBody);
            }

            filterChain.doFilter(wrappedRequest, response);

        } else {

            filterChain.doFilter(request, response);
        }
    }

    private boolean shouldDecode(HttpServletRequest request) {

        String contentType = request.getContentType();

        return contentType != null
                && contentType.contains("application/json")
                && ("POST".equalsIgnoreCase(request.getMethod())
                || "PUT".equalsIgnoreCase(request.getMethod())
                || "PATCH".equalsIgnoreCase(request.getMethod()));
    }

    }

