package com.example.assigtwofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.util.Log
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_setting.view.*

class SettingFragment : Fragment() {

    lateinit var settingFragmentListener : SettingFragmentListener
    val TAG = "ActivitySettingFragment"

    interface SettingFragmentListener {
        fun nameEntry()
        fun cactiCheckBox()
        fun appleTreeCheckBox()
        fun rosesSwitch()
        fun grassSwitch()
        fun submitButtonClick()
    }

    override fun onAttach(context: Context) {
        Log.d(TAG,"onAttach")
        settingFragmentListener = context as SettingFragmentListener
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"onCreateView")
        val view: View = inflater.inflate(R.layout.fragment_setting, container, false)

        view.submitButton.setOnClickListener {
            Log.d(TAG, "Button clicked")
            settingFragmentListener.nameEntry()
            settingFragmentListener.cactiCheckBox()
            settingFragmentListener.appleTreeCheckBox()
            settingFragmentListener.rosesSwitch()
            settingFragmentListener.grassSwitch()
            settingFragmentListener.submitButtonClick()
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
