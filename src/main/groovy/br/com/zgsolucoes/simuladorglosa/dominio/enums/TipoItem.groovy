package br.com.zgsolucoes.simuladorglosa.dominio.enums

import groovy.transform.CompileStatic

@CompileStatic
enum TipoItem {

    PROCEDIMENTO,
    MATERIAL,
    MEDICAMENTO,
    TAXA

    static TipoItem from(String name) {
        Optional.ofNullable(values().find {
            it.name() == name.toUpperCase()
        }).orElseThrow {
            throw new IllegalArgumentException("Tipo Item inexistente")
        }
    }

}
