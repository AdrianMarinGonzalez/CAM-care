package com.amaringo.presentation.base

import com.amaringo.presentation.common.StringLoader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module


val presentationModule = module {
    single(qualifier = named("MAIN_SCHEDULER")) { AndroidSchedulers.mainThread() }
    single(qualifier = named("IO_SCHEDULER")) { Schedulers.io() }

    single { StringLoader(androidContext()) }
}