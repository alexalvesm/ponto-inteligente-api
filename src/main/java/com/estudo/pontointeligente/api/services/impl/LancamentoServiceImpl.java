package com.estudo.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.estudo.pontointeligente.api.entities.Lancamento;
import com.estudo.pontointeligente.api.repositories.LancamentoRepository;
import com.estudo.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Page<Lancamento> buscarPorFuncionarioId(final Long funcionarioId, final PageRequest pageRequest) {
		LOGGER.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}
	
	@Cacheable("lancamentoPorId")
	public Optional<Lancamento> buscarPorId(final Long id) {
		LOGGER.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(lancamentoRepository.findOne(id));
	}
	
	@CachePut("lancamentoPorId")
	public Lancamento persistir(final Lancamento lancamento) {
		LOGGER.info("Persistindo o lançamento: {}", lancamento);
		return lancamentoRepository.save(lancamento);
	}
	
	public void remover(final Long id) {
		LOGGER.info("Removendo o lançamento ID {}", id);
		lancamentoRepository.delete(id);
	}
	
}