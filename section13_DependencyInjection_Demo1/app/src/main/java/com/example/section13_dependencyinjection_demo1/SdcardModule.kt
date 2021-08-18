package com.example.section13_dependencyinjection_demo1

import dagger.Module
import dagger.Provides

@Module
class SdcardModule {
    @Provides
    fun providesSdcard(): Sdcard {
        return Sdcard()
    }
}