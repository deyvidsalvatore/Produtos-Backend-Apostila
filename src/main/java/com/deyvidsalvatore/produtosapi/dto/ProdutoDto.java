package com.deyvidsalvatore.produtosapi.dto;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
	
	private UUID id;
	
	@NotBlank(message = "Nome não pode ficar em branco/nulo")
	@Size(min = 2, max = 30, message = "Nome deve ter entre 5 á 30 caracteres")
	private String nome;
	
	@NotNull(message = "Valor não pode ser vazio")
	private BigDecimal valor;
}
