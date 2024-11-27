package com.cib.back.api.models.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PartnerPayload(
        Long id,

        @NotNull(message = "Alias is required")
        @NotEmpty(message = "Alias cannot be empty")
        String alias,

        @NotNull(message = "Type is required")
        @NotEmpty(message = "Type cannot be empty")
        String type,

        @NotNull(message = "Direction is required")
        @Pattern(
                regexp = "INBOUND|OUTBOUND",
                message = "Direction must be either INBOUND or OUTBOUND"
        )
        String direction,

        String application,

        @NotNull(message = "Processed Flow Type is required")
        @Pattern(
                regexp = "MESSAGE|ALERTING|NOTIFICATION",
                message = "Processed Flow Type must be one of MESSAGE, ALERTING, or NOTIFICATION"
        )
        String processedFlowType,

        @NotNull(message = "Description is required")
        @NotEmpty(message = "Description cannot be empty")
        String description
) {}