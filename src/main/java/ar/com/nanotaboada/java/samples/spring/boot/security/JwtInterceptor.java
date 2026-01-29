package ar.com.nanotaboada.java.samples.spring.boot.security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.HttpHeaders;
import java.io.IOException;

@Slf4j
public class JwtInterceptor implements ClientHttpRequestInterceptor {

    private final String jwtToken;

    public JwtInterceptor(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        log.info("set Interceptor ");

        request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        log.info("set header ");
        return execution.execute(request, body);
    }
}