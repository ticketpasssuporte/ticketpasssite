package pp2.ifpe.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pp2.ifpe.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {


	//buscando  email e senha
	
	    public Usuario findByEmailIgnoreCase(String email);

		@Query("SELECT u FROM Usuario u WHERE u.nome LIKE %:nome% OR u.email LIKE %:email%")
		public Usuario findByNomeEmailAprox(String nome, String email);

		@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
		public Usuario efetuarLogin(String email, String senha);

		@Query("FROM Usuario u WHERE u.id = :id")
		public Usuario findByID(Integer id);

		public Usuario findByNomeIgnoreCase(String nome);
		
		@Query("SELECT u FROM Usuario u WHERE u.email = :email")
		public Usuario recuperarSenha(String email);
		
		@Query(value = "SELECT * FROM usuario u WHERE id = ?1", nativeQuery = true) 		 
		List<Usuario> findAllByUsuario(Integer id);
		
		@Query("select u from Usuario u where u.email = :email")
		Usuario findByEmail(String email);
		
		
}
		

