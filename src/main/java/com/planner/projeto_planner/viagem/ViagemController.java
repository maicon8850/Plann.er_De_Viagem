package com.planner.projeto_planner.viagem;

import com.planner.projeto_planner.participante.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips") // Define a URL base para o controlador
public class ViagemController {

    @Autowired // notação para o spring fazer a ingeção de dependencia para mim
    private ParticipanteService participanteService;

    @Autowired
    private ViagemRepository viagemRepository;


    @PostMapping // Define o método para lidar com requisições POST na URL "/trips"
    public ResponseEntity<ViagemCreatResponse> createViagem(@RequestBody ViagemRequestPayload payload) {

        Viagem newViagem = new Viagem(payload);  // aqui de inicio vai da um erro pois não tem um construtor no meu objeto viagem

        this.viagemRepository.save(newViagem); // AQUI VAI DEFENIR QUAL É A VIAGEM QUE EU QUERO SALVAR NO BANCO DE DADOS
        this.participanteService.registrarParticipantesNoEvent(payload.emails_to_invite(), newViagem.getId());

        return  ResponseEntity.ok(new ViagemCreatResponse(newViagem.getId()));
    }

}
