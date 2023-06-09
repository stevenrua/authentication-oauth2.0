package co.pa.participatingbank.authentication.application.configuration;
import co.pa.participatingbank.authentication.domain.port.AuthenticationRepository;
import co.pa.participatingbank.authentication.domain.service.validatecredentials.ValidateCredentialsImplService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class Configuration {
    @Produces
    public ValidateCredentialsImplService validateCredentialsImplService(AuthenticationRepository authenticationRepository){
        return new ValidateCredentialsImplService(authenticationRepository);
    }
}
