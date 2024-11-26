package com.cib.back.api.services;

import com.cib.back.api.mappers.MQMessageMapper;
import com.cib.back.api.models.dto.MessageDTO;
import com.cib.back.domain.models.MQMessage;
import com.cib.back.domain.repositories.MQMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MessageServiceTest {
    private MessageService messageService;
    private MQMessageRepository mqMessageRepository;
    private MQMessageMapper mqMessageMapper;

    @BeforeEach
    public void setUp() {
        this.mqMessageMapper = mock(MQMessageMapper.class);
        this.mqMessageRepository = mock(MQMessageRepository.class);
        this.messageService = new MessageService(mqMessageMapper, mqMessageRepository);
    }

    @Test
    public void givenMessageService_WhenGetAllMessage_ShouldReturnRightDtoMessage() {
        // Given
        String anyContent = "anyContent";
        MQMessage anyMQMessage = MQMessage.builder().content(anyContent).build();
        MessageDTO anyMessageDTO = new MessageDTO(anyContent, null);


        when(mqMessageRepository.findAll()).thenReturn(List.of(anyMQMessage));
        when(mqMessageMapper.toDTOList(List.of(anyMQMessage))).thenReturn(List.of(anyMessageDTO));

        // When
        List<MessageDTO> receive = this.messageService.getAllMessage();

        // Then
        assertEquals(List.of(anyMessageDTO), receive);
    }
}