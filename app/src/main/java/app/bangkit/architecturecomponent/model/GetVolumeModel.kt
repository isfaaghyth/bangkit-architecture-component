package app.bangkit.architecturecomponent.model

class GetVolumeModel {

    fun getVolume(width: Double, height: Double, length: Double): Double {
        return width * height * length
    }

}