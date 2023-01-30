package pessoas.attornautus.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pessoas.attornautus.api.enderecos.*;



@RestController
@RequestMapping("enderecos")
public class EnderecosController {
    @Autowired
    private EnderecosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriComponentsBuilder) {
        var enderecos = new Enderecos(dados);
        repository.save(enderecos);
        var uri = uriComponentsBuilder.path("/enderecos/{id}").buildAndExpand(enderecos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEnderecos(enderecos));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemEnderecos>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemEnderecos::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoEndereco dados) {
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEnderecos(endereco));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var enderecos = repository.getReferenceById(id);
        enderecos.excluir();
        return ResponseEntity.noContent().build();
    }

}
