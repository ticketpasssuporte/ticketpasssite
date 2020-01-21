package pp2.ifpe.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;

@Service
public class EventoService {
	
	@Autowired
	private EventoDAO eventoDAO;
	
	

	/*public void salvarEvento(Evento evento)throws ServiceException, MessagingException{
		if (this.findEventoByNome(evento.getNomeEvento()) != null) {
			throw new ServiceException("Já existe um evento com este evento: " + evento.getNomeEvento());
		}
		evento.setStatus(true);
		this.eventoDAO.save(evento);
	}*/
	
	public void salvarEvento(Evento evento)throws ServiceException, MessagingException{
		evento.setStatus(true);
		this.eventoDAO.save(evento);
	}

	public String editarEvento(Integer id, Model model) {
	      model.addAttribute("lista", this.eventoDAO.findById(id));
			return "/criarEvento";
		}
	
	
	public Evento get(Categoria categoria) {
		return eventoDAO.findAllBycategoria(categoria);
		}
	
	
	public Evento findEventoByNome(String nome) {
		return EventoDAO.findBynomeIgnoreCase(nome);
	}
	
	public void editarEvento(Evento evento) {
		this.eventoDAO.save(evento);
	}


	public Evento findAll(Sort by) {
		
		return null;
	}


	public void save(Evento evento) {
		
		
	}

	public Evento findById(Integer id) {
		return eventoDAO.findById(id).orElse(null);
	}
	
	
//	public void deletarEvento(Evento evento) {
//		Evento eventochecado = eventoDAO.findById(evento.getId());
//		if(eventochecado == false){
//			evento.setStatus(false);
//			this.eventoDAO.save(evento);		
//		}
//	}

}
