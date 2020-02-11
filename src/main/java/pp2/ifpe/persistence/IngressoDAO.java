package pp2.ifpe.persistence;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Ingresso;

public interface IngressoDAO extends JpaRepository<Ingresso, Integer>{
	@Query("SELECT i FROM Ingresso i WHERE i.nomeIngresso = :nomeIngresso")
	public Ingresso findByNomeIngresso(String nomeIngresso);

	@Query("SELECT i FROM Ingresso i WHERE i.tipoIngresso = :tipoIngresso")
	public Ingresso findByTipo(String tipoIngresso);
	
	@Query("select i from Ingresso i where i.id = :id")
	  public Optional<Ingresso> findByCodigo(Integer id);

	public boolean existsByNomeIngresso(String nomeIngresso);
}
