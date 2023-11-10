package proj.sis.dist.ac2voos.domain.client;


import javax.validation.constraints.NotBlank;

public record RequestClient(
        Long clientID,

        @NotBlank
        String name,

        @NotBlank
        String lastname,

        @NotBlank
        String cpf,

        @NotBlank
        String login,

        @NotBlank
        String password
) {
}
