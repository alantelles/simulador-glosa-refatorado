package br.com.zgsolucoes.simuladorglosa.servicos.impressao

import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.fabrica.FabricaImpressorValorAnalisado
import groovy.transform.CompileStatic
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class ImpressorValorAnalisado {

	@Inject
	FabricaImpressorValorAnalisado fabrica

	void imprimir(String nomeArquivo, List<ValorAnalisado> dados, TipoImpressao tipoImpressao) {
		Impressor<ValorAnalisado> impressor = fabrica.encontraImpressorPara(tipoImpressao)
		impressor.imprimir(nomeArquivo, dados)
	}

}
