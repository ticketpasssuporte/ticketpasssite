package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Evento;

public interface EventoDAO extends JpaRepository<Evento, Integer> {

//	Evento findById();
//
//	Evento findByNome(String nome);
//
//	Evento findByStatus();
//
//	
}
