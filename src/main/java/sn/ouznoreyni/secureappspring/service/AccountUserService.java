package sn.ouznoreyni.secureappspring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.ouznoreyni.secureappspring.dto.AccountEditDto;
import sn.ouznoreyni.secureappspring.dto.AccountUserDto;

public interface AccountUserService {
    Page<AccountUserDto> getAllUsers(Pageable pageable);
    AccountUserDto getUserById(Long id);
    AccountUserDto createUser(AccountEditDto accountEditDto);
    AccountUserDto updateUser(Long id, AccountEditDto accountEditDto);
    void deleteUser(Long id);
}
