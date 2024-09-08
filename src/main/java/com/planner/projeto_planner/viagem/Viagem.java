package com.planner.projeto_planner.viagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "viagens")
@NoArgsConstructor
@AllArgsConstructor
public class Viagem {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID id;

     @Column(nullable = false)
     private String destination;  // destino

     @Column(name = "starts_at", nullable = false)
     private LocalDateTime startsAt; // data e hora de início

     @Column(name = "ends_at", nullable = false)
     private LocalDateTime endsAt; // data e hora de término

     @Column(name = "is_confirmed", nullable = false)
     private Boolean isConfirmed; // está confirmado (true/false)

     @Column(name = "owner_name", nullable = false)
     private String ownerName; // nome do proprietário

     @Column(name = "owner_email", nullable = false)
     private String ownerEmail; // e-mail do proprietário

     public Viagem(ViagemRequestPayload data) {
          this.destination = data.destination();
          this.isConfirmed = false; // assume que a viagem não está confirmada inicialmente
          this.ownerEmail = data.owner_email();
          this.ownerName = data.owner_name();
          this.startsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
          this.endsAt = LocalDateTime.parse(data.ends_at(), DateTimeFormatter.ISO_DATE_TIME); // corrigido para usar ends_at
     }
}
