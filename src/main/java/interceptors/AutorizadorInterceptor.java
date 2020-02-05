package interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import pp2.ifpe.model.Usuario;


public class AutorizadorInterceptor implements HandlerInterceptor {


	private static final boolean CONTROLAR_ACESSO = true;

	private static final String[] RECURSOS_LIVRES = {"/","/sair", "/login", "/acesso-negado","/cadastro","/ativarConta","/confirmouConta","/Quem Somos"};

	private static final String PAGINA_ACESSO_NEGADO = "/acesso-negado";
	
	private static final String[] RECURSOS_USUARIO = {"/login","/cadastro","/home","listarMeusEvento","sair"};
	
	private static final String[] RECURSOS_ADMIN = {"/adicionar_materiais","/salvarMaterial"};

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" >>> INFO:: Interceptor antes da chamada <<< ");
		
		//libera todos arquivos da pasta static
		if(handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		if (!CONTROLAR_ACESSO) {
			return true;
		}
		
		// Para acessar qualquer pagina dessa aplicaÃƒÂ§ÃƒÂ£o, o usuÃƒÂ¡rio precisa estar
		// autenticado
		
		for (String recurso : RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				return true;
			}
		}
		
		

		if (request.getSession().getAttribute("usuarioLogado") == null) {
			request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
			return false;
		} else {
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			
			for (String recurso : RECURSOS_ADMIN) {
				if (request.getRequestURL().toString().contains(recurso) && usuario.getPermissao() == 1) {
					return true;
				}
			}
			
			for (String recurso : RECURSOS_USUARIO) {
				if (request.getRequestURL().toString().contains(recurso) && usuario.getPermissao() == 0) {
					return true;
				}
			}
		
			request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
			return false;
		}

	}

}