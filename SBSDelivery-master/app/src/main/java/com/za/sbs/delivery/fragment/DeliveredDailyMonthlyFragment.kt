package com.za.sbs.delivery.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.za.sbs.delivery.R
import kotlinx.android.synthetic.main.fragment_delivered_daily_monthly.*

private const val ARG_PARAM = "param"


class DeliveredDailyMonthlyFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_delivered_daily_monthly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        date_delivered_list.background = resources.getDrawable(R.drawable.round_bg_top_white_10dp)

        date_delivered_list.setOnClickListener {

            date_delivered_list.background = resources.getDrawable(R.drawable.round_bg_top_white_10dp)
            month_layout.visibility = View.GONE
            date_layout.visibility = View.VISIBLE
            month_delivered_list.background = resources.getDrawable(R.drawable.round_bg_white_pale_10dp)

        }

        month_delivered_list.setOnClickListener {

            month_delivered_list.background = resources.getDrawable(R.drawable.round_bg_top_white_10dp)
            month_layout.visibility = View.VISIBLE
            date_layout.visibility = View.GONE
            date_delivered_list.background = resources.getDrawable(R.drawable.round_bg_white_pale_10dp)
        }

    }


    companion object {

        @JvmStatic
        fun newInstance(param: String) =
            DeliveredDailyMonthlyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, param)
                }
            }
    }
}
