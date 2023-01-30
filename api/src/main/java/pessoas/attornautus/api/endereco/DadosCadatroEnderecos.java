package pessoas.attornautus.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoas.attornautus.api.pessoa.Pessoa;

public record DadosCadatroEnderecos(
        @NotBlank
        String logradouro,
        @NotBlank
        String cep,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotNull
        Pessoa pessoa
) {
}
