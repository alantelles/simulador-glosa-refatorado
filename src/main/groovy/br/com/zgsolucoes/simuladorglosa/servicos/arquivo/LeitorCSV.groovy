package br.com.zgsolucoes.simuladorglosa.servicos.arquivo

import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import br.com.zgsolucoes.simuladorglosa.dtos.ValorFaturado
import groovy.transform.CompileStatic

@CompileStatic
class LeitorCSV {

    protected static final String SEPARADOR = ';'

    static List<ValorFaturado> obterFaturados(File arquivo) {
        return arquivo.readLines().tail().collect {
            obterDeUmaLinha(it)
        }
    }

    static private ValorFaturado obterDeUmaLinha(String linha) {
        List<String> column = linha.tokenize(SEPARADOR)
        return ValorFaturado.construir(
                column[0],
                TipoItem.from(column[1]),
                column[2].toBigDecimal()
        )
    }

}
