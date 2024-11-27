package com.cib.back.api.mappers;

import com.cib.back.api.models.payload.PartnerPayload;
import com.cib.back.domain.models.partner.Direction;
import com.cib.back.domain.models.partner.Partner;
import com.cib.back.domain.models.partner.ProcessedFlowType;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartnerMapper {

    PartnerPayload toPayload(Partner partner);

    Partner toEntity(PartnerPayload payload);

    @Named("stringToEnumDirection")
    default Direction stringToEnumDirection(String value) {
        return value != null ? Direction.valueOf(value) : null;
    }

    @Named("stringToEnumProcessedFlowType")
    default ProcessedFlowType stringToEnumProcessedFlowType(String value) {
        return value != null ? ProcessedFlowType.valueOf(value) : null;
    }

    List<PartnerPayload> toPayload(List<Partner> partners);
}
