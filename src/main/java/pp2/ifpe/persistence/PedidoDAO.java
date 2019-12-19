package pp2.ifpe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pp2.ifpe.model.Pedido;

public interface PedidoDAO extends JpaRepository<Pedido, Integer>{

}
