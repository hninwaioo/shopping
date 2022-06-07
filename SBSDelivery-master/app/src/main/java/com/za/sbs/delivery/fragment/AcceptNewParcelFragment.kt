package com.za.sbs.delivery.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.za.sbs.delivery.R
import com.za.sbs.delivery.activities.FillSenderInfoActivity
import kotlinx.android.synthetic.main.fragment_accept_new_parcel.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM = "param"

class AcceptNewParcelFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_accept_new_parcel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accept_new_parcel.setOnClickListener {
            var intent = Intent(context,FillSenderInfoActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(param: String) =
            AcceptNewParcelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, param)
                }
            }
    }
}
