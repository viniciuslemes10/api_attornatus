package pessoas.attornautus.api.enderecos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pessoas.attornautus.api.pessoa.Pessoa;

public record DadosCadastroEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        @Pattern(regexp = "\\d{1,8}")
        String numero,
        @NotBlank
        String cidade,
        @NotNull
        Pessoa pessoa) {
}
