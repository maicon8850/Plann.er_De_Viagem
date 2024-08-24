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
@NoArgsConstructor
@AllArgsConstructor// é interessante quando minha classe precisa de um construtor sem argumentos
public class Viagem {
@Id //indica que é minha chave primaria da minha tabela
@GeneratedValue(strategy = GenerationType.AUTO) // gerado automaticamente


private UUID id;

@Column(nullable = false)
private String destination;  //destino

     @Column(name = "starts-at", nullable = false) // nome da coluna = "começa_em", não pode ter valores nulos
     private LocalDateTime startsAt; // data e hora de início

     @Column(name = "ends_at", nullable = false) // nome da coluna = "termina_em", não pode ter valores nulos
     private LocalDateTime endsAt; // data e hora de término

     @Column(name = "in_confirmed", nullable = false) // nome da coluna = "está_confirmado", não pode ter valores nulos
     private Boolean isConfirmed; // está confirmado (true/false)

     @Column(name = "owner_name", nullable = false) // nome da coluna = "nome_do_proprietário", não pode ter valores nulos
     private String ownerName; // nome do proprietário

     @Column(name = "owner_email", nullable = false) // nome da coluna = "email_do_proprietário", não pode ter valores nulos
     private String ownerEmail; // e-mail do proprietário
     public  Viagem(ViagemRequestPayload data){
          this.destination = data.destination();
          this.isConfirmed = false;
          this.ownerEmail = data.owner_name();
          this.ownerName = data.owner_name();
          this.startsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME); // forma como eu vou receber do front |  Este formatador é utilizado para ler ou gerar strings no formato "aaaa-MM-dd'T'HH:mm
          this.endsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME); // forma como eu vou receber do front |  Este formatador é utilizado para ler ou gerar strings no formato "aaaa-MM-dd'T'HH:mm

     }
}
