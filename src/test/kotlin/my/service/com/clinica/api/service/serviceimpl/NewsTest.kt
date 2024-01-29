package my.service.com.clinica.api.service.serviceimpl

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import my.service.com.clinica.api.entitie.News
import my.service.com.clinica.api.repository.NewsRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*


@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class NewsTest {

    @MockK
    lateinit var newsRepository: NewsRepository

    @InjectMockKs
    lateinit var newsService: NewsImpl

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun findAllNews() {
        val listNotices = listOf(buildNews(2), buildNews(3), buildNews(4))
        every { newsRepository.findAll() }.returns(listNotices)
        val actualList = newsService.findAllNews()
        Assertions.assertThat(actualList).isNotEmpty
    }

    @Test
     fun `shuld return a news by your id`(){
        val fakeNews = buildNews()
         every { newsRepository.findById(any()) }.returns(Optional.of(fakeNews))

       val actual =  newsService.findNewsById(1)

      Assertions.assertThat(actual.title).isEqualTo("Nova Vacina")

        verify(exactly = 1){
            newsRepository.findById(1)
        }

     }

    @Test
    fun save() {
        val fakeNews = buildNews()
        every { newsRepository.save(any()) }.returns(fakeNews)
        val actual = newsService.save(fakeNews)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual.title).isEqualTo("Nova Vacina")
        Assertions.assertThat(actual).isEqualTo(fakeNews)
        verify(exactly = 1) { newsRepository.save(fakeNews) }
    }

    @Test
    fun delete() {
        val news = buildNews()

            every { newsRepository.findById(any()) }.returns(Optional.of(news))
            every { newsRepository.deleteById(any()) } just runs

            newsService.delete(news.id!!)

            verify(exactly = 1) { newsRepository.findById(1) }
            verify(exactly = 1) { newsRepository.deleteById(1) }

        }

        @Test
        fun update() {
            val fakeNews = buildNews()
            val newsUpdate =buildNewsUpdate()

            every { newsRepository.findById(1) }.returns(Optional.of(fakeNews))
            every { newsRepository.save(any())}.returns((newsUpdate))

            val actual = newsService.update( newsUpdate,1)

            Assertions.assertThat(actual.title).isEqualTo("Teste de vacina")
            Assertions.assertThat(actual.id).isEqualTo(1)

            verify(exactly = 1){
                newsRepository.save(newsUpdate)
            }

        }
    }

fun buildNews(
    id: Long = 1,title: String ="Nova Vacina",about: String = "Medicna",text: String = "lorem idfasfafasfafdfdfsfsd"
) = News(id, title, about, text)


fun buildNewsUpdate(
    id: Long = 1,title: String ="Teste de vacina",about: String = "Medicna Pessoal",text: String = "lorem idfasfafasfafdfdfsfsd"
) = News(id, title, about, text)