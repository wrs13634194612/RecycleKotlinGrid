package com.example.flushfragmentdemo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(
    private val courseList: List<Course>,
    private val clickListener: (Course, Int) -> Unit // Add this parameter
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    // ViewHolder class that binds the views
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseImage: ImageView = itemView.findViewById(R.id.courseImage)
        val courseText: TextView = itemView.findViewById(R.id.courseText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.courseImage.setImageResource(course.imageResId)
        holder.courseText.text = course.name

        // Set a click listener on the itemView (the entire item)
        holder.itemView.setOnClickListener {
            clickListener(course, position) // Call the passed in listener
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}