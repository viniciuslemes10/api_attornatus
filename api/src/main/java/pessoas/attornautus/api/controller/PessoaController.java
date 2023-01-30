package pessoas.attornautus.api.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;
import pessoas.attornautus.api.pessoa.*;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriComponentsBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPessoa::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id()); //buscando a pessoa no banco de daods pelo id
        pessoa.atualizaInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

}
