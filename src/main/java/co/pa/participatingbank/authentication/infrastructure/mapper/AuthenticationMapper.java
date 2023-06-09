package co.pa.participatingbank.authentication.infrastructure.mapper;

import co.pa.participatingbank.authentication.domain.model.Authentication;
import co.pa.participatingbank.authentication.infrastructure.entity.AuthenticationEntity;

public class AuthenticationMapper {
    public static Authentication convertModelToEntity(AuthenticationEntity authenticationEntity){
        return new Authentication(authenticationEntity.getClientId(), authenticationEntity.getClientSecret());
    }
}
