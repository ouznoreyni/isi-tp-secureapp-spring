package sn.ouznoreyni.secureappspring.dto;

import sn.ouznoreyni.secureappspring.shared.UserState;

public record AccountUserDto(Long id, String email, UserState state) {
}
