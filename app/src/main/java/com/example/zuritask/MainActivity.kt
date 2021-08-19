package com.example.zuritask

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.zuritask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submit.setOnClickListener {
            binding.viewName.text = binding.txtName.editText?.text.toString()
            binding.viewSlackname.text = binding.slackName.editText?.text.toString()
            binding.viewDescription.text = binding.description.editText?.text.toString()
            binding.result.visibility = View.VISIBLE
            closeSoftKeyboard(this, binding.description)
        }

    }

    private fun closeSoftKeyboard(context: Context, v: View) {
        val iMm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        iMm.hideSoftInputFromWindow(v.windowToken, 0)
        v.clearFocus()
    }
}