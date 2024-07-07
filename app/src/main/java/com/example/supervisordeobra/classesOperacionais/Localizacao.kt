package com.example.supervisordeobra.classesOperacionais


import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.location.Granularity
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.Priority
import com.google.android.gms.location.SettingsClient
import java.util.Calendar.getInstance
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.LocationCallback


open class Localizacao(val updateLocalizacao: (Double, Double) -> Unit){
    var latitude = 0.0
    var longitude = 0.0

    fun captarLocalizacao( contexto: Context) {

        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(contexto)
        when (resultCode) {
            1 -> ConnectionResult.SERVICE_MISSING
            2 -> ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED
            3 -> ConnectionResult.SERVICE_DISABLED

            else -> {
                Log.d("Teste", "Google Play Service Atualizado")
            }
        }
        if (ActivityCompat.checkSelfPermission(
                contexto,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                contexto,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val provedorClienteLocalizacao = LocationServices.getFusedLocationProviderClient(contexto)

        val timeInterval = (5000)
        var locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            timeInterval.toLong()).apply {
            setDurationMillis(Long.MAX_VALUE)
            setMinUpdateIntervalMillis(1000)
            setGranularity(Granularity.GRANULARITY_PERMISSION_LEVEL)
            setWaitForAccurateLocation(true)
        }.build()

        val locationSettingsRequest = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)

        val settingsClient: SettingsClient = LocationServices.getSettingsClient(contexto)
        settingsClient.checkLocationSettings(locationSettingsRequest.build())

            .addOnSuccessListener() {
                Log.i("Teste", it.locationSettingsStates.toString())
            }
            .addOnFailureListener {
                    exception ->
                Log.d("Location", "Oops location failed with exception: $exception")
            }
        val locationCallback = object : LocationCallback(){
            override fun onLocationResult(result: LocationResult) {
                super.onLocationResult(result)
                result.locations.lastOrNull()?.let {location ->
                    latitude = location.latitude
                    longitude = location.longitude
                    updateLocalizacao(latitude, longitude)
                }
            }
        }
        provedorClienteLocalizacao.requestLocationUpdates(locationRequest, locationCallback, null)

    }
}