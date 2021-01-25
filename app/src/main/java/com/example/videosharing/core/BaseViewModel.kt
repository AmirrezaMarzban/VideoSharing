package com.example.videosharing.core

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.videosharing.extensions.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * The other viewmodels will be extend from this class to have access Rxjava and other methods
 * @author Amirreza Marzban
 */

open class BaseViewModel : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun addToDisposable(disposable: Disposable) {
        disposables += disposable
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

}