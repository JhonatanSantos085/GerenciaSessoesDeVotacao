package Jhon.santos.votacao.domain.repositories;


import Jhon.santos.votacao.domain.model.SessaoVotacao;
import Jhon.santos.votacao.domain.model.Usuario;
import Jhon.santos.votacao.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsBySessaoVotacaoAndUsuario(SessaoVotacao sessaoVotacao, Usuario usuario);

    long countBySessaoVotacaoAndVoto(SessaoVotacao sessaoVotacao, String voto);
}
