package com.deyvidsalvatore.produtosapi.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
	private LocalDateTime timestamp;
	private String error;
	private Integer status;
	private String path;
}
