package my.service.com.clinica.api.entitie

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "date_consultation")
data class DateConsultations(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id : String?,
        val date : LocalDate,
        val isAvailableDate :Boolean,
)
