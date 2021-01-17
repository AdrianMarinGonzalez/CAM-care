package com.amaringo.domain.centers

import com.amaringo.domain.base.Subscriber
import com.amaringo.domain.model.CategoryDataDTO
import com.amaringo.domain.model.CenterDetailDTO
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.mockito.BDDMockito.given
import org.mockito.Mockito.*
import java.lang.Exception


class CentersUseCaseTest : BaseUseCaseTest() {

    val testModule = module {
        single<CentersRepository> {
            mock(CentersRepository::class.java)
        }

        single(qualifier = named("CategoryDataDTOSubscriber")) {
            mock(Subscriber::class.java) as Subscriber<CategoryDataDTO>
        }

        single(qualifier = named("CenterDetailDTOSubscriber")) {
            mock(Subscriber::class.java) as Subscriber<CenterDetailDTO>
        }

        single {
            CentersUseCase(get(), get())
        }
    }

    @Before
    fun before() {
        loadKoinModules(testModule)
    }

    @Test
    fun `geCenters should retrieve zone categories from repository`() {
        val mockDTO = CategoryDataDTO("category", emptyList())
        val mockZone = "mockZone"
        val mockRepositoryResponse = Observable.just(mockDTO)
        val stubRepository: CentersRepository by inject()
        `when`(stubRepository.getCenters(mockZone)).thenReturn(mockRepositoryResponse)
        val mockSubscriber: Subscriber<CategoryDataDTO> by inject(qualifier = named("CategoryDataDTOSubscriber"))

        val sut: CentersUseCase by inject()

        sut.getCategories(mockZone, mockSubscriber)

        verify(stubRepository).getCenters(mockZone)
        verify(mockSubscriber, times(1)).onNext(mockDTO)
    }

    @Test
    fun `geCenter should retrieve center from repository`() {
        val mockDTO = CenterDetailDTO("title", "schedule", "address", "description")
        val mockUrl = "mockUrl"
        val mockRepositoryResponse = Single.just(mockDTO)
        val mockRepository: CentersRepository by inject()
        `when`(mockRepository.getCenter(mockUrl)).thenReturn(mockRepositoryResponse)
        val mockSubscriber: Subscriber<CenterDetailDTO> by inject(qualifier = named("CenterDetailDTOSubscriber"))
        val sut: CentersUseCase by inject()

        sut.getCenter(mockUrl, mockSubscriber)

        verify(mockRepository).getCenter(mockUrl)
        verify(mockSubscriber, times(1)).onNext(mockDTO)
    }

    @Test(expected = Exception::class)
    fun `geCenter should call onError when repository call fails`() {
        val mockUrl = "mockUrl"
        val mockRepository: CentersRepository by inject()
        given(mockRepository.getCenter(mockUrl)).willAnswer {
            throw Exception()
        }
        val mockSubscriber: Subscriber<CenterDetailDTO> by inject(qualifier = named("CenterDetailDTOSubscriber"))
        val sut: CentersUseCase by inject()

        sut.getCenter(mockUrl, mockSubscriber)

        verify(mockRepository).getCenter(mockUrl)
        verify(mockSubscriber, times(1)).onError(any(Exception::class.java))
    }
}