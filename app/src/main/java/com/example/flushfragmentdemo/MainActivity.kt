package com.example.flushfragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var courseAdapter: CourseAdapter
    private val courseList = listOf(
        Course(R.mipmap.ic_launcher, "Android + Java + Firebase"),
        Course(R.mipmap.ic_launcher, "Java Foundations"),
        Course(R.mipmap.ic_launcher, "Android"),
        Course(R.mipmap.ic_launcher, "Firebase")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courseAdapter = CourseAdapter(courseList) { course, position ->
           Log.e("TAG","click:"+position)
        }
        rvLanguage.layoutManager = GridLayoutManager(this, 3) // 2 columns
        rvLanguage.adapter = courseAdapter
    }
}
