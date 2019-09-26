package com.example.assigtwofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch


class MainActivity : AppCompatActivity(), SettingFragment.SettingFragmentListener, DisplayFragment.DisplayFragmentListener {

    val TAG = "Activity"

    val manager = supportFragmentManager

    var nameEntry = ""
    var cactiCheckBoxEntry = false
    var appleTreeCheckBoxEntry = false
    var rosesSwitchEntry = false
    var grassSwitchEntry = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initial view of SettingFragment
        showSettingFragment()
    }

    override fun submitButtonClick() {
        Log.d(TAG, "Button Click registered")
        setDisplaySetting()
        //showDisplayFragment()
    }

    override fun nameEntry() {
        Log.d(TAG, "nameEntry method")
        nameEntry = (findViewById(R.id.nameEntry) as EditText).text.toString()
    }

    override fun cactiCheckBox() {
        Log.d(TAG, "cactiCheckBox method")
        var cactiCheckBoxLocal = findViewById(R.id.cactiCheckBox) as CheckBox
        cactiCheckBoxEntry = cactiCheckBoxLocal.isChecked()
    }

    override fun appleTreeCheckBox() {
        Log.d(TAG, "appleTreeCheckBox method")
        var appleTreeCheckBoxLocal = findViewById(R.id.appleTreeCheckBox) as CheckBox
        appleTreeCheckBoxEntry = appleTreeCheckBoxLocal.isChecked()
    }

    override fun rosesSwitch() {
        Log.d(TAG, "rosesSwitch method")
        var rosesSwitchLocal = findViewById(R.id.rosesSwitch) as Switch
        rosesSwitchEntry = rosesSwitchLocal.isChecked()
    }

    override fun grassSwitch() {
        Log.d(TAG, "grassSwitch method")
        var grassSwitchLocal = findViewById(R.id.grassSwitch) as Switch
        grassSwitchEntry = grassSwitchLocal.isChecked()
    }

    override fun setDisplaySetting(){
        Log.d(TAG, "setDisplaySetting")
        var booleanArray = booleanArrayOf(cactiCheckBoxEntry,
            appleTreeCheckBoxEntry, rosesSwitchEntry, grassSwitchEntry)
        var displayFragment = DisplayFragment.newInstance(booleanArray, nameEntry)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, displayFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun showSettingFragment() {
        Log.d(TAG, "showSettingFragment")
        val transaction = manager.beginTransaction()
        val fragment = SettingFragment()

        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //currently using transaction in setDisplaySetting method
    fun showDisplayFragment() {
        Log.d(TAG, "showDisplayFragment")
        val transaction = manager.beginTransaction()
        val fragment = DisplayFragment()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
