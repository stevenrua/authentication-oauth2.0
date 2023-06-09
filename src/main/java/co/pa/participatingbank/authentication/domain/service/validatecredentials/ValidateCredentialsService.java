package co.pa.participatingbank.authentication.domain.service.validatecredentials;

import co.pa.participatingbank.authentication.domain.model.Authentication;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public interface ValidateCredentialsService {
    Uni<Response> validateCredentials(Authentication authentication);
}
