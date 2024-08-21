package com.planner.projeto_planner.viagem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViagemRepository extends JpaRepository<Viagem, UUID> { // uso da herança
}
