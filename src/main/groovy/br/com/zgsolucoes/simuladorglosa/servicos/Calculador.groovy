package br.com.zgsolucoes.simuladorglosa.servicos

import br.com.zgsolucoes.simuladorglosa.dominio.TabelaDePrecos
import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.dtos.ValorFaturado
import groovy.transform.CompileStatic

@CompileStatic
abstract class Calculador {

    abstract TipoItem getTipoItemAplicavel()

    abstract Integer getPercentualAjuste()

    Boolean aplicavelEm(TipoItem tipoItem) {
        return tipoItem == tipoItemAplicavel
    }

    BigDecimal getAjusteValor() {
        return 1 + percentualAjuste / 100
    }

    ValorAnalisado calcular(ValorFaturado faturado, TabelaDePrecos itemTabela) {
        BigDecimal calculado = itemTabela.valor * ajusteValor
        BigDecimal criticado = calculado - faturado.valor
        return ValorAnalisado.construir(
                faturado,
                calculado,
                criticado
        )
    }

}
