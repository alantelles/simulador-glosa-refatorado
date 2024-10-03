package br.com.zgsolucoes.simuladorglosa.servicos.impressao.implementacao

import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.TipoImpressao
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

import java.text.DecimalFormat
import java.text.NumberFormat

@CompileStatic
@Singleton
class ImpressorValorAnalisadoBrlCSV extends ImpressorValorAnalisadoCSV {

	private static final Locale LOCALE = new Locale('pt', 'BR')
	private static final DecimalFormat CURRENCY_FORMAT = (DecimalFormat) NumberFormat.getCurrencyInstance(LOCALE)

	TipoImpressao compativelCom() {
		return TipoImpressao.BRL
	}

	@Override
	protected String criarLinha(ValorAnalisado analisado) {
		return [
				analisado.faturado.codigo,
				CURRENCY_FORMAT.format(analisado.faturado.valor),
				CURRENCY_FORMAT.format(analisado.calculado),
				CURRENCY_FORMAT.format(analisado.criticado)
		].join(SEPARADOR)
	}

}
