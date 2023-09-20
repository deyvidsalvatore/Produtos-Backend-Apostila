package com.deyvidsalvatore.produtosapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deyvidsalvatore.produtosapi.dto.ProdutoDto;
import com.deyvidsalvatore.produtosapi.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> getAllProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAllProdutos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable UUID id) {;
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutoById(id));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> createProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produtoDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDto> updateProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoDto produtoDto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduto(id, produtoDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduto(@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteProduto(id));
	}

}
