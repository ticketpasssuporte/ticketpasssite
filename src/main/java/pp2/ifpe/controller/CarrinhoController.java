package pp2.ifpe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pp2.ifpe.model.Ingresso;
import pp2.ifpe.model.ItensCompras;
import pp2.ifpe.model.Pedido;
import pp2.ifpe.model.Usuario;
import pp2.ifpe.persistence.IngressoDAO;
import pp2.ifpe.persistence.ItensComprasDAO;
import pp2.ifpe.persistence.PedidoDAO;

@RestController
public class CarrinhoController {

	private List<ItensCompras> itensCompras = new ArrayList<ItensCompras>();

	@Autowired
	private IngressoDAO ingressoDAO;
	
	@Autowired
	private ItensComprasDAO itensComprasDAO;
	@Autowired
	private PedidoDAO pedidoDAO;

	private Pedido pedido = new Pedido();

	private Usuario usuario;
	
	private void calcularTotal() {
		pedido.setValorTotal(0.);
		for (ItensCompras it : itensCompras) {
			pedido.setValorTotal(pedido.getValorTotal() + it.getValorTotal());
		}
	}

	// Chamar Carrinho
	@GetMapping("/carrinho")
	public ModelAndView ChamaCarrinho() {
		ModelAndView mv = new ModelAndView("carrinhoDeCompras");
		calcularTotal();
		mv.addObject("pedido", pedido);
		mv.addObject("listaItens", itensCompras);
		return mv;
	}

	// Adicionar carrinho
	@GetMapping("/adicionarCarrinho")
	public ModelAndView adicionarCarrinho(@RequestParam("id") Integer codigo, HttpSession session, Model model)
			throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		Optional<Ingresso> ing = this.ingressoDAO.findById(codigo);
		Ingresso ingresso = ing.get();

		int controle = 0;
		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(ingresso.getId())) {
				it.setQuantidade(it.getQuantidade() + 1);
				it.setValorTotal(0.);
				it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorIngresso()));
				controle = 1;
				break;
			}
		}
		if (controle == 0) {
			ItensCompras item = new ItensCompras();
			item.setIngresso(ingresso);
			item.setValorIngresso(ingresso.getValor());
			item.setQuantidade(item.getQuantidade() + 1);
			item.setValorTotal(item.getValorTotal() + (item.getQuantidade() * item.getValorIngresso()));
			itensCompras.add(item);
		}

		return mv;

	}

	@GetMapping("/alterarQuantidade")
	public ModelAndView alterarQuantidade(@RequestParam("id") Integer id, @RequestParam("acao") Integer acao,
			Model model) throws Exception {
		Optional<Ingresso> ingresso = this.ingressoDAO.findById(id);
		model.addAttribute("listaItens", itensCompras);
		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(id)) {
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade() + 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorIngresso()));
				} else if (acao == 0) {
					it.setQuantidade(it.getQuantidade() - 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorIngresso()));

				}
				break;
			}
		}
		return mv;

	}

	@GetMapping("/removerIngresso")
	public ModelAndView removeIngresso(@RequestParam("id") Integer id) {
		Optional<Ingresso> ingresso = this.ingressoDAO.findByCodigo(id);
		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(id)) {
				itensCompras.remove(it);
				break;
			}
		}

		return mv;
	}

	@GetMapping("/finalizar")
	public ModelAndView finalizarCompra() {
		ModelAndView mv = new ModelAndView("Finalizar");
		calcularTotal();
		mv.addObject("pedido", pedido);
		mv.addObject("listaItens", itensCompras);
		return mv;
	}

	@PostMapping("/confirmar")
	public ModelAndView confirmarConta(String formaPagamento) {
		ModelAndView mv = new ModelAndView("/finalizou");
		pedido.setUsuario(usuario);
		pedido.setFormaPagamento(formaPagamento);
		pedidoDAO.saveAndFlush(pedido);

		for (ItensCompras c : itensCompras) {
			c.setPedido(pedido);
			itensComprasDAO.saveAndFlush(c);
		}
		itensCompras = new ArrayList<>();
		pedido = new Pedido();

		return mv;
	}
}
