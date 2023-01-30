package pessoas.attornautus.api.enderecos;

import pessoas.attornautus.api.pessoa.Pessoa;

public record DadosDetalhamentoEnderecosPessoa(Long id, String logradouro, String cep, String numero, String cidade) {

    public DadosDetalhamentoEnderecosPessoa(Enderecos enderecos) {
        this(enderecos.getId(), enderecos.getLogradouro(), enderecos.getCep(), enderecos.getNumero(), enderecos.getCidade());
    }
}
