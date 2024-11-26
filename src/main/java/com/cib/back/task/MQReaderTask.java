package com.cib.back.task;


import com.cib.back.domain.models.MQMessage;
import com.cib.back.domain.repositories.MQMessageRepository;
import com.cib.back.domain.repositories.MQReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MQReaderTask {
    private final MQReader mqReader;
    private final MQMessageRepository mqMessageRepository;

    @Autowired
    public MQReaderTask(MQReader mqReader, MQMessageRepository mqMessageRepository) {
        this.mqReader = mqReader;
        this.mqMessageRepository = mqMessageRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void readMessages() {
        Optional<MQMessage> optionalMQMessage = mqReader.readMessage();

        optionalMQMessage.ifPresent(mqMessageRepository::save);
    }
}
