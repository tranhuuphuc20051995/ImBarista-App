package com.alexzh.imbarista.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alexzh.imbarista.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.fragment_google_map.view.*

class GoogleMapFragment : Fragment(), OnMapReadyCallback {

    lateinit var map: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_google_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        rootView.currentLocation.setOnClickListener {
            Toast.makeText(this.context, "current location -> clicked", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
    }
}