package com.cib.back.api.services;

import com.cib.back.api.mappers.MQMessageMapper;
import com.cib.back.api.models.dto.MessageDTO;
import com.cib.back.domain.models.MQMessage;
import com.cib.back.domain.repositories.MQMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MQMessageRepository mqMessageRepository;
    private final MQMessageMapper mqMessageMapper;

    @Autowired
    public MessageService(MQMessageMapper mqMessageMapper, MQMessageRepository mqMessageRepository) {
        this.mqMessageMapper = mqMessageMapper;
        this.mqMessageRepository = mqMessageRepository;
    }

    public List<MessageDTO> getAllMessage() {
        List<MQMessage> mqMessages = mqMessageRepository.findAll();

        return mqMessageMapper.toDTOList(mqMessages);
    }
}
