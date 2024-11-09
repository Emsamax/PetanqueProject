package com.example.demo.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private long timestamp;
    private int status;
    private String error;
    private String message;
}
