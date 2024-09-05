package sn.ouznoreyni.secureappspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ouznoreyni.secureappspring.entity.AccountUserEntity;

public interface AccountUserRepository extends JpaRepository<AccountUserEntity, Long> {
}
