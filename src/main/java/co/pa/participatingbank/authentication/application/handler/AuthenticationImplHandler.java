package co.pa.participatingbank.authentication.application.handler;

import co.pa.participatingbank.authentication.application.command.AuthenticationCommand;
import co.pa.participatingbank.authentication.application.factory.AuthenticationFactory;
import co.pa.participatingbank.authentication.domain.service.validatecredentials.ValidateCredentialsService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class AuthenticationImplHandler implements AuthenticationHandler{

    private final AuthenticationFactory authenticationFactory;
    private final ValidateCredentialsService validateCredentialsService;

    public AuthenticationImplHandler(AuthenticationFactory authenticationFactory, ValidateCredentialsService validateCredentialsService) {
        this.authenticationFactory = authenticationFactory;
        this.validateCredentialsService = validateCredentialsService;
    }

    @Override
    public Uni<Response> authenticate(AuthenticationCommand authenticationCommand) {
        return validateCredentialsService.validateCredentials(authenticationFactory.execute(authenticationCommand));
    }

}
