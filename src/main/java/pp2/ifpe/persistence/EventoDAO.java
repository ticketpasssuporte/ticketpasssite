package pp2.ifpe.persistence;

import java.util.List;
import java.util.Optional;

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
	public boolean existsByNomeEvento(String nomeEvento);

	
	Evento findAllBycategoria(Categoria categoria);
	
   
	@Query("select e from Evento e where e.nomeEvento like %?1%")
	List<Evento>findEventoByNome(String nomeEvento);
	
	@Query(value = "SELECT * FROM evento u WHERE u.usuario_id = ?1", nativeQuery = true) 		 
	List<Evento> findAllByUsuario(Integer id);
	

   @Query("select e from Evento e where e.id = ?1")
   Evento findByCodigo(Integer id);

   @Query(value = "SELECT * FROM evento WHERE categoria_id = ?1", nativeQuery = true) 
   List<Evento> buscaPorCategoria(Integer id);


   
   
//
//	Evento findByStatus();
//
//	

}
