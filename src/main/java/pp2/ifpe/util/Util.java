package pp2.ifpe.util;

 
import java.io.File;


public class Util {

	public static String caminhoParaImagemUsuario(String nomeFoto) {
		String caminhoCompleto = new File("").getAbsolutePath() + "/src/main/resources/static/img/eventos/";
		new File(caminhoCompleto).mkdirs();
		caminhoCompleto += nomeFoto;
		return caminhoCompleto;
	}	

}
