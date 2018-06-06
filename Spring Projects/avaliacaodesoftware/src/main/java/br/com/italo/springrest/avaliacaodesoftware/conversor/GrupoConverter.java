package br.com.italo.springrest.avaliacaodesoftware.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.italo.springrest.avaliacaodesoftware.domain.Grupo;

public class GrupoConverter implements Converter<String, Grupo>{

	@Override
	public Grupo convert(String texto) {
		char grupo = texto.charAt(0);
		return grupo == Grupo.ADMIN.getDesc() ? Grupo.ADMIN : Grupo.BASIC;
	}

}
