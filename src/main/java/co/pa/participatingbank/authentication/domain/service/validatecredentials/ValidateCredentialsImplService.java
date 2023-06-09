package co.pa.participatingbank.authentication.domain.service.validatecredentials;
import co.pa.participatingbank.authentication.domain.model.Authentication;
import co.pa.participatingbank.authentication.domain.port.AuthenticationRepository;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public class ValidateCredentialsImplService implements ValidateCredentialsService{
    private final AuthenticationRepository authenticationRepository;

    public ValidateCredentialsImplService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public Uni<Response> validateCredentials(Authentication authentication) {

        return authenticationRepository.getAllAuthentication()
                .map(authentications -> authentications.stream()
                        .anyMatch(authenticationElement -> hasTheSameClientIdAndClientSecret(authentication, authenticationElement)))
                .map(ValidateCredentialsImplService::buildResponse);
    }

    private static Boolean hasTheSameClientIdAndClientSecret(Authentication authentication, Authentication authenticationElement) {
        return authentication.clientId().equals(authenticationElement.clientId()) && authentication.clientSecret().equals(authenticationElement.clientSecret());
    }

    private static Response buildResponse(Boolean isTheSameClientIdAndClientSecret) {
        return isTheSameClientIdAndClientSecret
                ? Response.ok("Credenciales correctas").build()
                : Response.status(Response.Status.UNAUTHORIZED).entity("Usuario no autorizado").build();
    }


}
