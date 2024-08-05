package Jhon.santos.votacao.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    private LocalDateTime dataInicio;
    private Integer duracao;
    private String status;

    @ManyToOne
    @JoinColumn(name ="usuario_criador-id")
    private Usuario usuarioCriador;


    public void setDataInicio(){
        this.dataInicio = LocalDateTime.now();
    }


    public void setStatus(String status) {
        this.status =status;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }
}
