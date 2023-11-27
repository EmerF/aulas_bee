package com.ambev.techempowers.rest;

import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.message.MessageProducer;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
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

    private final MessageProducer messageProducer;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO produto) {
        //eventProducer.sendProductSavedEvent(produto.getNome());
        //messageProducer.sendMessage(String.format("Produto %s cadastrado com sucesso !",produto.toString()));
        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/consultar/{nome}")
    public ResponseEntity<List<ProdutoDTO>> consultarProdutos(@PathVariable String nome) {
        List<ProdutoDTO> produtos = produtoService.consultarPorNome(nome);
        if (produtos != null) {
            return ResponseEntity.ok(produtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/error")
    public ResponseEntity errorProduct() {
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String id, @RequestBody ProdutoDTO produtoAtualizar) {
        Produto produtoAtual = produtoService.atualizarProduto(id, produtoAtualizar);
        if (produtoAtual != null) {
            return new ResponseEntity<>(produtoAtual, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
