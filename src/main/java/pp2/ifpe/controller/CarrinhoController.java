package pp2.ifpe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




@RestController
public class CarrinhoController {
 
	//Chamar Carrinho
	
	@GetMapping("/carrinho")
	public ModelAndView ChamaCarrinho() {
	 ModelAndView mv = new ModelAndView("carrinhoDeCompras");
	 return mv;
	}
	// Adicionar carrinho
	@GetMapping("/adicionarCarrinho")
	public ModelAndView adicionarCarrinho(@RequestParam("id") Integer codigo,HttpSession session,Model model) throws Exception  {
		ModelAndView mv = new ModelAndView("carrinhoDeCompras");
	 return mv;
	}
	
	
}
