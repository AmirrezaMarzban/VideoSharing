package com.example.videosharing.extensions
import androidx.lifecycle.MutableLiveData

/**
 * Handle whether MutableLiveData is null
 * @author Amirreza Marzban
 */

class NotNullMutableLiveData<T : Any>(defaultValue: T) : MutableLiveData<T>() {
    init {
        value = defaultValue
    }
    override fun getValue()  = super.getValue()!!
}