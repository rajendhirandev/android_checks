package com.module.appcheckup.screens

import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(val repo:DashboardRepo) : ViewModel() {

    private val _myData = MutableLiveData("Tester")
    val myData = _myData as LiveData<String>

    private val _myDataStateFlow = MutableStateFlow("Tester")
    val myDataStateFlow = _myDataStateFlow.asStateFlow()

    private val _myDataShareFlow = MutableSharedFlow<String>()
    val myDataSharedFlow = _myDataShareFlow.asSharedFlow()

    private val _l1 = MutableLiveData<Int>()
    val l1 = _l1 as LiveData<Int>

    private val _l2 = MutableLiveData<String>()
    val l2 = _l2 as LiveData<String>

    private val ml = MediatorLiveData<String>()


    fun setData(data: String) {
        _myData.value = data
        ml.addSource(
            l1,
        ) {

        }
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

    /*fun updateData() = flow {
        for (it in 0..10 step 2) {
            delay(1000)
            emit(it)
        }
    }*/

    fun getData() = repo.updateData()
}
