package net.atos.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity (name= "company")
@Data 
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Pattern(regexp = "(\\S)+", message = "O username não pode conter espaços ou caracters inválidos !")
    private String username;
    @Email(message = "O campo deve conter um email válido !")
    private String email;
    @Length(min = 8, max = 20, message = "A senha deve conter entre 8 e 20 caracters !")
    private String password;
    private String website;
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
