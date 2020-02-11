package pp2.ifpe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pp2.ifpe.model.Ingresso;
import pp2.ifpe.model.ItensCompras;
import pp2.ifpe.persistence.IngressoDAO;
import pp2.ifpe.service.IngressoService;

@RestController
public class CarrinhoController {

	private List<ItensCompras> itensCompras = new ArrayList<ItensCompras>();

	@Autowired
	private IngressoDAO ingressoDAO;

	@Autowired
	private IngressoService ingressoService;
	// Chamar Carrinho

	@GetMapping("/carrinho")
	public ModelAndView ChamaCarrinho() {
		ModelAndView mv = new ModelAndView("carrinhoDeCompras");
		mv.addObject("listaItens", itensCompras);
		return mv;
	}

	// Adicionar carrinho
	@GetMapping("/adicionarCarrinho")
	public ModelAndView adicionarCarrinho(@RequestParam("id") Integer codigo, HttpSession session, Model model)
			throws Exception {
		ModelAndView mv = new ModelAndView("carrinhoDeCompras");

		Optional<Ingresso> ing = ingressoDAO.findById(codigo);
		Ingresso ingresso = ing.get();

		int controle = 0;
		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(ingresso.getId())) {
				it.setQuantidade(it.getQuantidade() + 1);
				controle = 1;
				break;
			}
		}
		if (controle == 0) {
			ItensCompras item = new ItensCompras();
			item.setIngresso(ingresso);
			item.setValorIngresso(ingresso.getValor());
			item.setQuantidade(item.getQuantidade() + 1);
			item.setValorTotal(item.getQuantidade() * item.getValorIngresso());
			itensCompras.add(item);
		}
		mv.addObject("listaItens", itensCompras);
		return mv;

	}

	@GetMapping("/alterarQuantidade")
	public String alterarQuantidade(@RequestParam Integer codigo, Integer acao, Model model)throws Exception {
		Ingresso ingresso = this.ingressoService.findByIdIngresso(codigo);
		model.addAttribute("listaItens", itensCompras);
		
		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(codigo)) {
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade() + 1);
				} else if (acao == 0) {
					it.setQuantidade(it.getQuantidade() - 1);
				}
				break;
			}
		}
		return "/carrinhoDeCompras";
		
	}
	
	@GetMapping("/removerIngresso/")
	public ModelAndView removeIngresso(@RequestParam Integer codigo) {
		ModelAndView mv = new ModelAndView("carrinhoDeCompras");

		for (ItensCompras it : itensCompras) {
			if (it.getIngresso().getId().equals(codigo)) {
				itensCompras.remove(it);
				break;
			}
		}
		mv.addObject("listaItens", itensCompras);
		return mv;
	}
}
