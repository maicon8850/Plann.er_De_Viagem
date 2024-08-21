package com.planner.projeto_planner.viagem;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Viagem {
@Id //indica que é minha chave primaria da minha tabela
@GeneratedValue(strategy = GenerationType.AUTO) // gerado automaticamente


private UUID id;

@Column(nullable = false)
private String  destination;  //destino

     @Column(name = "starts-at", nullable = false) // nome da coluna = "começa_em", não pode ter valores nulos
     private LocalDateTime startsAt; // data e hora de início

     @Column(name = "ends_at", nullable = false) // nome da coluna = "termina_em", não pode ter valores nulos
     private LocalDateTime endsAt; // data e hora de término

     @Column(name = "in_confirmed", nullable = false) // nome da coluna = "está_confirmado", não pode ter valores nulos
     private Boolean inConfirmed; // está confirmado (true/false)

     @Column(name = "owner_name", nullable = false) // nome da coluna = "nome_do_proprietário", não pode ter valores nulos
     private String ownerName; // nome do proprietário

     @Column(name = "owner_email", nullable = false) // nome da coluna = "email_do_proprietário", não pode ter valores nulos
     private String ownerEmail; // e-mail do proprietário
}
