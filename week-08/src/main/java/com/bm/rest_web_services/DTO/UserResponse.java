package com.bm.rest_web_services.DTO;

import com.bm.rest_web_services.Entity.User;

public record UserResponse(
        String message,
        User user
) {}
