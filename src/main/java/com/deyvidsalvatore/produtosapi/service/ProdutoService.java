package com.deyvidsalvatore.produtosapi.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deyvidsalvatore.produtosapi.dto.ProdutoDto;
import com.deyvidsalvatore.produtosapi.exceptions.ResourceNotFoundException;
import com.deyvidsalvatore.produtosapi.model.ProdutoModel;
import com.deyvidsalvatore.produtosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	private final ModelMapper modelMapper;
	
	public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
		this.produtoRepository = produtoRepository;
		this.modelMapper = modelMapper;
	}

	public List<ProdutoDto> getAllProdutos() {
		return produtoRepository.findAll()
				.stream()
				.map(this::entidadeParaDto)
				.toList();
	}
	
	public ProdutoDto getProdutoById(UUID id) {
		return entidadeParaDto(produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto com ID não encontrado: " + id)));
	}
	
	public ProdutoDto saveProduto(ProdutoDto produtoDto) {
		var produto = produtoRepository.save(dtoParaEntidade(produtoDto));
		return entidadeParaDto(produto);
	}
	
	public ProdutoDto updateProduto(UUID id, ProdutoDto produtoNovo) {
		var produtoExistente = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto com ID não encontrado: " + id));
		produtoExistente.setNome(produtoNovo.getNome());
		produtoExistente.setValor(produtoNovo.getValor());
		return entidadeParaDto(produtoRepository.save(produtoExistente));
	}
	
	public String deleteProduto(UUID id) {
		produtoRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Produto com ID não encontrado: " + id));
		produtoRepository.deleteById(id);
		return "Produto com o ID: " + id + " foi apagado";
	}
	
	private ProdutoDto entidadeParaDto(ProdutoModel produto) {
		return modelMapper.map(produto, ProdutoDto.class);
	}
	
	private ProdutoModel dtoParaEntidade(ProdutoDto produtoDto) {
		return modelMapper.map(produtoDto, ProdutoModel.class);
	}
}
