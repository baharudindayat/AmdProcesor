package com.example.amdprocesor.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amdprocesor.DetailActivity
import com.example.amdprocesor.model.Model
import com.example.amdprocesor.R
import java.util.*

class ListProcAdapter(private val listProc: ArrayList<Model>) : RecyclerView.Adapter<ListProcAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_proc, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,specs ,description, photo) = listProc[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvSpecs.text = specs
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listProc[holder.adapterPosition])
        }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_proc", listProc[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listProc.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var tvSpecs: TextView = itemView.findViewById(R.id.tv_spec)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Model)
    }
}