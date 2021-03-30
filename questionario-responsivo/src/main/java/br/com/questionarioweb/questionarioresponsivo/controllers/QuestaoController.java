package br.com.questionarioweb.questionarioresponsivo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.questionarioweb.questionarioresponsivo.model.entities.Questao;
import br.com.questionarioweb.questionarioresponsivo.model.repositories.QuestaoRepository;

@RequestMapping("/questionarios/pergunta")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestaoController {
	
	@Autowired
	private QuestaoRepository questaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Questao>> obterTodas(){
		return ResponseEntity.ok(questaoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Questao> obterQuestaoPorId(@PathVariable int id){
		return questaoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{questao}")
	public ResponseEntity<List<Questao>> obterPorTitulo(@PathVariable String questao){
		return ResponseEntity.ok(questaoRepository.findAllByQuestaoContainingIgnoreCase(questao));
	}
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Questao> post (@RequestBody Questao questao){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(questaoRepository.save(questao));
	}
	
	@PutMapping("/pergunta")
	public ResponseEntity<Questao> put (@RequestBody Questao questao){
		return ResponseEntity.status(HttpStatus.OK)
				.body(questaoRepository.save(questao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		questaoRepository.deleteById(id);
	}
	
}
