package com.estudo.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.estudo.pontointeligente.api.entities.Empresa;
import com.estudo.pontointeligente.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ = "51463645000100";
	
	@Before
	public void setUp() {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(Empresa.of());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(Empresa.of());		
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = empresaService.buscarPorCnpj(CNPJ);
		
		assertTrue(empresa.isPresent());
	}
	
	@Test
	public void testPersistirEmpresa() {
		Empresa empresa = empresaService.persistir(Empresa.of());
		
		assertNotNull(empresa);
	}
}
