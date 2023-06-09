package co.pa.participatingbank.authentication.application.handler;

import co.pa.participatingbank.authentication.application.command.AuthenticationCommand;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public interface AuthenticationHandler {

    Uni<Response> authenticate(AuthenticationCommand authenticationCommand);

}
