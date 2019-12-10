package pp2.ifpe.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {


	//buscando  email e senha
		@Query(value =  "select * from usuario where email = ?1 AND senha = ?2", nativeQuery = true)
		Usuario buscalogin(String email, String senha);
		
		Optional<Usuario> findByEmail(String email);
		Optional<Usuario> findByNome(String nome);
}
