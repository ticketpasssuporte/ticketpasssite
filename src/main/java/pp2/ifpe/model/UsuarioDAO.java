package pp2.ifpe.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	boolean exists(Usuario usuario);

}
