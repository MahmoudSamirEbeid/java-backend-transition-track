package com.bm.rest_web_services.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorDetails(
        String message,
        LocalDateTime timestamp,
        String details,
        List<String> errorList
) {}