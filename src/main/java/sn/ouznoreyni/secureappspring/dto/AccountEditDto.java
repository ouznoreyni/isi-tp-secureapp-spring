package sn.ouznoreyni.secureappspring.dto;

import sn.ouznoreyni.secureappspring.shared.UserState;

public record AccountEditDto(String email, String password, UserState state) {
}
