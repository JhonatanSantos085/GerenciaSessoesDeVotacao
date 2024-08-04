package Jhon.santos.votacao.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "Usuario_Criador_id")
    private Usuario usuarioCriador;

    @OneToOne(mappedBy = "pauta", cascade = CascadeType.ALL)
    private SessaoVotacao sessaoVotacao;

    public void setDataDeCriacao(){
        this.dataDeCriacao = LocalDateTime.now();
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }
}
