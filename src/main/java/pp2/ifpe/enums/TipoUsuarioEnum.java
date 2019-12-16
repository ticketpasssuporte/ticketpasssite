package pp2.ifpe.enums;

public enum TipoUsuarioEnum {

	
	ADMIN("Admnistrador"),
	PADRAO("Usuário");
	

	public String texto;

	TipoUsuarioEnum(String t) {
		texto = t;
	}
}
