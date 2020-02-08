package pp2.ifpe.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pp2.ifpe.model.Ingresso;

public interface IngressoDAO extends JpaRepository<Ingresso, Integer>{

	@Query("SELECT i FROM Ingresso i WHERE i.tipoIngresso = :tipoIngresso")
	public Ingresso findByTipo(String tipoIngresso);

	
}
