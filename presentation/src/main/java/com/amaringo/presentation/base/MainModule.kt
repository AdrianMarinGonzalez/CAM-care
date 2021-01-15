package com.amaringo.presentation.base

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module


val mainModule = module {
    single(qualifier = named("MAIN_SCHEDULER")) { AndroidSchedulers.mainThread() }
    single(qualifier = named("IO_SCHEDULER")) { Schedulers.io() }
}