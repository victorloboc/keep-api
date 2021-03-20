package com.googlekeepapi.config.validacao;

public class ErroDeFormDto {

	private String campo;
	private String erro;

	public ErroDeFormDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

	
}
