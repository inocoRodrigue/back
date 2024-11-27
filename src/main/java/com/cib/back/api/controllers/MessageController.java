package com.cib.back.api.controllers;

import com.cib.back.api.models.dto.MessageDTO;
import com.cib.back.api.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/messages")
@Tag(name = "Message Management", description = "APIs for managing message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("")
    @Operation(summary = "Get messages", description = "Retrieve all available message in database")
    public ResponseEntity<List<MessageDTO>> getAllMessage() {
        List<MessageDTO> messageDTOS = messageService.getAllMessage();

        return ResponseEntity.ok().body(messageDTOS);
    }
}
