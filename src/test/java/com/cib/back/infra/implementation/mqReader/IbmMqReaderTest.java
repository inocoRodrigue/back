package com.cib.back.infra.implementation.mqReader;

import com.cib.back.domain.models.MQMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;

import java.util.Optional;

import static com.cib.back.infra.configuration.MQConfiguration.QUEUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class IbmMqReaderTest {
    private JmsTemplate jmsTemplate;
    private IbmMqReader ibmMqReader;

    @BeforeEach
    public void setUp() {
        this.jmsTemplate = mock(JmsTemplate.class);
        this.ibmMqReader = new IbmMqReader(jmsTemplate);
    }

    @Test
    void givenIbmMqReader_WhenReadMessage_ShouldReturnMessageInOptional() {
        // Given
        String anyContent = "anyContent";
        when(jmsTemplate.receiveAndConvert(QUEUE)).thenReturn(anyContent);

        // When
        Optional<MQMessage> receiveOptional = this.ibmMqReader.readMessage();

        // Then
        MQMessage expectedMessage = MQMessage.builder().content(anyContent).build();
        assertTrue(receiveOptional.isPresent());
        assertEquals(expectedMessage.getContent(), receiveOptional.get().getContent());

        verify(jmsTemplate).receiveAndConvert(QUEUE);
    }

    @Test
    void givenIbmMqReader_WhenReadMessageWithException_ShouldReturnEmptyOptional() {
        // Given
        when(jmsTemplate.receiveAndConvert(QUEUE)).thenThrow(new JmsException("") {});

        // When
        Optional<MQMessage> receiveOptional = this.ibmMqReader.readMessage();

        // Then
        assertTrue(receiveOptional.isEmpty());

        verify(jmsTemplate).receiveAndConvert(QUEUE);
    }
}