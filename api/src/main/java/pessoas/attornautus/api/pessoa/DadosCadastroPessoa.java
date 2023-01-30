package pessoas.attornautus.api.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoas.attornautus.api.endereco.DadosEndereco;
import pessoas.attornautus.api.enderecos.DadosCadastroEndereco;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotNull
        String dataDeNascimento,
        @NotNull @Valid DadosEndereco endereco
){
}
