package com.ambev.techempowers.rest;

import com.ambev.techempowers.message.ProdutoEventProducer;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.model.TipoProduto;
import com.ambev.techempowers.repository.ProdutoRepository;
import com.ambev.techempowers.repository.TipoProdutoRepository;
import com.ambev.techempowers.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Teste:
 * curl -X POST -H "Content-Type: application/json" -d '{
 *   "nome": "Produto de Exemplo",
 *    "descricao": "desc de exemplo",
 *   "preco": 29.99
 * }' http://localhost:8080/api/products
 *
 */


 /*curl -X POST -H "Content-Type: application/json" -d '{
         "nome": "Produto de Exemplo",
         "descricao": "desc de exemplo",
         "preco": 29.99
         }' http://localhost:8080/api/produtos*/

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEventProducer eventProducer;



    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository,  ProdutoEventProducer eventProducer) {
        this.produtoRepository = produtoRepository;
        this.eventProducer = eventProducer;
    }
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        eventProducer.sendProductSavedEvent(produto.getNome());
        return produtoRepository.save(produto);
    }

    @GetMapping("/consultar/{nome}")
    public ResponseEntity<List<Produto>> consultarProdutos(@PathVariable String nome) {
        List<Produto> produto = produtoService.consultarPorNome(nome);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/error")
    public ResponseEntity errorProduct() {
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
