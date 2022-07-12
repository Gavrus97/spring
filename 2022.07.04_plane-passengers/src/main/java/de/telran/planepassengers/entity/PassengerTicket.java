package de.telran.planepassengers.entity;

import de.telran.planepassengers.entity.type.TicketType;
import de.telran.planepassengers.entity.type.TicketTypeConverter;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "passenger_ticket")
@EntityListeners(AuditingEntityListener.class)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PassengerTicket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "ticket_type")
    @Convert(converter = TicketTypeConverter.class)
    private TicketType ticketType;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
}
