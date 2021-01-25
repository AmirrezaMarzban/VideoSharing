package com.example.videosharing.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.videosharing.model.Model
import com.example.videosharing.view.adapter.Adapter
import com.example.videosharing.viewmodel.ViewModel

@BindingAdapter(value = ["mainRp", "mainViewModel"])
fun setRepository(view: RecyclerView, items: MutableList<Model>, vm: ViewModel) {
    view.adapter?.run {
        if (this is Adapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        Adapter(items, vm).apply { view.adapter = this }
    }
}