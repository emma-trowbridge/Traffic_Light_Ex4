package com.bignerdranch.android.traffic_light_ex4

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bignerdranch.android.traffic_light_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class TrafficLightState {
        STOP, GO, WAIT
    }

    private var currentState = TrafficLightState.STOP // Start with STOP state
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        updateTrafficLight()

        binding.trafficButton.setOnClickListener {
            currentState = when (currentState) {
                TrafficLightState.STOP -> TrafficLightState.GO
                TrafficLightState.GO -> TrafficLightState.WAIT
                TrafficLightState.WAIT -> TrafficLightState.STOP
            }
            updateTrafficLight()
        }
    }

    private fun updateTrafficLight() {
        when (currentState) {
            TrafficLightState.STOP -> {
                binding.trafficButton.text = "STOP"
                binding.trafficButton.setBackgroundColor(Color.RED)

                binding.trafficlightRed.visibility = View.VISIBLE
                binding.trafficlightGreen.visibility = View.INVISIBLE
                binding.trafficlightYellow.visibility = View.INVISIBLE
            }

            TrafficLightState.GO -> {
                binding.trafficButton.text = "WAIT"
                binding.trafficButton.setBackgroundColor(Color.GREEN)

                binding.trafficlightRed.visibility = View.INVISIBLE
                binding.trafficlightGreen.visibility = View.VISIBLE
                binding.trafficlightYellow.visibility = View.INVISIBLE
            }

            TrafficLightState.WAIT -> {
                binding.trafficButton.text = "WAIT"
                binding.trafficButton.setBackgroundColor(Color.YELLOW)

                binding.trafficlightRed.visibility = View.INVISIBLE
                binding.trafficlightGreen.visibility = View.INVISIBLE
                binding.trafficlightYellow.visibility = View.VISIBLE
            }
        }
    }
}