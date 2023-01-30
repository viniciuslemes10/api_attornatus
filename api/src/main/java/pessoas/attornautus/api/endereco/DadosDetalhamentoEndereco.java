package pessoas.attornautus.api.endereco;

public record DadosDetalhamentoEndereco(String logradouro, String cep, String numero, String cidade, String principal) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPrincipal());
    }
}
