package pp2.ifpe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import pp2.ifpe.model.Usuario;

public class AutorizadorInterceptor  implements HandlerInterceptor {

	private static final String[] RECURSOS_BLOQUEADOS = { "/upload", "/perfil/editar", "/grupo/novo" };
	private static final String[] RECURSOS_BLOQUEADOS_USUARIO = { "/login", "/cadastro" };
	private static final String PAGINA_ACESSO_NEGADO_PADRAO = "/login";
	private static final String PAGINA_ACESSO_NEGADO_INICIO = "/index";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" >>> INFO:: Interceptor antes da chamada <<< ");

		String url = request.getPathInfo();

		HttpSession session = request.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLoado");

		System.out.println(url);
		if (usuarioLogado == null) {
			for (String recurso : RECURSOS_BLOQUEADOS) {
				if (recurso == url) {
					request.setAttribute("acessoNegado", true);
					request.setAttribute("retorno", request.getRequestURI());
					request.getRequestDispatcher(PAGINA_ACESSO_NEGADO_PADRAO).forward(request, response);

					return false;
				}
			}
		}

		return true;
	}
}
