package my.service.com.clinica.api.entitie

import jakarta.persistence.*

@Entity
@Table(name = "news")
data class News(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long?,
        val title :String,
        val about : String,
        val text : String,
)
