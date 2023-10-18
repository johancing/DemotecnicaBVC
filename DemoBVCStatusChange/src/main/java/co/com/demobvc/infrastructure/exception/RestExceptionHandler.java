package co.com.demobvc.infrastructure.exception;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import co.com.demobvc.application.exception.StatusChangeException;
import co.com.demobvc.infrastructure.util.AppInformation;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);
	private static final String CODES_URL = "https://developer.mozilla.org/es/docs/Web/HTTP/Status";
	private static final String ERROR_CATEGORY = "errorCategory";
	private static final String TIMESTAMP = "timestamp";

	@ExceptionHandler(StatusChangeException.class)
	public ProblemDetail handleFileStoregeException(StatusChangeException e) {
		ProblemDetail err = ProblemDetail.forStatusAndDetail(e.getHttpStatus(), e.getMessage());
		err.setTitle(e.getMessage());
		try {
			err.setInstance(new URI(AppInformation.BASE_URL + e.getUrl()));
			err.setType(new URI(CODES_URL));
		} catch (URISyntaxException e1) {
			logger(e);
		}
		err.setProperty(ERROR_CATEGORY, e.getHttpStatus().getReasonPhrase());
		err.setProperty(TIMESTAMP, new Date(System.currentTimeMillis()));
		logger(e);
		return err;
	}

	@ExceptionHandler(Exception.class)
	public ProblemDetail handleException(Exception e) {
		ProblemDetail err = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		err.setTitle(e.getMessage());
		try {
			err.setInstance(new URI(AppInformation.BASE_URL));
			err.setType(new URI(CODES_URL));
		} catch (URISyntaxException e1) {
			logger(e);
		}
		err.setProperty(ERROR_CATEGORY, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		err.setProperty(TIMESTAMP, new Date(System.currentTimeMillis()));
		LOG.error(e.getMessage(), e);
		return err;
	}

	private void logger(Exception e) {
		LOG.error("requestId: {} : user {} : Error: {} {}", AppInformation.getInstance().getUid(),
				AppInformation.getInstance().getUser(), e.getMessage(), e);
	}
}
