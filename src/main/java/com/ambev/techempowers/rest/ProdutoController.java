package com.ambev.techempowers.rest;

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
 *   "name": "Produto de Exemplo",
 *   "price": 29.99
 * }' http://localhost:8080/api/products
 *
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final TipoProdutoRepository tipoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, TipoProdutoRepository tipoRepository) {
        this.produtoRepository = produtoRepository;
        this.tipoRepository = tipoRepository;
    }
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
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
