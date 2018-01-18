package com.estudo.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordUtils.class);
	
	private PasswordUtils() {
		super();
	}
	
	public static String gerarBCrypt(String senha) {
		if (senha == null || senha.trim().length() == 0) {
			return senha;
		}

		LOGGER.info("Gerando hash com o BCrypt.");
		return new BCryptPasswordEncoder().encode(senha);
	}

}
