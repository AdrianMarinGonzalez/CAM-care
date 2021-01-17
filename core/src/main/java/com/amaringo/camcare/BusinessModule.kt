package com.amaringo.camcare

import com.amaringo.domain.base.SchedulerProvider
import com.amaringo.domain.centers.CentersUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module


val businessModule = module {
    single<SchedulerProvider> {
        SchedulerProviderImpl()
    }

    factory { CentersUseCase(
        get(),
        get()
    )
    }
}