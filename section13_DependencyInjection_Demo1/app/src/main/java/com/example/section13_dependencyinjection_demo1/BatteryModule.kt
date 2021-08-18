package com.example.section13_dependencyinjection_demo1

import dagger.Module
import dagger.Provides

@Module
class BatteryModule {
    @Provides
    fun providesBattery(lithiumBattery: LithiumBattery): Battery {
        return lithiumBattery
    }
}