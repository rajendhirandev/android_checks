package com.module.appcheckup.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _myData = MutableLiveData("Tester")
    val myData = _myData as LiveData<String>

    private val _myDataStateFlow = MutableStateFlow("Tester")
    val myDataStateFlow = _myDataStateFlow.asStateFlow()

    private val _myDataShareFlow = MutableSharedFlow<String>()
    val myDataSharedFlow = _myDataShareFlow.asSharedFlow()

    fun setData(data: String) {
        _myData.value = data
    }

    fun setDataStateFlow(dataStateFlow: String) {
        _myDataStateFlow.value = dataStateFlow
      /*  viewModelScope.launch {
            _myDataStateFlow.emit(dataStateFlow)
        }*/
    }

    fun setDataSharedFlow(dataSharedFlow: String) {
        viewModelScope.launch {
            _myDataShareFlow
                .emit(dataSharedFlow)
        }
    }

    fun updateData() = flow {
        for (it in 0..10 step 2) {
            delay(1000)
            emit(it)
        }
    }
}
