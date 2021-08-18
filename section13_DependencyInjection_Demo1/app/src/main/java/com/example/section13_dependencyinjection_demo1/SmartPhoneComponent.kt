package com.example.section13_dependencyinjection_demo1

import dagger.Component
import dagger.Module

@Component(modules=[SdcardModule::class, BatteryModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone() : SmartPhone
}