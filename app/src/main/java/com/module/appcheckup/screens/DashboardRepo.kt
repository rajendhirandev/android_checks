package com.module.appcheckup.screens

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class DashboardRepo {

    fun updateData() = flow {
        for (it in 0..10 step 2) {
            delay(1000)
            emit(it)
        }
    }
}