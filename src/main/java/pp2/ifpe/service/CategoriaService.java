package pp2.ifpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pp2.ifpe.model.Categoria;
import pp2.ifpe.persistence.CategoriaDAO;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	
	public void categoriaSalva(Categoria categoria) {
		this.categoriaDAO.save(categoria);
	}
	
	public List<Categoria> listaCategoria(){
		return categoriaDAO.findAll();
	}
	
}
