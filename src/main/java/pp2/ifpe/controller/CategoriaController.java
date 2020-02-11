package pp2.ifpe.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pp2.ifpe.model.Categoria;
import pp2.ifpe.service.CategoriaService;

@Controller
public class CategoriaController {
	
	private static String caminhoImagemCategoria ="/home/ticketpass/ImagemCategoria/";
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("cadcategoria")
	public String salvarCategoria(Categoria categoria) {
		return "cadastroCategoria";
	}
	
	@PostMapping("/salvarCategoria")
	public String salvandoCategoria(@Valid Categoria categoria, @RequestParam("file") MultipartFile arquivo) {
		this.categoriaService.categoriaSalva(categoria);
		try {
			if(!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoImagemCategoria+String.valueOf(categoria.getId())+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				
				categoria.setFotocategoria(String.valueOf(categoria.getId())+arquivo.getOriginalFilename());
				this.categoriaService.categoriaSalva(categoria);
			}
			
		} catch (Exception e) {
			
			
	}	
		
		return "redirect:/";	
	
	}
	
	
	@GetMapping("/listarCategoria2")
	public String listarCat2(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		return "listarCategoria2";
	}
	
	
}

