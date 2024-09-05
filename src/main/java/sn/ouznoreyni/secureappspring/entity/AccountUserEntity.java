package sn.ouznoreyni.secureappspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import sn.ouznoreyni.secureappspring.shared.UserState;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AccountUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "L'email doit être valide")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    private String password;

    @NotNull(message = "L'état de l'utilisateur ne peut pas être nul")
    @Enumerated(EnumType.STRING)
    private UserState state;
}