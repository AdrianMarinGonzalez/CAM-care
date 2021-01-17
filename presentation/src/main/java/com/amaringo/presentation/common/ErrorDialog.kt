package com.amaringo.presentation.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.amaringo.presentation.R
import com.amaringo.presentation.databinding.ErrorDialogLayoutBinding

class ErrorDialog(
    context: Context,
    private val message: String,
    private val fallback: Action?
) : Dialog(context) {

    var dataBinding: ErrorDialogLayoutBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.error_dialog_layout,
        null, false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(dataBinding.root)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dataBinding.message.text = message
        dataBinding.closeButton.setOnClickListener { fallback?.invoke(); dismiss() }
    }
}