package co.com.demobvc.application.exception;

import org.springframework.http.HttpStatus;

public class FileStoregeException extends RuntimeException {

	private static final long serialVersionUID = 2490954471548855214L;
	private final HttpStatus httpStatus;
	private final String url;

	public FileStoregeException(String message, String url, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.url = url;
	}

	public FileStoregeException(String message, String url, HttpStatus httpStatus, Throwable cause) {
		super(message, cause);
		this.httpStatus = httpStatus;
		this.url = url;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getUrl() {
		return url;
	}

}
