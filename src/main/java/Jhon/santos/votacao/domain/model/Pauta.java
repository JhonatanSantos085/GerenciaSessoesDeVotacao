package Jhon.santos.votacao.domain.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataDeCriacao;
    private String status; //aberta, fechada, em votacao


    public void setDataDeCriacao(){
        this.dataDeCriacao = LocalDateTime.now();
    }

}
