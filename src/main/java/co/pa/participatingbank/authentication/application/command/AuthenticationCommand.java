package co.pa.participatingbank.authentication.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationCommand {

    private String clientId;
    private String clientSecret;

}
