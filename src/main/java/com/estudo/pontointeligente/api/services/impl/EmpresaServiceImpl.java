package com.estudo.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.pontointeligente.api.entities.Empresa;
import com.estudo.pontointeligente.api.repositories.EmpresaRepository;
import com.estudo.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCnpj(final String cnpj) {
		LOGGER.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(final Empresa empresa) {
		LOGGER.info("Persistindo empresa: {}", empresa);
		return empresaRepository.save(empresa);
	}

}
