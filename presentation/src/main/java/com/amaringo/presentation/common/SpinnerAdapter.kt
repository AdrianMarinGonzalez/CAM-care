package com.amaringo.presentation.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.amaringo.presentation.R


class SpinnerAdapter(
    context: Context, textViewResourceId: Int,
    private val data: List<String>
) : ArrayAdapter<String>(context, textViewResourceId, data) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup) =
        when (position) {
            0 -> getCustomView(position, null, parent).apply {
                setBackgroundResource(R.drawable.spinner_top_item_background)
            }
            data.size - 1 -> getCustomView(position, null, parent).apply {
                setBackgroundResource(R.drawable.spinner_bottom_item_background)
            }
            else -> getCustomView(position, null, parent).apply {
                setBackgroundResource(R.drawable.spinner_mid_item_background)
            }
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup) =
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.layout_spinner, parent, false
        ).apply { findViewById<TextView>(R.id.listItem).text = data[position] }
}