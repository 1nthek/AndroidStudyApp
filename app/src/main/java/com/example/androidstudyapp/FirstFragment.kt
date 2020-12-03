package com.example.androidstudyapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.androidstudyapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)
        binding.btnOpenActivity.setOnClickListener {
            //액티비티 전환
            Intent(activity, SecondActivity::class.java).also {
                startActivity(it)
            }

        }
        binding.buttonFirst.setOnClickListener {
            //fragment 전환
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btnRequestPermissions.setOnClickListener {
            requestPermissions()
        }

    }

    private fun hasWriteExternalStoragePermission() = activity?.let {
        ContextCompat.checkSelfPermission(it, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                .PERMISSION_GRANTED
    }

    private fun hasLocationForegroundPermission() = activity?.let {
        ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager
                .PERMISSION_GRANTED
    }

    private fun hasLocationBackgroundPermission() = activity?.let {
        ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager
                .PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission()!!) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationForegroundPermission()!!) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!hasLocationBackgroundPermission()!!) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if (permissionsToRequest.isNotEmpty()) {
            activity?.let { requestPermissions(permissionsToRequest.toTypedArray(), 0) }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //권한을 수락 혹은 거절 했을때 호출
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    //
                }
            }
        }
    }
}


























