package app.bangkit.architecturecomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.bangkit.architecturecomponent.data.AppDatabase
import app.bangkit.architecturecomponent.data.repository.UserLocalRepository
import app.bangkit.architecturecomponent.databinding.ActivityMainBinding
import app.bangkit.architecturecomponent.viewmodel.MainViewModel
import app.bangkit.architecturecomponent.viewmodel.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val userDao by lazy {
        AppDatabase.instance(applicationContext).userDao()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val repository = UserLocalRepository(userDao)
        val factory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(
            this,
            factory
        ).get(MainViewModel::class.java)

        viewModel.getAllUsers().observe(this, Observer {
            binding?.txtNames?.text = ""
            var users = ""

            if (it != null) {
                it.forEach {  user ->
                    users += user.firstName + " " + user.lastName + "\n"
                }

                binding?.txtNames?.text = users
            }
        })

        binding?.btnInsert?.setOnClickListener {
            val firstName = binding?.edtFirstName?.text.toString()
            val lastName = binding?.edtLastName?.text.toString()

            viewModel.insert(firstName, lastName)
        }
    }

}