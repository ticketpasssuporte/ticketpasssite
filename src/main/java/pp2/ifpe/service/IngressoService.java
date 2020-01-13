package pp2.ifpe.service;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Ingresso;
import pp2.ifpe.persistence.IngressoDAO;

@Service
public class IngressoService {

	@Autowired
	private IngressoDAO ingressoDAO;
	
	public void salvarIngresso(Ingresso ingresso)throws ServiceException, MessagingException{
		this.ingressoDAO.save(ingresso);
	}
	
	public String editarIngresso(Integer id, Model model) {
	      model.addAttribute("listaIng", this.ingressoDAO.findById(id));
			return "/configurarIngresso";
		}
	
}
