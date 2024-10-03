package br.com.zgsolucoes.simuladorglosa.servicos

import br.com.zgsolucoes.simuladorglosa.dominio.enums.TipoItem
import groovy.transform.CompileStatic
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class FabricaCalculador {

    @Inject
    List<Calculador> calculadores

    Calculador encontrar(TipoItem tipoItem) {
        Optional.ofNullable(calculadores.find {
            it.aplicavelEm(tipoItem)
        }).orElseThrow {
            throw new UnsupportedOperationException("Não há um calculador para este tipo de item")
        }
    }

}
