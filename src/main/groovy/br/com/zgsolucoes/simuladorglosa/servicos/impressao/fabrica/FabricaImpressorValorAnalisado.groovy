package br.com.zgsolucoes.simuladorglosa.servicos.impressao.fabrica

import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.excecao.NaoImplementadoExcecao
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.Impressor
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.TipoImpressao
import groovy.transform.CompileStatic
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class FabricaImpressorValorAnalisado {

	@Inject
	Collection<Impressor<ValorAnalisado>> impressores

	Impressor<ValorAnalisado> encontraImpressorPara(TipoImpressao tipoImpressao) throws NaoImplementadoExcecao {
		if (!impressores) {
			throw new NaoImplementadoExcecao("Nenhum ImpressorValorAnalisado implementado")
		}

		return Optional.ofNullable(
				impressores.find { Impressor impressor -> impressor.compativelCom() == tipoImpressao }
		).orElseThrow {
			throw new NaoImplementadoExcecao("Nenhum impressor implementado para ${tipoImpressao}")
		}
	}

}
