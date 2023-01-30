package pessoas.attornautus.api.enderecos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
        @NotNull
        Long id,
        String logradouro,
        String cep,
        String numero,
        String cidade) {
}
