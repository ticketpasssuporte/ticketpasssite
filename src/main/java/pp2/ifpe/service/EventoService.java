package pp2.ifpe.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;

@Service
public class EventoService {
	
	
	@Autowired
	private EventoDAO eventoDAO;
	
	public Evento findByIdEvento(Integer id) throws Exception {
		Optional<Evento> evento = this.eventoDAO.findById(id);
		if (evento.isPresent()) {
			return evento.get();
		}
		throw new Exception("Evento não encontrado!");
	}
	
	public Evento salvar(Evento evento) throws Exception {
		if (eventoDAO.existsByNomeEvento(evento.getNomeEvento()) != false) {
			throw new Exception("Já existe um Evento com este nome");
		} 
		return eventoDAO.saveAndFlush(evento);
	}


	public void salvarEvento(Evento evento)throws ServiceException, MessagingException{
		evento.setStatus(true);
		this.eventoDAO.save(evento);
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

	public List<Evento> listEventoCategoria(Integer id){
		return eventoDAO.buscaPorCategoria(id);
	}
	
	/*public void remover(Integer id) {
		this.eventoDAO.deleteById(id);
	}*/

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
