package excecoes;

public class NenhumException extends Exception{

	// Serve para indicar que nenhum usu�rio foi encontrado
	
	private static final long serialVersionUID = 1L;

	public NenhumException(String msg) {
		super(msg);
	}
}
