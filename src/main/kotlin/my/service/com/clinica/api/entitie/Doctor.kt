package my.service.com.clinica.api.entitie

import jakarta.persistence.*

@Entity
@Table(name = "doctor")
data class Doctor(
    @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       val id:Long?,
    @Column(nullable = false)
        val name :String,
    @Column(nullable = false, unique = true)
        val crm  :String,
    @Column(nullable = false)
        val imageUrl : String ="",
    val available: Boolean = false,
    @ManyToOne(fetch = FetchType.LAZY)
        val specialtyEntity : SpecialtyEntity? = null,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE,CascadeType.PERSIST])
       val dateConsultations : List<DateConsultations>
)
