package com.za.sbs.delivery.fragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder

import com.za.sbs.delivery.R
import com.za.sbs.delivery.activities.DetailProgressDeliveryActivity
import com.za.sbs.delivery.utils.ViewUtil
import kotlinx.android.synthetic.main.fragment_progress_deliver.*

private const val ARG_PARAM = "param"

class ProgressDeliverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getString(ARG_PARAM)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress_deliver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_tracking_code.hint = ViewUtil.getString(context,R.string.search_tracking_code)

        scan_btn.setOnClickListener {

            if (ContextCompat.checkSelfPermission(context!!, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity!!,
                    arrayOf(Manifest.permission.CAMERA), 1)
            }
            else {

                startScan()

            }

        }

        upper.setOnClickListener {

            var intent = Intent(context,DetailProgressDeliveryActivity::class.java)
            startActivity(intent)
        }

        lower.setOnClickListener {
            var intent = Intent(context,DetailProgressDeliveryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startScan() {

        val materialBarcodeScanner = MaterialBarcodeScannerBuilder()
            .withActivity(activity!!)
            .withEnableAutoFocus(true)
            .withBleepEnabled(true)
            .withBackfacingCamera()
            .withText("Launching Scan")
            .withResultListener {

                var code = it!!.rawValue
                Log.e("ResultCode", code)
//                searchTrackingcode(code, true)
            }
            .build()

        materialBarcodeScanner.startScan()

    }

    companion object {

        @JvmStatic
        fun newInstance(param: String) =
            ProgressDeliverFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, param)
                }
            }
    }
}
