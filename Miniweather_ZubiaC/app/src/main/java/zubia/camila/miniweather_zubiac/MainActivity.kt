package zubia.camila.miniweather_zubiac

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import zubia.camila.miniweather_zubiac.domain.Weather
import zubia.camila.miniweather_zubiac.utilities.WeatherService
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvCity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            val tvGreeting : TextView = findViewById<TextView>(R.id.tvGreeting)
            val tvCity : TextView = findViewById<TextView>(R.id.tvCity)
            var ivWeather : ImageView = findViewById<ImageView>(R.id.ivWeather)
            val tvTemperature : TextView = findViewById<TextView>(R.id.tvTemperature)
            val tvWeather : TextView = findViewById<TextView>(R.id.tvWeather)
            val citySelected = intent.getStringExtra("city")
            val time = LocalTime.now().hour
            tvGreeting.text = when(time){
                in 5..11 -> getString(R.string.good_morning)
                in 12..19 -> getString(R.string.good_afternoon)
                in 20 ..24, in 1..4 -> getString(R.string.good_night)
                else -> "Buen día"
            }
            val weather : Weather = WeatherService(this).returnWeather(citySelected.toString())
            ivWeather.setImageResource(
                when(weather.weather){
                    getString(R.string.snowy) -> R.drawable.ic_snowy
                    getString(R.string.stormy) -> R.drawable.ic_stormy
                    getString(R.string.windy) -> R.drawable.ic_windy
                    getString(R.string.rainy) -> R.drawable.ic_rainy
                    getString(R.string.cloudy) -> R.drawable.ic_cloudy
                    getString(R.string.sunny) -> R.drawable.ic_sunny
                    else -> R.drawable.ic_cloudy
                }
            )
            tvWeather.text = weather.weather
            tvTemperature.text = weather.temperature.toString()
            tvCity.text = citySelected
            WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
            insets
        }
    }
}