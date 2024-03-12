package net.atos.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.atos.gestao_vagas.exceptions.UserFoundException;
import net.atos.gestao_vagas.modules.candidate.CandidateEntity;
import net.atos.gestao_vagas.modules.candidate.CandidateRepository;
import net.atos.gestao_vagas.modules.candidate.UseCases.CreateCandidateUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase candidateCabCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.candidateCabCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
