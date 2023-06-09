package co.pa.participatingbank.authentication.infrastructure.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Builder
@MongoEntity(collection = "authentication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationEntity {
    @BsonId
    private ObjectId id;
    private String clientId;
    private String clientSecret;
}
