package com.planner.projeto_planner.viagem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
// Spring Data JPA
public interface ViagemRepository extends JpaRepository<Viagem, UUID> { // então por exemplo, o repository ele ajuda eu buscar o que quiser da entidade que no caso Viagem
}
