package com.deyvidsalvatore.produtosapi;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deyvidsalvatore.produtosapi.model.ProdutoModel;
import com.deyvidsalvatore.produtosapi.repository.ProdutoRepository;

@SpringBootApplication
public class ProdutosapiApplication implements CommandLineRunner {
	
	private final ProdutoRepository produtoRepository;

	public ProdutosapiApplication(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutosapiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//produtoRepository.findAll().forEach(System.out::println);
		// Verifica se já existem dados no banco de dados
		if (produtoRepository.count() == 0) {
        	// Se não existirem, chame a função que cria os dados
        	criarDadosIniciais();
        }
	}

	private void criarDadosIniciais() {
		// Crie aqui os objetos ProdutoModel com os dados desejados
		ProdutoModel produto1 = new ProdutoModel();
		produto1.setNome("Camisa Hollyweed");
		produto1.setValor(BigDecimal.valueOf(19.99));

		ProdutoModel produto2 = new ProdutoModel();
		produto2.setNome("Boné Hugo Boss");
		produto2.setValor(BigDecimal.valueOf(29.99));

		// Salve os objetos no banco de dados
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		System.out.println("Dados iniciais criados com sucesso.");
	}
}
