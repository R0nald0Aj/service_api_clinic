package my.service.com.clinica.api.repository

import my.service.com.clinica.api.entitie.News
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository :JpaRepository<News,Long> {
}