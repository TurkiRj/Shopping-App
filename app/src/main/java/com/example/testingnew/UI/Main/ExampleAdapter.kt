package com.example.testingnew.UI.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingnew.Model.Product
import com.example.testingnew.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(
    private val exampleList: List<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.example_item,
            parent, false
        )

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        Picasso.get().load(currentItem!!.image).into(holder.imageView)
        holder.textView1.text = currentItem!!.title
    }


    override fun getItemCount() = exampleList.size

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}