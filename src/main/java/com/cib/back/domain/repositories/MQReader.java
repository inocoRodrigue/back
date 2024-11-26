package com.cib.back.domain.repositories;

import com.cib.back.domain.models.MQMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MQReader {
    Optional<MQMessage> readMessage();
}
