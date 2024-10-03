package br.com.zgsolucoes.simuladorglosa.gerador

import br.com.zgsolucoes.simuladorglosa.dominio.TabelaDePrecos
import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.dtos.ValorFaturado
import br.com.zgsolucoes.simuladorglosa.repositorios.TabelaDePrecosRepositorio
import br.com.zgsolucoes.simuladorglosa.servicos.FabricaCalculador
import br.com.zgsolucoes.simuladorglosa.servicos.arquivo.LeitorCSV
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.ImpressorValorAnalisado
import br.com.zgsolucoes.simuladorglosa.servicos.impressao.TipoImpressao
import groovy.transform.CompileStatic
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class GeradorDeCriticas {

	@Inject
	TabelaDePrecosRepositorio itemTabelaRepositorio

	@Inject
	FabricaCalculador fabricaCalculador

	@Inject
	ImpressorValorAnalisado impressorValorAnalisado

	void gereSemFormatar(File arquivo, String nomeArquivo) {
		imprimir(arquivo, nomeArquivo, TipoImpressao.PADRAO)
	}

	void gereFormatadoBrl(File arquivo, String nomeArquivo) {
		imprimir(arquivo, nomeArquivo, TipoImpressao.BRL)
	}

	List<ValorAnalisado> gere(File arquivo) {
		List<ValorFaturado> faturados = LeitorCSV.obterFaturados(arquivo)
		List<TabelaDePrecos> tabelaList = itemTabelaRepositorio.findAll()
		return calculeFaturados(faturados, tabelaList)
	}

	List<ValorAnalisado> calculeFaturados(List<ValorFaturado> faturados, List<TabelaDePrecos> tabelas) {
		List<ValorAnalisado> analisados = faturados.collect { ValorFaturado faturado ->
			TabelaDePrecos itemTabela = obterTabela(tabelas, faturado.codigo)
			return analisarFaturado(faturado, itemTabela)
		}
		return analisados
	}

	ValorAnalisado analisarFaturado(ValorFaturado faturado, TabelaDePrecos itemTabela) {
		return fabricaCalculador.encontrar(faturado.tipo)
				.calcular(faturado, itemTabela)
	}

	static TabelaDePrecos obterTabela(List<TabelaDePrecos> tabelas, String codigo) {
		Optional.ofNullable(tabelas.find {
			it.codigo == codigo
		}).orElseThrow {
			throw new UnsupportedOperationException("Não existe tabela de preços para este codigo")
		}
	}

	private void imprimir(File arquivo, String nomeArquivo, TipoImpressao tipoImpressao) {
		List<ValorAnalisado> analisados = gere(arquivo)
		impressorValorAnalisado.imprimir(nomeArquivo, analisados, tipoImpressao)
	}

}
