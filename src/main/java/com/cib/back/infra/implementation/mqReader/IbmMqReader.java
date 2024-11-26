package com.cib.back.infra.implementation.mqReader;

import com.cib.back.domain.models.MQMessage;
import com.cib.back.domain.repositories.MQReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.cib.back.infra.configuration.MQConfiguration.QUEUE;

@Service
@EnableJms
public class IbmMqReader implements MQReader {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final JmsTemplate jmsTemplate;

    @Autowired
    public IbmMqReader(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Optional<MQMessage> readMessage() {

        try{
            String messageContent = Objects.requireNonNull(jmsTemplate.receiveAndConvert(QUEUE)).toString();
            MQMessage mqMessage = MQMessage.builder()
                                            .content(messageContent)
                                            .timestamp(String.valueOf(System.currentTimeMillis()))
                                            .build();

            return Optional.of(mqMessage);
        }catch(JmsException | NullPointerException ex) {
            logger.log(Level.INFO, "Failed to read message in ibmMq due to : " + ex.getMessage());
            return Optional.empty();
        }
    }
}
