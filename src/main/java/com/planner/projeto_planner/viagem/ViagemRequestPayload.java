package com.planner.projeto_planner.viagem;

import java.util.List;

public record ViagemRequestPayload(
        String destination,
        String starts_at,
        String ends_at,
        List<String> emails_to_invite,
        String owner_name,
        String owner_email // Adicionado para e-mail
) {}
