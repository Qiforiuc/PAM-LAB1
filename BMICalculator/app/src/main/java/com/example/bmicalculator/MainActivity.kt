package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Exception
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var height_data : TextView
    private lateinit var weight_data : TextView
    private lateinit var index_field : TextView
    private lateinit var grade_field : TextView
    private lateinit var count_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        height_data = findViewById(R.id.height_count)
        weight_data = findViewById(R.id.weight_count)
        index_field = findViewById(R.id.index_field)
        grade_field = findViewById(R.id.grade_field)
        count_button = findViewById(R.id.count_button)

        count_button.setOnClickListener()
        {
            var height : Double? = null
            var weight : Double? = null

            try{
                height = height_data.text.toString().toDouble()
                weight = weight_data.text.toString().toDouble()
                if(height != null && weight != null)
                {
                    var index : Double = (weight / height.pow(2)) * 10000

                    if(index < 18.5)
                    {
                        grade_field.text = "Underweight"
                    }
                    else if(index >= 18.5 && index < 25)
                    {
                        grade_field.text = "Healthy"
                    }
                    else if(index >= 25 && index < 30)
                    {
                        grade_field.text = "Overweight"
                    }
                    else{
                        grade_field.text = "Obese"
                    }
                    index_field.text = String.format("%.2f", index)
                }
            }
            catch (e : Exception){
                index_field.text = "Fill both metrics"
                grade_field.text = ""
                println(e.toString())
            }
        }

    }
}