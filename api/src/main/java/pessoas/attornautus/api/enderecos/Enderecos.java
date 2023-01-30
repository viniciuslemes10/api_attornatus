package pessoas.attornautus.api.enderecos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoas.attornautus.api.pessoa.Pessoa;
@Table(name = "enderecos")
@Entity(name = "Enderecos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Enderecos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    private Boolean ativo;

    public Enderecos(DadosCadastroEndereco dados) {
        this.ativo = true;
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.pessoa = dados.pessoa();
    }

    public void atualizarInformacoes(DadosAtualizacaoEndereco dados) {
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
        if(dados.numero() != null) {
            this.numero = dados.numero();
        }
        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
