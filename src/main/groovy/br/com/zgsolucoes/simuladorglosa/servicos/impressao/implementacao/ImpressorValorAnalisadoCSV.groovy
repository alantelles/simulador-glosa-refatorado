package br.com.zgsolucoes.simuladorglosa.servicos.impressao.implementacao

import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.Impressor
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.TipoImpressao
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

import java.nio.file.Files
import java.nio.file.Paths

@CompileStatic
@Singleton
class ImpressorValorAnalisadoCSV implements Impressor<ValorAnalisado> {

	protected static final String SEPARADOR = ';'
	protected static final String QUEBRA_LINHA = '\n'
	protected static final String SAVE_PATH = 'src/main/resources/gerado'

	TipoImpressao compativelCom() {
		return TipoImpressao.PADRAO
	}

	void imprimir(String nomeArquivo, List<ValorAnalisado> analisados) {
		String texto = criarLinhasTexto(analisados)
				.join(QUEBRA_LINHA)
				.concat(QUEBRA_LINHA)
		Files.writeString(Paths.get(SAVE_PATH, nomeArquivo), texto)
	}

	protected String criarLinha(ValorAnalisado analisado) {
		return [
				analisado.faturado.codigo,
				analisado.faturado.valor,
				analisado.calculado.round(2),
				analisado.criticado.round(2)
		]*.toString().join(SEPARADOR)
	}

	protected List<String> criarLinhasTexto(List<ValorAnalisado> analisados) {
		List<String> linhas = [obterLinhaTitulo(['Código', 'Valor faturado', 'Valor Calculado', 'Valor criticado'])]
		linhas.addAll(analisados.collect { criarLinha(it) })
		return linhas
	}

	protected static String obterLinhaTitulo(List<String> campos) {
		campos.join(SEPARADOR)
	}

}
