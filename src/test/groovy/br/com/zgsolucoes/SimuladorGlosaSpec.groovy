package br.com.zgsolucoes

import br.com.zgsolucoes.simuladorglosa.gerador.GeradorDeCriticas
import br.com.zgsolucoes.simuladorglosa.repositorios.TabelaDePrecosRepositorio
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.TipoImpressao
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import java.nio.file.Paths

@MicronautTest
class SimuladorGlosaSpec extends Specification {

	private static final PATH_GERADO = 'src/main/resources/gerado'

	@Inject
	GeradorDeCriticas geradorDeCriticas

	@Inject
	TabelaDePrecosRepositorio repositorio

	void 'test gerador de criticas formatando'() {
		given:
		File arquivo = new File(GeradorDeCriticas.getResource('/arquivo_itens.csv').path)

		when:
		geradorDeCriticas.gereImpressao(arquivo, nomeArquivo, tipoImpressao)

		then:
		Paths.get(PATH_GERADO, nomeArquivo).toFile().text == GeradorDeCriticas.getResource('/'.concat(arquivoEsperado)).text

		where:
        nomeArquivo            | tipoImpressao     || arquivoEsperado
        'gerado_formatado.csv' | TipoImpressao.BRL || 'esperado_formatado.csv'
	}

	void 'test gerador de criticas sem formatar'() {
		given:
		File arquivo = new File(GeradorDeCriticas.getResource('/arquivo_itens.csv').path)

		when:
		geradorDeCriticas.gereImpressao(arquivo, nomeArquivo)

		then:
		Paths.get(PATH_GERADO, nomeArquivo).toFile().text == GeradorDeCriticas.getResource('/'.concat(arquivoEsperado)).text

		where:
		nomeArquivo  | arquivoEsperado
		'gerado.csv' | 'esperado.csv'
	}

}
