package com.alice.recyclerviewissue.my_schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alice.recyclerviewissue.MainActivity
import com.alice.recyclerviewissue.databinding.MyScheduleListBinding


class MyScheduleAdapter (private val context : Context) : RecyclerView.Adapter<MyScheduleAdapter.ViewHolder>() {

    var data = listOf<MainActivity.Data>()
    private val myScheduleTimeAdapter = MyScheduleTimeAdapter(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyScheduleListBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class ViewHolder(private val binding: MyScheduleListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MainActivity.Data) {
            binding.name = data.name
            myScheduleTimeAdapter.data = data.times
            binding.rvTime.setHasFixedSize(false)
            binding.rvTime.layoutManager = LinearLayoutManager(context)
            binding.rvTime.adapter = myScheduleTimeAdapter
        }
    }
}
