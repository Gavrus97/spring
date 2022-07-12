package de.telran.planepassengers.entity.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TicketType {
    VIP(3, "A-VIP"),
    BUSINESS(1, "B-BUSINESS"),
    ECONOMY(2, "C-ECONOMY");

    private final Integer ticketTypeId;
    private final String externalTypeId;

    public static TicketType getByTypeId(Integer typeId) {
        if (typeId == null) {
            return null;
        }

        return
                Arrays.stream(TicketType.values())
                        .filter(x -> x.getTicketTypeId().equals(typeId))
                        .findFirst()
                        .orElse(null);
    }

    @JsonCreator
    //to convert json enum field from string
    public static TicketType findExternalTypeId(String typeId) {
        if (typeId == null) {
            return null;
        }
        return
                Arrays.stream(TicketType.values())
                        .filter(x -> x.getExternalTypeId().equals(typeId))
                        .findFirst()
                        .orElse(null);
    }
    }

