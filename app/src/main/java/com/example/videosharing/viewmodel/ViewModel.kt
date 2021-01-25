package com.example.videosharing.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.databinding.ObservableBoolean
import com.example.videosharing.PlayerActivity
import com.example.videosharing.core.BaseViewModel
import com.example.videosharing.data.ApiService
import com.example.videosharing.extensions.NotNullMutableLiveData
import com.example.videosharing.extensions.with
import com.example.videosharing.model.Model
import io.reactivex.android.schedulers.AndroidSchedulers

class ViewModel(var api: ApiService, var context: Context) : BaseViewModel() {
    init {
        getVideos()
    }

    private val items: NotNullMutableLiveData<MutableList<Model>> =
        NotNullMutableLiveData(arrayListOf())
    val finalItems: NotNullMutableLiveData<MutableList<Model>>
        get() = items

    val isLoaded = ObservableBoolean()

    private fun getVideos() {
        addToDisposable(api.getVideo.with()
            .doOnSubscribe { }
            .doOnSuccess { }
            .doOnError {
                Log.i("amirtest", it.message!!)

            }
            .subscribe({
                items.value = it
            }, {
                Log.i("amirtest", it.message!!)
            })
        )
    }

    fun playVideo(url: String) {
        context.startActivity(Intent(context, PlayerActivity::class.java).putExtra("url", url).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

}