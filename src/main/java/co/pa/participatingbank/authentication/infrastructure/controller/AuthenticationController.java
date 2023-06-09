package co.pa.participatingbank.authentication.infrastructure.controller;
import co.pa.participatingbank.authentication.application.command.AuthenticationCommand;
import co.pa.participatingbank.authentication.application.handler.AuthenticationHandler;
import co.pa.participatingbank.authentication.domain.service.validatecredentials.ValidateCredentialsService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;

import javax.swing.*;


@Path("/authentication")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class AuthenticationController {
    private final ValidateCredentialsService validateCredentialsService;
    private final AuthenticationHandler authenticationHandler;
    @POST
    public Uni<Response> listar(@HeaderParam("clientId") String clientId,
                                @HeaderParam("clientSecret") String clientSecret){
        return authenticationHandler.authenticate(new AuthenticationCommand(clientId, clientSecret));
    }
}
