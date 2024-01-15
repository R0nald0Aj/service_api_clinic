package my.service.com.clinica.api.service

import my.service.com.clinica.api.dto.request.NewsDto
import my.service.com.clinica.api.entitie.News

interface INewsService  {
    fun findAllNews():List<News>;
    fun save(news: News):News;
    fun delete(id :Long);
    fun update(news: News):News;
}