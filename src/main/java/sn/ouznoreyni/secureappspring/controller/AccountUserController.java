package sn.ouznoreyni.secureappspring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ouznoreyni.secureappspring.dto.AccountEditDto;
import sn.ouznoreyni.secureappspring.dto.AccountUserDto;
import sn.ouznoreyni.secureappspring.service.AccountUserService;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AccountUserController {

    private final AccountUserService accountUserService;

    @GetMapping
    public ResponseEntity<Page<AccountUserDto>> getAllUsers(@PageableDefault(size = 20) Pageable pageable) {
        log.info("Requête GET pour récupérer les utilisateurs paginés");
        Page<AccountUserDto> users = accountUserService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountUserDto> getUserById(@PathVariable Long id) {
        log.info("Requête GET pour récupérer l'utilisateur avec l'ID: {}", id);
        AccountUserDto user = accountUserService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<AccountUserDto> createUser(@Valid @RequestBody AccountEditDto accountEditDto) {
        log.info("Requête POST pour créer un nouvel utilisateur");
        AccountUserDto createdUser = accountUserService.createUser(accountEditDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountUserDto> updateUser(@Valid @PathVariable Long id, @RequestBody AccountEditDto accountEditDto) {
        log.info("Requête PUT pour mettre à jour l'utilisateur avec l'ID: {}", id);
        AccountUserDto updatedUser = accountUserService.updateUser(id, accountEditDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Requête DELETE pour supprimer l'utilisateur avec l'ID: {}", id);
        accountUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
