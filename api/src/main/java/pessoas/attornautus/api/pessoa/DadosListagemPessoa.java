package pessoas.attornautus.api.pessoa;

import pessoas.attornautus.api.endereco.Endereco;

public record DadosListagemPessoa(Long id, String nome, String dataDeNascimento, Endereco endereco) {
    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataDeNascimento(), pessoa.getEndereco());
    }
}
