package com.module.appcheckup.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _myData = MutableLiveData("Tester")
    val myData = _myData as LiveData<String>

    private val _myDataFlow = MutableStateFlow("Tester")
    val myDataFlow = _myDataFlow.asStateFlow()

    fun setData(data: String) {
        _myData.value = data
    }

    fun setDataFlow(dataFlow: String) {
        viewModelScope.launch {
            _myDataFlow.emit(dataFlow)
        }
    }

    fun updateData() = flow {
        for (it in 0..10 step 2) {
            delay(1000)
            emit(it)
        }
    }
}
