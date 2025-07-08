package user.service.model;

public record UserRegisterRequest(
        String email,
        String password,
        String address,
        Long clientId,
        String role
) {}
