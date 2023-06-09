package co.pa.participatingbank.authentication.infrastructure.mongo;

import co.pa.participatingbank.authentication.infrastructure.entity.AuthenticationEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationMongoRepository implements ReactivePanacheMongoRepository<AuthenticationEntity> {
}
