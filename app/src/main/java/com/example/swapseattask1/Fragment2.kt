package com.example.swapseattask1

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.swapseattask1.databinding.Fragment2Binding
import com.google.android.material.slider.Slider
import java.io.File

@Suppress("NAME_SHADOWING")

class Fragment2 : Fragment() {

    var binding: Fragment2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment2Binding.inflate(layoutInflater)

        binding!!.rangeSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                binding!!.counter.text = slider.value.toInt().toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                binding!!.counter.text = slider.value.toInt().toString()
            }
        })

        binding!!.buttonImage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireContext() as Activity,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            } else {
                pickImageGallery()
            }
        }

        binding!!.addDocumentButton.setOnClickListener {
            selectPdf()
            binding!!.addDocumentButton.visibility = View.GONE
            binding!!.constLayDocBtn.visibility = View.VISIBLE
        }

        binding?.docDelete?.setOnClickListener {
            binding!!.addDocumentButton.visibility = View.VISIBLE
            binding!!.constLayDocBtn.visibility = View.GONE
        }

        return binding?.root
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 2)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2 && resultCode == RESULT_OK) {
            binding?.uploadImage?.setImageURI(data?.data)
        }

        if (requestCode == 3 && resultCode == RESULT_OK) {
            val data = data?.data
            if (data != null) {
                val sUri = data

                val fileName = File(sUri.path!!).name
                binding?.docTitle?.text = fileName

                val file = File(Uri.parse(data.path).path!!).length().div(1024)

                binding?.docSize?.text = "$file mb"
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val galleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 2)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun selectPdf() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 3)
        binding!!.addDocumentButton.visibility = View.INVISIBLE
        binding!!.constLayDocBtn.visibility = View.VISIBLE
    }

}