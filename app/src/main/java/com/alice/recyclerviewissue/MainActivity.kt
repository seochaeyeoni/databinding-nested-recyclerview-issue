package com.alice.recyclerviewissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alice.recyclerviewissue.databinding.ActivityMainBinding
import com.alice.recyclerviewissue.my_schedule.MyScheduleAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myScheduleAdapter: MyScheduleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        myScheduleAdapter = MyScheduleAdapter(this)
        myScheduleAdapter.data = makeDummy()
        binding.rvSchedule.layoutManager = LinearLayoutManager(this)
        binding.rvSchedule.adapter = myScheduleAdapter
    }


    private fun makeDummy(): List<Data> {
        return listOf<Data>(
            Data(
                listOf<Times>(
                    Times("Mon", "09:00", "12:00"),
                    Times("Wed", "09:00", "12:00")
                ),
                "Build smarter apps with machine learning"
            ),
            Data(
                listOf<Times>(
                    Times("Mon", "13:00", "18:00"),
                    Times("Tue", "13:00", "18:00"),
                    Times("Wed", "13:00", "18:00"),
                    Times("THU", "09:00", "18:00"),
                    Times("FRI", "09:00", "18:00"),
                    Times("SAT", "16:00", "18:00"),
                    Times("SUN", "09:00", "18:00"),
                ),
                "Android app development task"
            ),
            Data(
                listOf<Times>(
                    Times("Wed", "20:00", "23:00"),
                    Times("THU", "19:00", "22:00"),
                    Times("FRI", "19:00", "22:00"),
                    Times("SAT", "19:00", "22:00"),
                    Times("SUN", "19:00", "22:00"),
                ),
                "Cheese project(BucketList app)"
            ),
            Data(
                listOf<Times>(
                    Times("SAT", "13:00", "16:00"),
                ),
                "Solve algorithm problems."
            )
        )
    }

    data class Data(var times: List<Times>, var name: String)
    data class Times(var day: String, var startTime: String, var endTime: String)

}