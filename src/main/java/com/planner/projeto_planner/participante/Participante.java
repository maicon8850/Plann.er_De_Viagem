package com.planner.projeto_planner.participante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "participantes")
@NoArgsConstructor
@AllArgsConstructor
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // ID do participante

    @Column(name = "name", nullable = false)
    private String name;  // Nome do participante

    @Column(name = "email", nullable = false)
    private String email;  // E-mail do participante

    @Column(name = "esta_cofirmado", nullable = false)
    private Boolean estaConfirmado = false;  // Se o participante confirmou sua participação

    @Column(name = "viagem_id")
    private UUID viagemId;  // Referência à viagem associada

    // Construtor que aceita nome, e-mail e ID da viagem
    public Participante(String name, String email, UUID viagemId) {
        this.name = name;
        this.email = email;
        this.viagemId = viagemId;
        this.estaConfirmado = false;  // Define como não confirmado inicialmente
    }
}
