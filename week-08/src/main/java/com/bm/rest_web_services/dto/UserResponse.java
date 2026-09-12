package com.bm.rest_web_services.dto;

import com.bm.rest_web_services.entity.User;

public record UserResponse(
        String message,
        User user
) {}
