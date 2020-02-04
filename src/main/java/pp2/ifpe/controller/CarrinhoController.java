package pp2.ifpe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class CarrinhoController {

	
	@GetMapping("/carrinho")
	public ModelAndView ChamaCarrinho() {
	 ModelAndView mv = new ModelAndView("carrinhoDeCompras");
	 return mv;
	}
	
	@GetMapping("/adicionarCarrinho/{id}")
	public ModelAndView adicionarCarrinho(@PathVariable Integer id) {
	 ModelAndView mv = new ModelAndView("carrinhoDeCompras");
	 return mv;
	}
	
}
