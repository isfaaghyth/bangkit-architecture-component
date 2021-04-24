package app.bangkit.architecturecomponent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bangkit.architecturecomponent.dispatcher.CoroutineDispatchers
import app.bangkit.architecturecomponent.model.GetVolumeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val volumeModel: GetVolumeModel,
    private val dispatchers: CoroutineDispatchers
) : ViewModel() {

    private var _result = MutableLiveData<Double>()
    val result: LiveData<Double> get() = _result

    fun calculate(width: Double, height: Double, length: Double) {
        viewModelScope.launch(dispatchers.io()) {
            val resultVolume = volumeModel.getVolume(width, height, length)

            withContext(dispatchers.main()) {
                _result.value = resultVolume
            }
        }
    }

}