package sn.ouznoreyni.secureappspring.mapper;

import org.springframework.stereotype.Component;
import sn.ouznoreyni.secureappspring.dto.AccountEditDto;
import sn.ouznoreyni.secureappspring.dto.AccountUserDto;
import sn.ouznoreyni.secureappspring.entity.AccountUserEntity;

@Component
public class AccountUserMapper {

    public AccountUserDto toDto(AccountUserEntity entity) {
        return new AccountUserDto(
                entity.getId(),
                entity.getEmail(),
                entity.getState()
        );
    }

    public AccountUserEntity toEntity(AccountEditDto dto) {
        AccountUserEntity entity = new AccountUserEntity();
        entity.setEmail(dto.email());
        entity.setPassword(dto.password());
        entity.setState(dto.state());
        return entity;
    }

    public void updateEntityFromDto(AccountUserEntity entity, AccountEditDto dto) {
        entity.setEmail(dto.email());
        if (dto.password() != null && !dto.password().isEmpty()) {
            entity.setPassword(dto.password());
        }
        entity.setState(dto.state());
    }
}