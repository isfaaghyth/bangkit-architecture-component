package app.bangkit.architecturecomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.bangkit.architecturecomponent.databinding.ActivityMainBinding
import app.bangkit.architecturecomponent.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this)
                .get(MainViewModel::class.java)

        viewModel.result.observe(this, Observer { result ->
            binding?.txtResult?.text = result.toString()
        })

        binding?.btnCalculate?.setOnClickListener {
            val width = binding?.edtLebar?.text.toString().toDouble()
            val height = binding?.edtTinggi?.text.toString().toDouble()
            val length = binding?.edtPanjang?.text.toString().toDouble()

            viewModel.calculate(width, height, length)
        }
    }

}