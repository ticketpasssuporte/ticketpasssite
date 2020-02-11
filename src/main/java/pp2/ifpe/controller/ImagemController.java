package pp2.ifpe.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.classic.pattern.Util;
import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.persistence.IngressoDAO;
import pp2.ifpe.service.EventoService;

@Controller
public class ImagemController {
	
	// Caminho da pasta onde ficam as imagens do evento
	private static String caminhoImagens ="/home/ticketpass/ImagemEvento/";
	private static String caminhoImagemCategoria ="/home/ticketpass/ImagemCategoria/";
	
	
	
	//Metodo de mostrar Imagem do evento
	@GetMapping("/mostrarImagemEvento/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem")String imagem) throws IOException {
		File imagemArquivoFile = new File(caminhoImagens+imagem);
		if(imagem!=null || imagem.trim().length()>0) {
			return Files.readAllBytes(imagemArquivoFile.toPath());
		}
		return Files.readAllBytes(imagemArquivoFile.toPath());
	}
	
	//Metodo de mostrar Imagem do evento
		@GetMapping("/mostrarImagemCategoria/{imagem}")
		@ResponseBody
		public byte[] retornarImagem2(@PathVariable("imagem")String imagem) throws IOException {
			File imagemArquivoFile = new File(caminhoImagemCategoria+imagem);
			if(imagem!=null || imagem.trim().length()>0) {
				return Files.readAllBytes(imagemArquivoFile.toPath());
			}
			return Files.readAllBytes(imagemArquivoFile.toPath());
		}
		

}
