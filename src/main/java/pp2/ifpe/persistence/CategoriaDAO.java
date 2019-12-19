package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}
