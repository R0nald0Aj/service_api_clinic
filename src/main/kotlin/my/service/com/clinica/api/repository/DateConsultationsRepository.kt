package my.service.com.clinica.api.repository

import my.service.com.clinica.api.entitie.DateConsultations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DateConsultationsRepository : JpaRepository<DateConsultations,UUID> {
}