package pessoas.attornautus.api.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String principal;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
    }


    public void atualizaInformacoes(DadosEndereco dados) {

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
}
