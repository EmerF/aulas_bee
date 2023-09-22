package com.ambev.techempowers.rest;

import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Teste:
 * curl -X POST -H "Content-Type: application/json" -d '{
 *   "name": "Produto de Exemplo",
 *   "price": 29.99
 * }' http://localhost:8080/api/products
 *
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto createProduct(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }
}
