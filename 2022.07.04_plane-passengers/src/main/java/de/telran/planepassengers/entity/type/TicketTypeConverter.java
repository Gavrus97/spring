package de.telran.planepassengers.entity.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TicketTypeConverter implements AttributeConverter<TicketType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(TicketType ticketType) {
        return ticketType == null ? null : ticketType.getTicketTypeId();
    }

    @Override
    public TicketType convertToEntityAttribute(Integer integer) {
        return integer == null ? null : TicketType.getByTypeId(integer);
    }
}
