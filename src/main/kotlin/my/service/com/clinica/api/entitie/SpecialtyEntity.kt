package my.service.com.clinica.api.entitie

import jakarta.persistence.*

@Entity
@Table(name = "specialtie")
data class SpecialtyEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long?,
        val name :String,
        @OneToMany(fetch = FetchType.LAZY)
        val doctorList: List<Doctor>,
        val description :String
)
