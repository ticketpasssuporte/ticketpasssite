package pp2.ifpe.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pp2.ifpe.model.Evento;
import pp2.ifpe.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService evenService;
	
	@GetMapping("/evento")
	public String cadastraEvento(Evento evento) {
		return"redirect:/criarEvento";
	}
	
	@PostMapping("/salvarEvento")
	public String salvarEvento(Evento evento,@RequestParam("fileProduto")MultipartFile file) {
		
		try {
			evento.setFoto_evento(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.evenService.salvarEvento(evento);
		return"redirect:/";
	}
	
//	@GetMapping("")
//	public String editarEvento(Integer id) {
//		this.evenService.editarEvento();
//		return"";
//	}
//	
//	@GetMapping("/removerEvento")
//	public String removerEventos(Integer id){
//		this.evenService.editarEvento();
//		return"/";
//	}
//	
}
