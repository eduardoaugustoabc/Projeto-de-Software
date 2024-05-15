package br.edu.ufcg.computacao.psoft.commerce.repositories;

import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}