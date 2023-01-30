package pessoas.attornautus.api.enderecos;

import pessoas.attornautus.api.pessoa.Pessoa;

public record DadosListagemEnderecos(Long id, String logradouro, String cep, String numero, String cidade) {
    public DadosListagemEnderecos(Enderecos endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade());
    }
}
