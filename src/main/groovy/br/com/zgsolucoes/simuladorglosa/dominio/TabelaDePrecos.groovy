package br.com.zgsolucoes.simuladorglosa.dominio

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
@CompileStatic
@EqualsAndHashCode(includeFields = true)
@ToString(includePackage = false, includeFields = true)
class TabelaDePrecos {

	@Id
	String codigo

	BigDecimal valor

}
