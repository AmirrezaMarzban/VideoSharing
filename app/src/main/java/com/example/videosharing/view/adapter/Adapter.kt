package com.example.videosharing.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videosharing.R
import com.example.videosharing.databinding.LayoutBinding
import com.example.videosharing.model.Model
import com.example.videosharing.view.BindingViewHolder
import com.example.videosharing.viewmodel.ViewModel

class Adapter(var items: MutableList<Model> = arrayListOf(), private val vm: ViewModel) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout,
                null,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.items = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class ViewHolder(view: View) : BindingViewHolder<LayoutBinding>(view)
}