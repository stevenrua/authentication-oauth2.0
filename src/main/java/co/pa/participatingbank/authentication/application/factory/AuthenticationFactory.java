package co.pa.participatingbank.authentication.application.factory;

import co.pa.participatingbank.authentication.application.command.AuthenticationCommand;
import co.pa.participatingbank.authentication.domain.model.Authentication;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationFactory {

    public Authentication execute(AuthenticationCommand authenticationCommand) {
        return new Authentication(authenticationCommand.getClientId(), authenticationCommand.getClientSecret());
    }

}
