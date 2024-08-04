package Jhon.santos.votacao.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "Sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario usuario;

    private String voto;
    private LocalDateTime dataHoraDoVoto;

    public void setDataHoraDoVoto(){
        this.dataHoraDoVoto = LocalDateTime.now();
    }
}
