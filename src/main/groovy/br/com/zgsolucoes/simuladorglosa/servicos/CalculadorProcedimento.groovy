package br.com.zgsolucoes.simuladorglosa.servicos

import br.com.zgsolucoes.simuladorglosa.dominio.TabelaDePrecos
import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import br.com.zgsolucoes.simuladorglosa.dtos.ValorAnalisado
import br.com.zgsolucoes.simuladorglosa.dtos.ValorFaturado
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class CalculadorProcedimento extends Calculador {

    TipoItem tipoItemAplicavel = TipoItem.PROCEDIMENTO

    Integer percentualAjuste = 55

    @Override
    ValorAnalisado calcular(ValorFaturado faturado, TabelaDePrecos itemTabela) {
        ValorAnalisado analisado = super.calcular(faturado, itemTabela)
        if (faturado.codigo.startsWith('4')) {
            analisado.calculado -= 20
        }
        return analisado
    }

}
