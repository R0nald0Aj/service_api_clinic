package my.service.com.clinica.api.repository


import my.service.com.clinica.api.entitie.SpecialtyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpecialtyReposritory : JpaRepository<SpecialtyEntity,Long> {
}
