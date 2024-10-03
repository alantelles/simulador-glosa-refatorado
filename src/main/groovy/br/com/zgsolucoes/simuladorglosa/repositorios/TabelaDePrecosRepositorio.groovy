package br.com.zgsolucoes.simuladorglosa.repositorios

import br.com.zgsolucoes.simuladorglosa.dominio.TabelaDePrecos
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TabelaDePrecosRepositorio extends CrudRepository<TabelaDePrecos, String> {
}
