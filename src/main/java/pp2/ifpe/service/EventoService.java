package pp2.ifpe.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Ingresso;
import pp2.ifpe.persistence.EventoDAO;

@Service
public class EventoService {
	
	@Autowired
	private EventoDAO eventoDAO;
	

	public void salvarEvento(Evento evento)throws ServiceException, MessagingException{
		if (this.findEventoByNome(evento.getNome()) != null) {
			throw new ServiceException("Já existe um eventi com este e-mail: " + evento.getNome());
		}
		evento.setStatus(true);
		this.eventoDAO.save(evento);
	}
	
	public void salvarIngresso(Ingresso ingresso) {
		this.eventoDAO.save(ingresso);
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
	
//	public void deletarEvento(Evento evento) {
//		Evento eventochecado = eventoDAO.findById(evento.getId());
//		if(eventochecado == false){
//			evento.setStatus(false);
//			this.eventoDAO.save(evento);		
//		}
//	}

}
