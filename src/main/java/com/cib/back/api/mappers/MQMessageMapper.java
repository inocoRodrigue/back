package com.cib.back.api.mappers;

import com.cib.back.api.models.dto.MessageDTO;
import com.cib.back.domain.models.MQMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MQMessageMapper {
    MessageDTO toDTO(MQMessage mqMessage);

    List<MessageDTO> toDTOList(List<MQMessage> mqMessages);
}
