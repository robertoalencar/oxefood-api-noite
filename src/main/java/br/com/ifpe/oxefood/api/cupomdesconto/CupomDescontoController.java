package br.com.ifpe.oxefood.api.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDesconto;
import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDescontoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cupom")
@CrossOrigin
public class CupomDescontoController {

    @Autowired
    private CupomDescontoService cupomDescontoService;
    
    @Operation(
        summary = "Serviço responsável por salvar um cupom de desconto no sistema.",
        description = "Exemplo de descrição de um endpoint responsável por inserir um cupom de desconto no sistema."
    )
    @PostMapping
    public ResponseEntity<CupomDesconto> save(@RequestBody CupomDescontoRequest request) {

        CupomDesconto cupomDesconto = cupomDescontoService.save(request.build());
        return new ResponseEntity<CupomDesconto>(cupomDesconto, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Serviço responsável por listar todos os cupons do sistema."
    )
    @GetMapping
    public List<CupomDesconto> listarTodos() {

        return cupomDescontoService.listarTodos();
    }

    @Operation(
        summary = "Serviço responsável por retornar um cupom de um ID enviado na URL."
    )
    @GetMapping("/{id}")
    public CupomDesconto obterPorID(@PathVariable Long id) {

        return cupomDescontoService.obterPorID(id);
    }

    @Operation(
        summary = "Serviço responsável por remover um cupom no sistema."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        cupomDescontoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
