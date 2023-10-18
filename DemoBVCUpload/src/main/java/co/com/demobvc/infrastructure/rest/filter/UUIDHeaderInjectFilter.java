package co.com.demobvc.infrastructure.rest.filter;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import co.com.demobvc.infrastructure.util.AppInformation;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UUIDHeaderInjectFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestId = extractRequestUUID(request);
		response.setHeader("responseId", requestId);
		AppInformation.getInstance().setUid(requestId);
		AppInformation.getInstance().setUser(extractRequestUser(request));
		AppInformation.getInstance().setCreationdate(new Date(System.currentTimeMillis()));
		filterChain.doFilter(request, response);		
	}
	
	private String extractRequestUUID(HttpServletRequest request) {
		final String requestId = request.getHeader("requestId");
		if (requestId != null && !requestId.isBlank())
			return requestId;
		return UUID.randomUUID().toString();
	}

	private String extractRequestUser(HttpServletRequest request) {
		final String user = request.getHeader("user");
		if (user != null && !user.isBlank())
			return user;
		return "UNKNOW_USER";
	}
}
