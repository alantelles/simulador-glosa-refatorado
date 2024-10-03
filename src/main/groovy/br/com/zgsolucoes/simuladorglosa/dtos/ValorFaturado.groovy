package br.com.zgsolucoes.simuladorglosa.dtos

import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import groovy.transform.CompileStatic

@CompileStatic
class ValorFaturado {

    String codigo
    TipoItem tipo
    BigDecimal valor

    static ValorFaturado construir(String codigo, TipoItem tipo, BigDecimal valor) {
        return new ValorFaturado(
                codigo: codigo,
                tipo: tipo,
                valor: valor
        )
    }

}
