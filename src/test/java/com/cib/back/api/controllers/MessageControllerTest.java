package com.cib.back.api.controllers;

import com.cib.back.api.models.dto.MessageDTO;
import com.cib.back.api.services.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

class MessageControllerTest {
    private MessageService messageService;
    private MessageController messageController;

    @BeforeEach
    void setUp() {
        messageService = mock(MessageService.class);
        messageController = new MessageController(messageService);
    }

    @Test
    void givenMessageController_WhenGetAllMessage_ShouldReturnOkStatusCode() {
        // Given
        MessageDTO anyMessageDto = new MessageDTO("anyMessage", null);
        List<MessageDTO> anyMessageDtoList = List.of(anyMessageDto);
        when(messageService.getAllMessage()).thenReturn(anyMessageDtoList);

        // When
        ResponseEntity<List<MessageDTO>> responseEntity = messageController.getAllMessage();

        // Then
        assertEquals(OK, responseEntity.getStatusCode());
    }

    @Test
    void GivenMessageController_WhenGetAllMessage_ShouldReturnOkRightResponse() {
        MessageDTO anyMessageDto = new MessageDTO("anyMessage", null);
        List<MessageDTO> anyMessageDtoList = List.of(anyMessageDto);
        when(messageService.getAllMessage()).thenReturn(anyMessageDtoList);

        // When
        ResponseEntity<List<MessageDTO>> responseEntity = messageController.getAllMessage();

        // Then
        List<MessageDTO> responseBody = responseEntity.getBody();
        assertEquals(anyMessageDtoList, responseBody);

        verify(messageService).getAllMessage();
    }
}