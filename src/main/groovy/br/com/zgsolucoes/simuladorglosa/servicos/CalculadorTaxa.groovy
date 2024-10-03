package br.com.zgsolucoes.simuladorglosa.servicos

import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class CalculadorTaxa extends Calculador {

    TipoItem tipoItemAplicavel = TipoItem.TAXA

    Integer percentualAjuste = 15

}
