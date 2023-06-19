package com.example.poblacinpaises
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.poblacinpaises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorPaises: ArrayAdapter<String>

    private val paises = arrayOf(
        "Argentina",
        "Bolivia",
        "Brasil",
        "Chile",
        "Colombia",
        "Ecuador",
        "Guyana",
        "Paraguay",
        "Perú",
        "Surinam",
        "Uruguay",
        "Venezuela"
    )

    private val poblaciones = mapOf(
        "Argentina" to "45.38 millones",
        "Bolivia" to "11.51 millones",
        "Brasil" to "211.05 millones",
        "Chile" to "19.11 millones",
        "Colombia" to "49.65 millones",
        "Ecuador" to "17.37 millones",
        "Guyana" to "0.78 millones",
        "Paraguay" to "7.05 millones",
        "Perú" to "32.97 millones",
        "Surinam" to "0.58 millones",
        "Uruguay" to "3.46 millones",
        "Venezuela" to "28.52 millones"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val vista = binding.root
        setContentView(vista)

        adaptadorPaises = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        binding.list1.adapter = adaptadorPaises

        binding.list1.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val paisSeleccionado = parent.getItemAtPosition(position).toString()
            val poblacion = poblaciones[paisSeleccionado]
            binding.tv1.text = "Población de $paisSeleccionado: $poblacion"
        }
    }
}
