package exception;

public class ServiceException extends Exception{

	public static final long serialVersionUID = 1L;

	public ServiceException(String string) {
		super(string);
	}
}
