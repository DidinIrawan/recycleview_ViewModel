package com.exercise_recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class LanguageRecycleAdapter(private val languageList: MutableList<String>): RecyclerView.Adapter<LanguageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.orderNumber.text = position.toString()
        holder.languageName.text = languageList[position]
//        holder.itemView.setOnClickListener(holder)
//        holder.itemView.setOnClickListener(View.OnClickListener {
//            languageList.removeAt(position) // remove the item from list
//            notifyItemRemoved(position) // notify the adapter about the removed item
//        })
    }
}
class LanguageViewHolder(v:View): RecyclerView.ViewHolder(v){//, View.OnClickListener
    val orderNumber = v.findViewById<TextView>(R.id.order_number)
    val languageName = v.findViewById<TextView>(R.id.language_name)


//    override fun onClick(v: View?) {
//        if (v != null) {
//            Toast.makeText(v.context, "${languageName.text}",Toast.LENGTH_SHORT).show()
//        }
////        Toast.makeText(p0?.context, "${languageName.text}",Toast.LENGTH_LONG).show()
//    }
}