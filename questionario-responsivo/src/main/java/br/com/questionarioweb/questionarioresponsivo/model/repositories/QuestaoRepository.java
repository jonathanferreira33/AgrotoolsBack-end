package br.com.questionarioweb.questionarioresponsivo.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.questionarioweb.questionarioresponsivo.model.entities.Questao;

public interface QuestaoRepository extends
	JpaRepository<Questao, Integer>{
	public List<Questao> findAllByQuestaoContainingIgnoreCase(String questao); 
}
