package com.example.videosharing

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.videosharing.databinding.ActivityHomeBinding
import com.example.videosharing.view.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeActivity : BindingActivity<ActivityHomeBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = this
        binding.videoRv.layoutManager = GridLayoutManager(this, 3)
    }
}