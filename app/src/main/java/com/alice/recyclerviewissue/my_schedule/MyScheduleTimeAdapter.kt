package com.alice.recyclerviewissue.my_schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alice.recyclerviewissue.MainActivity
import com.alice.recyclerviewissue.databinding.MyScheduleTimeListBinding


class MyScheduleTimeAdapter (private val context : Context) : RecyclerView.Adapter<MyScheduleTimeAdapter.ViewHolder>() {

    var data = listOf<MainActivity.Times>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyScheduleTimeListBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /**
        There is an issue when writing the code as follows.

        holder.onBind(data[position])
         or
        holder.binding.times = data[position]
        **/
        holder.binding.day.text = data[position].day
        holder.binding.time.text = "${data[position].startTime} - ${data[position].endTime}"
    }

    class ViewHolder(val binding: MyScheduleTimeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MainActivity.Times) {
            binding.times = data
        }
    }
}