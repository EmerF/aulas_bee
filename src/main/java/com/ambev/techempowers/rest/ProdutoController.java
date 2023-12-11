package com.ambev.techempowers.rest;

import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.message.MessageProducer;
import com.ambev.techempowers.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
         "nome": "Produto1",
         "descricao": "desc de exemplo",
         "preco": 29.99
         }' http://localhost:8080/api/produtos

curl -X PUT -H "Content-Type: application/json" -d '{
  "nome": "Refrigerante",
  "descricao": "descrição atualizada",
  "preco": 5.99

}' http://localhost:8080/api/produtos/656661f3d39ceb196168c866
curl -X GET http://localhost:8080/api/produtos/consultar/Produto1
curl -X DELETE http://localhost:8080/api/produtos/6568ef1f65959e1816201662

curl -X POST -H "Content-Type: application/json" -d '{
         "nome": "Produto1",
         "descricao": "desc de exemplo",
         "preco": 0
         }' http://localhost:8080/api/produto
*/

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
    public ProdutoDTO cadastrarProduto(@RequestBody @Valid ProdutoDTO produto) {

        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/consultar/{nome}")
    public ResponseEntity<List<ProdutoDTO>> consultarProdutos(@PathVariable String nome) {
        List<ProdutoDTO> produtos = produtoService.consultarPorNome(nome);
        if (CollectionUtils.isEmpty(produtos)) {
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
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable String id,
                                                       @RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto
                (id, produtoDTO);
        if(produtoAtualizado != null){
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable String id){
        boolean deletado =  produtoService.deletarProduto(id);
        if(deletado){
            return ResponseEntity.ok("Produto deletado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
    }
}
