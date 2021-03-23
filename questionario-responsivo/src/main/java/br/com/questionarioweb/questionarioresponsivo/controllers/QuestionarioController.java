package br.com.questionarioweb.questionarioresponsivo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.questionarioweb.questionarioresponsivo.model.entities.Questionario;
import br.com.questionarioweb.questionarioresponsivo.model.repositories.QuestionarioRepository;

@RestController
@RequestMapping("/questionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionarioController {
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	

	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Questionario> post (@RequestBody Questionario questionario){
		return ResponseEntity.status(HttpStatus.CREATED).body(questionarioRepository.save(questionario));		
	}
	
	@GetMapping
	public ResponseEntity<List<Questionario>> obterQuestionarios() {
		return ResponseEntity.ok(questionarioRepository.findAll());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Questionario> obterQuestionarioPorID(@PathVariable int id) {
		return questionarioRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Questionario>> obterQuestionariosPorTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(questionarioRepository.findByTituloContainingIgnoreCase(titulo));
	}
		
		
	@GetMapping(path = "/pagina/{nPag}")
	public Iterable<Questionario> obterQuestionariosPagina(@PathVariable int nPag) {
		Pageable page = PageRequest.of(nPag, 10);
		return questionarioRepository.findAll(page);
	}
	
		
	@DeleteMapping(path="/{id}")
	public void excluirQuestionario(@PathVariable int id) {
		questionarioRepository.deleteById(id);
	}


}
