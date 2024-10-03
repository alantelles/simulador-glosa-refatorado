package br.com.zgsolucoes.simuladorglosa.dtos

import groovy.transform.CompileStatic

@CompileStatic
class ValorAnalisado {

    ValorFaturado faturado
    BigDecimal calculado
    BigDecimal criticado

    static ValorAnalisado construir(
            ValorFaturado faturado,
            BigDecimal calculado,
            BigDecimal criticado
    ) {
        return new ValorAnalisado(
                faturado: faturado,
                calculado: calculado,
                criticado: criticado
        )
    }

}
