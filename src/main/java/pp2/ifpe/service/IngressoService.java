package pp2.ifpe.service;


import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Ingresso;
import pp2.ifpe.persistence.IngressoDAO;

@Service
public class IngressoService {

	@Autowired
	private IngressoDAO ingressoDAO;
	
	public Ingresso findByIdIngresso(Integer id) throws Exception {
		Optional<Ingresso> ingresso = this.ingressoDAO.findById(id);
		if (ingresso.isPresent()) {
			return ingresso.get();
		}
	
	throw new Exception("Ingresso não encontrado!");
	}
	
	public Ingresso salvarIngresso(Ingresso ingresso)throws Exception{
		if(ingressoDAO.existsByNomeIngresso(ingresso.getNomeIngresso()) != false || ingressoDAO.findByNomeIngresso(ingresso.getNomeIngresso()) == null)  {
			throw new Exception(" ou já foi cadastrado");
		}else {
		 return ingressoDAO.saveAndFlush(ingresso);
		}
	}
	
	public void editarIngresso(Ingresso ingresso) {
		this.ingressoDAO.save(ingresso);
	}

	public Ingresso findById(Integer id) {
		return ingressoDAO.findById(id).orElse(null);
	}
      
}
