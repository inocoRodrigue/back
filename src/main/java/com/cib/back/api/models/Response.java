package com.cib.back.api.models;

import java.sql.Timestamp;
import java.time.Instant;

public record Response(
        Object body,
        String message
) {

    public static Response from(Object body) {
        return new Response(body, null);
    }

    public static Response from(Object body, String message) {
        return new Response(body, message);
    }
}
