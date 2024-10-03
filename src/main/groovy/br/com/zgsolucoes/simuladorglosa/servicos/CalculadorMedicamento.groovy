package br.com.zgsolucoes.simuladorglosa.servicos

import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class CalculadorMedicamento extends Calculador {

    TipoItem tipoItemAplicavel = TipoItem.MEDICAMENTO

    Integer percentualAjuste = 30

}
