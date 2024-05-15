package br.edu.ufcg.computacao.psoft.commerce.repositories;

import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
}