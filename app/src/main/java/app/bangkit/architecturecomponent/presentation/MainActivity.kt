package app.bangkit.architecturecomponent.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.bangkit.architecturecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // instance the viewModel
        viewModel = ViewModelProvider(
            this,
                MainViewModelFactory(applicationContext)
        ).get(MainViewModel::class.java)

        // observe the data of users
        viewModel.getAllUsers().observe(this, Observer { userResponse ->
            var user = ""

            userResponse.forEach {
                user += it.firstName + " " + it.lastName + "\n"
            }

            binding?.txtNames?.text = user
        })

        binding?.btnInsert?.setOnClickListener {
            val firstName = binding?.edtFirstName?.text.toString()
            val lastName = binding?.edtLastName?.text.toString()

            viewModel.insert(firstName, lastName)
        }
    }

}