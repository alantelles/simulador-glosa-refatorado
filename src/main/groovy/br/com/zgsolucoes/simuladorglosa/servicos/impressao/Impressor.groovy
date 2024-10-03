package br.com.zgsolucoes.simuladorglosa.servicos.impressao

import groovy.transform.CompileStatic

@CompileStatic
interface Impressor<T> {

	TipoImpressao compativelCom()

	void imprimir(String nomeArquivo, List<T> dados)

}
