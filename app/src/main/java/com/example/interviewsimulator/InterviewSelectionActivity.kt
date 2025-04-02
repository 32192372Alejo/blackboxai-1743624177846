package com.example.interviewsimulator

import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewsimulator.adapter.InterviewAdapter
import com.example.interviewsimulator.model.Interview
import com.example.interviewsimulator.model.InterviewType
import com.google.android.material.button.MaterialButton

class InterviewSelectionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InterviewAdapter
    private lateinit var btnStartSimulation: MaterialButton
    private lateinit var btnBack: ImageButton
    private lateinit var tvFaq: TextView
    private lateinit var rbEasy: RadioButton
    private lateinit var rbNormal: RadioButton
    private lateinit var rbHard: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_selection)

        initializeViews()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun initializeViews() {
        recyclerView = findViewById(R.id.rvInterviews)
        btnStartSimulation = findViewById(R.id.btnStartSimulation)
        btnBack = findViewById(R.id.btnBack)
        tvFaq = findViewById(R.id.tvFaq)
        rbEasy = findViewById(R.id.rbEasy)
        rbNormal = findViewById(R.id.rbNormal)
        rbHard = findViewById(R.id.rbHard)

        // Seleccionar "Fácil" por defecto
        rbEasy.isChecked = true
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = InterviewAdapter(getInterviewList()) { interview ->
            // Manejar la selección de la entrevista aquí
        }
        recyclerView.adapter = adapter
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        btnStartSimulation.setOnClickListener {
            // Implementar la lógica para iniciar la simulación
        }

        tvFaq.setOnClickListener {
            // Implementar la navegación a la pantalla de FAQ
        }
    }

    private fun getInterviewList(): List<Interview> {
        return listOf(
            Interview(1, "Práctica técnica", "Preguntas sobre código, diseño y arquitectura.", InterviewType.TECHNICAL),
            Interview(2, "Ventas", "Preguntas de ventas y escenarios de rol.", InterviewType.SALES),
            Interview(3, "Gerente de producto", "Preguntas sobre productos y estrategia.", InterviewType.PRODUCT_MANAGER),
            Interview(4, "Ingeniero de software", "Preguntas sobre codificación y sistemas.", InterviewType.SOFTWARE_ENGINEER),
            Interview(5, "Diseñador de productos", "Preguntas sobre UX, UI y diseño.", InterviewType.PRODUCT_DESIGNER)
        )
    }
}