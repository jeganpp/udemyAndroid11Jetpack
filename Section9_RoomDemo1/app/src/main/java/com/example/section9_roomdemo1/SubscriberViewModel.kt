package com.example.section9_roomdemo1

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.section9_roomdemo1.db.Subscriber
import com.example.section9_roomdemo1.db.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class SubscriberViewModel(private val repository: SubscriberRepository): ViewModel(), Observable {

    val subscribers = repository.subscribers
    private var updateOrDelete =  false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    private var statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if(inputName.value == null) {
            statusMessage.value = Event("Subscriber name can not be empty")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Subscriber email can not be empty")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter a valid email id for the subscriber")
        } else {
            if (updateOrDelete) {
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            } else {
                val name: String = inputName.value!!
                val email: String = inputEmail.value!!
                insert(Subscriber(0, name, email))
                inputName.value = null
                inputEmail.value = null
            }
        }
    }

    fun clearAllOrDelete() {
        if(updateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber): Job = viewModelScope.launch {
        val newRowId = repository.insert(subscriber)
        if(newRowId > -1) {
            statusMessage.value = Event("Subscriber inserted successfully: new id is $newRowId")
        } else {
            statusMessage.value = Event("Subscriber insertion failed")
        }
    }

    fun update(subscriber: Subscriber): Job = viewModelScope.launch {
        val rowsUpdated = repository.update(subscriber)
        if(rowsUpdated == 1) {
            inputName.value = null
            inputEmail.value = null
            updateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("Subscriber updated successfully")
        } else {
            statusMessage.value = Event("Subscriber update failed")
        }
    }

    fun delete(subscriber: Subscriber): Job = viewModelScope.launch {
        val numberOfRowsDeleted = repository.delete(subscriber)
        if(numberOfRowsDeleted > 0) {
            inputName.value = null
            inputEmail.value = null
            updateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$numberOfRowsDeleted row deleted successfully")
        } else {
            statusMessage.value = Event("Subscriber deletion failed")
        }
    }

    fun clearAll(): Job = viewModelScope.launch {
        repository.deleteAll()
        statusMessage.value = Event("All subscribers cleared successfully")
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        updateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}