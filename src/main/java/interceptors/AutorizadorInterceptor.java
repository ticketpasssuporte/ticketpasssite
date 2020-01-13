package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import pp2.ifpe.model.Usuario;

public class AutorizadorInterceptor implements HandlerInterceptor {

    private final boolean CONTROLAR_ACESSO = true;
	
	private final String PAGINA_ACESSO_NEGADO = "/acesso-negado";
	
	private final String[] PAGINAS_ESTATICAS = {"/css/", "/js/", "/img/", "/fonts/", "/util/"};
	private final String[] PAGINAS_DESLOGADO = {"/", "/cadastrar", "/index","/login",
												"/reenviar-link-ativacao", "/ativarConta", 
												"/recuperar-senha", "/redefinirSenha"};
	private final String[] PAGINAS_LOGADO = {"/home", "/configuracoes", "/sair", "/evento", 
											 PAGINA_ACESSO_NEGADO};
	/*
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
	
	String urlRequisitada = request.getServletPath();
	Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
	boolean estaLogado = usuarioLogado != null ? true : false;
	
	if (!CONTROLAR_ACESSO) {
		return true;
	}
	
	if (urlRequisitada.contains("/admin/")) {
		if (estaLogado) {
			if (usuarioLogado.getPermissao() == 2) {
				return true;
			} else {
				request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
				return false;
			}
		} else {
			response.sendRedirect("/login?destino="+urlRequisitada);
			return false;
		}
	}
	for (String paginaLogado : PAGINAS_LOGADO) {
		if (urlRequisitada.contains(paginaLogado)) {
			if (estaLogado) {
				//System.out.println("Permitido (logado): "+urlRequisitada);
				return true;
			} else {
				//System.out.println("Negado (deslogado): "+urlRequisitada);
				if (!urlRequisitada.equals("/home") && !urlRequisitada.equals("/sair")) {
					response.sendRedirect("/login?destino="+urlRequisitada);
					return false;
				} else {
					response.sendRedirect("/login");
					return false;
				}
			}
		}
	}
	for (String paginaDeslogado : PAGINAS_DESLOGADO) {
		if (urlRequisitada.equals(paginaDeslogado)) {
			if (!estaLogado) {
				//System.out.println("Permitido (deslogado): "+urlRequisitada);
				return true;
			} else {
				//System.out.println("Negado (logado): "+urlRequisitada);
				response.sendRedirect("/home");
				return false;
			}
		}
	}
	for (String paginaEstatica : PAGINAS_ESTATICAS) {
		if (urlRequisitada.contains(paginaEstatica)) {
			//System.out.println("Permitido (estática): "+urlRequisitada);
			return true;
		}
	}
	
	return true;
   }*/
}