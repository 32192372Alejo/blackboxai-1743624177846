package com.example.interviewsimulator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewsimulator.R
import com.example.interviewsimulator.model.Interview
import com.example.interviewsimulator.model.InterviewType

class InterviewAdapter(
    private val interviews: List<Interview>,
    private val onInterviewSelected: (Interview) -> Unit
) : RecyclerView.Adapter<InterviewAdapter.InterviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_interview, parent, false)
        return InterviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: InterviewViewHolder, position: Int) {
        holder.bind(interviews[position])
    }

    override fun getItemCount(): Int = interviews.size

    inner class InterviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvDescription)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onInterviewSelected(interviews[position])
                }
            }
        }

        fun bind(interview: Interview) {
            titleTextView.text = when (interview.type) {
                InterviewType.TECHNICAL -> itemView.context.getString(R.string.technical_practice)
                InterviewType.SALES -> itemView.context.getString(R.string.sales)
                InterviewType.PRODUCT_MANAGER -> itemView.context.getString(R.string.product_manager)
                InterviewType.SOFTWARE_ENGINEER -> itemView.context.getString(R.string.software_engineer)
                InterviewType.PRODUCT_DESIGNER -> itemView.context.getString(R.string.product_designer)
            }

            descriptionTextView.text = when (interview.type) {
                InterviewType.TECHNICAL -> itemView.context.getString(R.string.technical_description)
                InterviewType.SALES -> itemView.context.getString(R.string.sales_description)
                InterviewType.PRODUCT_MANAGER -> itemView.context.getString(R.string.product_manager_description)
                InterviewType.SOFTWARE_ENGINEER -> itemView.context.getString(R.string.software_engineer_description)
                InterviewType.PRODUCT_DESIGNER -> itemView.context.getString(R.string.product_designer_description)
            }
        }
    }
}