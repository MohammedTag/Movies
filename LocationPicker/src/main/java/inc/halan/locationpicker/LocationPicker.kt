package inc.halan.locationpicker

import android.content.Intent
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.model.LatLng
import inc.halan.locationpicker.models.OperationMode

object LocationPicker {

    fun Fragment.navigateToMapsActivity(mode: OperationMode) {
       // val mapsActivity = MapsActivity(mode)

        val intent = Intent(requireContext(), MapsActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}