package com.amaringo.domain.centers

import com.amaringo.domain.base.SchedulerProvider
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito


open class BaseUseCaseTest: AutoCloseKoinTest() {


    val baseModule = module {
        single<SchedulerProvider> {
            TestSchedulerProvider()
        }
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(baseModule)
    }
}

class TestSchedulerProvider: SchedulerProvider {
    override fun observeTarget() = Schedulers.trampoline()
    override fun subscribeTarget() = Schedulers.trampoline()
}
