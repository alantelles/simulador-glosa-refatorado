package br.com.zgsolucoes.simuladorglosa.excecao

import groovy.transform.CompileStatic

@CompileStatic
class NaoImplementadoExcecao extends RuntimeException {

	NaoImplementadoExcecao(String message) {
		super(message)
	}

}
