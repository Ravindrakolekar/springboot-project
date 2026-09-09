package com.project.springboot.exception;

import java.time.OffsetDateTime;

public record ErrorResponseRecord(OffsetDateTime timestamp,
                                  int status,
                                  String error,
                                  String message) {
}
