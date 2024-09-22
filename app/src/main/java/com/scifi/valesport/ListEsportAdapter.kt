package com.scifi.valesport

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scifi.valesport.databinding.ItemRowEsportBinding

class ListEsportAdapter(private val listEsport: ArrayList<Esport>) : RecyclerView.Adapter<ListEsportAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowEsportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listEsport.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name, description, logo) = listEsport[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.binding.imgItemLogo)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("extra_esport", listEsport[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(var binding: ItemRowEsportBinding) : RecyclerView.ViewHolder(binding.root)
}