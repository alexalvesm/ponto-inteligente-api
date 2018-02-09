package com.estudo.pontointeligente.api.services;

import java.util.Optional;

import com.estudo.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(final String cnpj);
	
	Empresa persistir(final Empresa empresa);
	
}
