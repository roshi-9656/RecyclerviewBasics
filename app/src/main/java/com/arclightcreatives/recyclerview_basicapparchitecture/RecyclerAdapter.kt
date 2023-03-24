package com.arclightcreatives.recyclerview_basicapparchitecture

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arclightcreatives.recyclerview_basicapparchitecture.databinding.RecyclerrowBinding

class RecyclerAdapter(private var items: ArrayList<RepoModel>) :
    RecyclerView.Adapter<RecyclerAdapter.Viewholder>() {

    class Viewholder(private var binding: RecyclerrowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repoModel: RepoModel) {
            binding.repomodel = repoModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RecyclerrowBinding.inflate(layoutInflater, parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int {
        println("items = ${items.size}")
        return items.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(items[position])
    }

    fun replace(itemlist: ArrayList<RepoModel>){
        items = itemlist
        notifyDataSetChanged()
    }

}