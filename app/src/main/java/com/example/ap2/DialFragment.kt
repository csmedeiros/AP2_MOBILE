package com.example.ap2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class DialFragment : Fragment() {

    private val phoneNumber = "21995049864"
    private val requestCode = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dial, container, false)

        val dialButton = view.findViewById<ImageButton>(R.id.button_dial)
        dialButton.setOnClickListener {
            if (isCallPermissionGranted()) {
                dialPhoneNumber()
            } else {
                requestCallPermission()
            }
        }

        return view
    }

    private fun isCallPermissionGranted(): Boolean {
        val permission = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED
        return ContextCompat.checkSelfPermission(requireContext(), permission) == granted
    }

    private fun requestCallPermission() {
        val permission = Manifest.permission.CALL_PHONE
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), requestCode)
    }

    private fun dialPhoneNumber() {
        val phoneNumberUri = Uri.parse("tel:$phoneNumber")
        val dialIntent = Intent(Intent.ACTION_CALL, phoneNumberUri)
        startActivity(dialIntent)
    }
}
