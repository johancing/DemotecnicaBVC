package co.com.demobvc.domain.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 32097731167948889L;
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
