package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Email;

public interface EmailDAO extends JpaRepository<Email, Integer> {

	public Email findByToken(String token);
}
