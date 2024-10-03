package br.com.zgsolucoes

import br.com.zgsolucoes.simuladorglosa.gerador.GeradorDeCriticas
import br.com.zgsolucoes.simuladorglosa.repositorios.TabelaDePrecosRepositorio
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
		geradorDeCriticas.gereFormatadoBrl(arquivo, nomeArquivo)

		then:
		Paths.get(PATH_GERADO, nomeArquivo).toFile().text == GeradorDeCriticas.getResource('/'.concat(arquivoEsperado)).text

		where:
		nomeArquivo            | arquivoEsperado
		'gerado_formatado.csv' | 'esperado_formatado.csv'
	}

	void 'test gerador de criticas sem formatar'() {
		given:
		File arquivo = new File(GeradorDeCriticas.getResource('/arquivo_itens.csv').path)

		when:
		geradorDeCriticas.gereSemFormatar(arquivo, nomeArquivo)

		then:
		Paths.get(PATH_GERADO, nomeArquivo).toFile().text == GeradorDeCriticas.getResource('/'.concat(arquivoEsperado)).text

		where:
		nomeArquivo  | arquivoEsperado
		'gerado.csv' | 'esperado.csv'
	}

}
