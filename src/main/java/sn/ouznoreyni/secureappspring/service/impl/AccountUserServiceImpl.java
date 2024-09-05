package sn.ouznoreyni.secureappspring.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.ouznoreyni.secureappspring.dao.AccountUserRepository;
import sn.ouznoreyni.secureappspring.dto.AccountEditDto;
import sn.ouznoreyni.secureappspring.dto.AccountUserDto;
import sn.ouznoreyni.secureappspring.entity.AccountUserEntity;
import sn.ouznoreyni.secureappspring.exception.UserNotFoundException;
import sn.ouznoreyni.secureappspring.mapper.AccountUserMapper;
import sn.ouznoreyni.secureappspring.service.AccountUserService;


@Service
@AllArgsConstructor
public class AccountUserServiceImpl implements AccountUserService {

    private static final Logger logger = LoggerFactory.getLogger(AccountUserServiceImpl.class);

    private AccountUserRepository accountUserRepository;

    private AccountUserMapper accountUserMapper;

    @Override
    public Page<AccountUserDto> getAllUsers(Pageable pageable) {
        logger.info("Récupération des utilisateurs - Page: {}, Taille: {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<AccountUserEntity> userPage = accountUserRepository.findAll(pageable);
        return userPage.map(accountUserMapper::toDto);
    }

    @Override
    public AccountUserDto getUserById(Long id) {
        logger.info("Récupération de l'utilisateur avec l'ID: {}", id);
        AccountUserEntity user = accountUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return accountUserMapper.toDto(user);
    }

    @Override
    public AccountUserDto createUser(AccountEditDto accountEditDto) {
        logger.info("Création d'un nouvel utilisateur");
        AccountUserEntity user = accountUserMapper.toEntity(accountEditDto);
        AccountUserEntity savedUser = accountUserRepository.save(user);
        return accountUserMapper.toDto(savedUser);
    }

    @Override
    public AccountUserDto updateUser(Long id, AccountEditDto accountEditDto) {
        logger.info("Mise à jour de l'utilisateur avec l'ID: {}", id);
        AccountUserEntity user = accountUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        accountUserMapper.updateEntityFromDto(user, accountEditDto);
        AccountUserEntity updatedUser = accountUserRepository.save(user);
        return accountUserMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Suppression de l'utilisateur avec l'ID: {}", id);
        if (!accountUserRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        accountUserRepository.deleteById(id);
    }
}