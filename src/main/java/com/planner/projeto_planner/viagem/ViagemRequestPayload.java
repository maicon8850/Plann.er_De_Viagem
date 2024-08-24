package com.planner.projeto_planner.viagem;

import java.util.List;

public record ViagemRequestPayload(String destination, String starts_at, String ends_at, List<String> emails_to_invite, String owner_name) { // aqui é um dado que eu vou apenas receber, não vou manipular, ou rodar nad aencima dele
}
