package pp2.ifpe.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Ingresso;

public interface IngressoDAO extends JpaRepository<Ingresso, Integer>{

	
}
