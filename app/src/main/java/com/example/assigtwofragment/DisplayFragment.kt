package com.example.assigtwofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private val NM_DATA = "nameData"
private val ST_DATA = "settingData"

class DisplayFragment : Fragment() {

    private var nameEntry: String? = null
    private var settingData: BooleanArray? = null

    lateinit var displayFragmentListener : DisplayFragmentListener

    val TAG = "ActivityDisplayFragment"

    interface DisplayFragmentListener {
        fun setDisplaySetting()
    }

    companion object {
        fun newInstance(settingData: BooleanArray, nameData: String): DisplayFragment =
            DisplayFragment().apply {
                arguments = Bundle().apply {
                    putString(NM_DATA, nameData)
                    putBooleanArray(ST_DATA, settingData)
                }
            }
    }

    override fun onAttach(context: Context) {
        Log.d(TAG,"onAttach")
        displayFragmentListener = context as DisplayFragmentListener
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate")
        arguments?.let {
            Log.d(TAG, "arguments let")
            nameEntry = it.getString(NM_DATA)
            settingData = it.getBooleanArray(ST_DATA)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"onCreateView")
        val view: View = inflater.inflate(R.layout.fragment_display, container, false)

        view.findViewById<TextView>(R.id.textView).setText("$nameEntry these are your plants!")

        if (settingData!![0]) {
            var imageCacti = view.findViewById<ImageView>(R.id.image1)
            imageCacti.visibility = View.VISIBLE
        }
        if (settingData!![1]) {
            var imageAppleTree = view.findViewById<ImageView>(R.id.image2)
            imageAppleTree.visibility = View.VISIBLE
        }
        if (settingData!![2]) {
            var imageRoses = view.findViewById<ImageView>(R.id.image3)
            imageRoses.visibility = View.VISIBLE
        }
        if (settingData!![3]) {
            var imageGrass = view.findViewById<ImageView>(R.id.image4)
            imageGrass.visibility = View.VISIBLE
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG,"onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}