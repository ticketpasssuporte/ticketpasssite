package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{

}
