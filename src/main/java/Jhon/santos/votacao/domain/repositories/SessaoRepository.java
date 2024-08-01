package Jhon.santos.votacao.domain.repositories;

import Jhon.santos.votacao.domain.model.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoVotacao, Long> {
}
