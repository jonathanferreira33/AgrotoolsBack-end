package br.com.questionarioweb.questionarioresponsivo.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.questionarioweb.questionarioresponsivo.model.entities.Questionario;

@Repository
public interface QuestionarioRepository
	extends JpaRepository<Questionario, Integer> {
	public List<Questionario> findByTituloContainingIgnoreCase(String titulo);
	
	
}
