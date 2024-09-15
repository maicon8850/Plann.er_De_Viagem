package com.planner.projeto_planner.participante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, UUID> {

    // Método para encontrar participantes por viagem (se precisar consultar participantes de uma viagem específica)
    List<Participante> findByViagemId(UUID viagemId);

    // Outros métodos personalizados podem ser adicionados aqui
}
