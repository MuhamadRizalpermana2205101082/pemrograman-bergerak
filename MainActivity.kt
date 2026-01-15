package com.example.calenderapp

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val edtNote = findViewById<EditText>(R.id.edtNote)
        val btnSave = findViewById<Button>(R.id.btnSave)

        var selectedDate = ""

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        }

        btnSave.setOnClickListener {
            if (edtNote.text.isNotEmpty() && selectedDate.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Kegiatan tanggal $selectedDate disimpan",
                    Toast.LENGTH_SHORT
                ).show()
                edtNote.text.clear()
            } else {
                Toast.makeText(
                    this,
                    "Pilih tanggal dan isi kegiatan",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
