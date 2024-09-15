package com.planner.projeto_planner.viagem;

import com.planner.projeto_planner.participante.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tri ps") // Define a URL base para o controlador
public class ViagemController {

    @Autowired // Notação para o Spring fazer a injeção de dependência
    private ParticipanteService participanteService;

    @Autowired
    private ViagemRepository repository; // Repositório de viagens para interagir com o banco de dados

    @PostMapping // Define o método para lidar com requisições POST na URL "/trips"
    public ResponseEntity<ViagemCreatResponse> createViagem(@RequestBody ViagemRequestPayload payload) {

        Viagem newViagem = new Viagem(payload); // Construtor da classe Viagem que aceita ViagemRequestPayload

        this.repository.save(newViagem); // Salva a nova viagem no banco de dados
        this.participanteService.registrarParticipantesNoEvent(payload.emails_to_invite(), newViagem.getId());
        // Registra participantes no evento passando uma lista de e-mails e o ID da nova viagem

        return ResponseEntity.ok(new ViagemCreatResponse(newViagem.getId()));
        // Retorna o ID da viagem recém-criada encapsulado em ViagemCreatResponse

    }

    @GetMapping("/{id}") // Define o método para lidar com requisições GET na URL "/trips/{id}"
    public ResponseEntity<Viagem> getViagemDetalhes(@PathVariable UUID id) {
        // Busca a viagem no banco de dados pelo ID
        Optional<Viagem> viagem = this.repository.findById(id);

        return viagem.map(ResponseEntity::ok) // Se a viagem for encontrada, retorna com status 200 (OK)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não for encontrada, retorna 404 (Not Found)
    }

    @PutMapping("/{id}") // Define o método para lidar com requisições PUT na URL "/trips/{id}"
    public ResponseEntity<Viagem> updateViagem(@PathVariable UUID id, @RequestBody ViagemRequestPayload payload) {
        // Busca a viagem no banco de dados pelo ID
        Optional<Viagem> viagem = this.repository.findById(id);

        if (viagem.isPresent()) {
            Viagem cruaViagem = viagem.get(); // Obtém o objeto Viagem do Optional

            // Corrige o método de parse de LocalDateTime e separa o parâmetro com vírgula
            cruaViagem.setEndsAt(LocalDateTime.parse(payload.ends_at(), DateTimeFormatter.ISO_DATE_TIME));
            cruaViagem.setStartsAt(LocalDateTime.parse(payload.starts_at(), DateTimeFormatter.ISO_DATE_TIME));
            cruaViagem.setDestination(payload.destination());

            this.repository.save(cruaViagem); // Salva as alterações no banco de dados

            return ResponseEntity.ok(cruaViagem); // Retorna o objeto atualizado com status 200 (OK)
        }

        return ResponseEntity.notFound().build(); // Se não for encontrada, retorna 404 (Not Found)
    }
}
