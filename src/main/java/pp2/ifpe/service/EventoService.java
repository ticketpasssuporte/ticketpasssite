package pp2.ifpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;

@Service
public class EventoService {
	
	@Autowired
	private EventoDAO eventoDAO;
	
	public void salvarEvento(Evento evento){
		evento.setStatus(true);
		this.eventoDAO.save(evento);
	}
	
	public void exibirEvento(Model model) {
		model.addAttribute("lista", this.eventoDAO.findAll());
	}
	
	public void editarEvento(Evento evento) {
		this.eventoDAO.save(evento);
	}
	
//	public void deletarEvento(Evento evento) {
//		Evento eventochecado = eventoDAO.findById(evento.getId());
//		if(eventochecado == false){
//			evento.setStatus(false);
//			this.eventoDAO.save(evento);		
//		}
//	}
}
