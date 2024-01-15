package my.service.com.clinica.api.service.serviceimpl

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import my.service.com.clinica.api.entitie.News
import my.service.com.clinica.api.repository.NewsRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles


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
    fun save() {
        val fakeNews = buildNews()
      every { newsRepository.save(any()) }.returns(fakeNews)
        val actual = newsService.save(fakeNews)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual.title).isEqualTo("Nova Vacina")
        Assertions.assertThat(actual).isEqualTo(fakeNews)
        verify(exactly = 1){newsRepository.save(fakeNews)}
    }

    @Test
    fun delete() {
    }

    @Test
    fun update() {
    }
}

fun buildNews(
    id: Long = 1,title: String ="Nova Vacina",about: String = "Medicna",text: String = "lorem idfasfafasfafdfdfsfsd"
) = News(id, title, about, text)