package pessoas.attornautus.api.pessoa;

import jakarta.validation.constraints.NotNull;
import pessoas.attornautus.api.endereco.DadosEndereco;

public record DadosAtualizaPessoa(
        @NotNull
        Long id,
        String nome,
        String dataDeNascimento,
        DadosEndereco endereco) {
}
