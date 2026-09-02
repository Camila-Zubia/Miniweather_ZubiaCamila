package zubia.camila.miniweather_zubiac

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvCity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            val tvGreeting : TextView = findViewById<TextView>(R.id.tvGreeting)
            val tvCity : TextView = findViewById<TextView>(R.id.tvCity)
            val ivWeather : ImageView = findViewById<ImageView>(R.id.ivWeather)
            val tvTemperature : TextView = findViewById<TextView>(R.id.tvTemperature)
            val tvWeather : TextView = findViewById<TextView>(R.id.tvWeather)
            insets
        }
    }
}