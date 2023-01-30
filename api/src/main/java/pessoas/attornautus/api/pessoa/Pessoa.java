package pessoas.attornautus.api.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoas.attornautus.api.endereco.Endereco;
import pessoas.attornautus.api.enderecos.Enderecos;

import java.util.List;


@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataDeNascimento;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;
    @OneToMany(mappedBy = "pessoa")
    private List<Enderecos> enderecos;

    public Pessoa(DadosCadastroPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizaInformacoes(DadosAtualizaPessoa dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.dataDeNascimento() != null) {
            this.dataDeNascimento = dados.dataDeNascimento();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizaInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
