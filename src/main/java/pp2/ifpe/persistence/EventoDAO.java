package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;

public interface EventoDAO extends JpaRepository<Evento, Integer> {

	static Evento findBynomeIgnoreCase(String nome) {
		// TODO Auto-generated method stub
		return null;
	}



	Evento findAllBycategoria(Categoria categoria);

	

	
//
//	Evento findByNome(String nome);
//
//	Evento findByStatus();
//
//	

}
