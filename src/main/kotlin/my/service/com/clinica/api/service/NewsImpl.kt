package my.service.com.clinica.api.service

import my.service.com.clinica.api.entitie.News
import org.springframework.stereotype.Service

@Service
class NewsImpl : INewsService {
    override fun findAllNews(): List<News> {
        TODO("Not yet implemented")
    }

    override fun save(news: News): News {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun update(news: News): News {
        TODO("Not yet implemented")
    }
}