package pessoas.attornautus.api.enderecos;

public record DadosDetalhamentoEnderecos(
        Long id,
        String logradouro,
        String cep, String numero,
        String cidade) {
    public DadosDetalhamentoEnderecos(Enderecos enderecos) {
        this(enderecos.getId(), enderecos.getLogradouro(), enderecos.getCep(), enderecos.getNumero(), enderecos.getCidade());
    }
}
