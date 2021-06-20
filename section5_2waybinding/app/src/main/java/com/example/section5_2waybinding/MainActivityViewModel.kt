package com.example.section5_2waybinding

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
In the below viewmodel, 2 way data binding is achieved as follows
User/view --> App/object binding is seen on variable 'input'. Whenever the edittext is changed, this variable is updated.
App/object --> User/view binding is seen on variable 'sum'.
When the 'Add' button is clicked, the app logic (in Add button's onclick listener) invokes the 'updateSum()' method and
the variable 'sum' gets updated. Since this LiveData is bound to the textView, the view gets updated automatically.
 */
class MainActivityViewModel: ViewModel() {
    var sum = MutableLiveData<Int>()

    @Bindable
    val input = MutableLiveData<String>()


    init {
        sum.value = 0
    }

    fun updateSum() {
        val intInput : Int = input.value!!.toInt()
        sum.value = (sum.value)?.plus(intInput)
    }
}