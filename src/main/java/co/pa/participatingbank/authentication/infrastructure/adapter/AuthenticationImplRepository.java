package co.pa.participatingbank.authentication.infrastructure.adapter;
import co.pa.participatingbank.authentication.domain.model.Authentication;
import co.pa.participatingbank.authentication.domain.port.AuthenticationRepository;
import co.pa.participatingbank.authentication.infrastructure.mapper.AuthenticationMapper;
import co.pa.participatingbank.authentication.infrastructure.mongo.AuthenticationMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthenticationImplRepository implements AuthenticationRepository {
    private final AuthenticationMongoRepository authenticationMongoRepository;

    public AuthenticationImplRepository(AuthenticationMongoRepository authenticationMongoRepository) {
        this.authenticationMongoRepository = authenticationMongoRepository;
    }

    @Override
    public Uni<List<Authentication>> getAllAuthentication() {
        return authenticationMongoRepository.listAll()
                .map(authenticationEntities -> authenticationEntities.stream()
                        .map(AuthenticationMapper::convertModelToEntity)
                        .collect(Collectors.toList()));
    }
}
