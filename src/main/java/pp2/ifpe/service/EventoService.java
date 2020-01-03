package pp2.ifpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;

public class EventoService {
	
	@Autowired
	private EventoDAO eventoDAO;
	
	public String salvarEvento(Evento evento){
		
		this.eventoDAO.save(evento);
		return"";
	}
	
	public String exibirEvento(Model model) {
		model.addAttribute("lista", this.eventoDAO.findAll());
		return"";
	}
	
	public String editarEvento(Evento evento) {
		this.eventoDAO.save(evento);
		return"";
	}
	
	public String deletarEvento(Evento evento) {
		
		this.eventoDAO.save(evento);
		return"";
	}
}
