package co.pa.participatingbank.authentication.domain.port;

import co.pa.participatingbank.authentication.domain.model.Authentication;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface AuthenticationRepository {
    Uni<List<Authentication>> getAllAuthentication();
}
