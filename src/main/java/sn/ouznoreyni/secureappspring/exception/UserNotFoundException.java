package sn.ouznoreyni.secureappspring.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Utilisateur non trouvé avec l'ID : " + id);
    }
}
