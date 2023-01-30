package pessoas.attornautus.api.pessoa;

import pessoas.attornautus.api.endereco.Endereco;



public record DadosDetalhamentoPessoa(Long id, String nome, String dataDeNascimento, Endereco endereco) {
    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataDeNascimento(), pessoa.getEndereco());
    }

}
