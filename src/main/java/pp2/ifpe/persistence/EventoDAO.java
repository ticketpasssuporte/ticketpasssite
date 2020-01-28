package pp2.ifpe.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;

@Repository
@Transactional
public interface EventoDAO extends JpaRepository<Evento, Integer> {

	static Evento findBynomeIgnoreCase(String nome) {
		// TODO Auto-generated method stub
		return null;
	}



	Evento findAllBycategoria(Categoria categoria);

	@Query("select e from Evento e where e.nomeEvento like %?1%")
	List<Evento>findEventoByNome(String nomeEvento);
	

	
//
   @Query("select e from Evento e where e.id = ?1")
   Evento findByCodigo(Integer id);
//
//	Evento findByStatus();
//
//	

}
