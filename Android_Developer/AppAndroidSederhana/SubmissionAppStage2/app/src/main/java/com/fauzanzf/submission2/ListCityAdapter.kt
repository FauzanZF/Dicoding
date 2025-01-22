package com.fauzanzf.submission2

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCityAdapter(private val listCity: ArrayList<City>) : RecyclerView.Adapter<ListCityAdapter.ListViewHolder>() {
    private var selectedPosition = -1
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_city, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, pulau, umur, tahun, ibukota) = listCity[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description


        // Highlight item yang dipilih
        if (position == selectedPosition) {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, name)
            intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
            intent.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            intent.putExtra(DetailActivity.EXTRA_PULAU , pulau)
            intent.putExtra(DetailActivity.EXTRA_TAHUN , tahun)
            intent.putExtra(DetailActivity.EXTRA_UMUR , umur)
            intent.putExtra(DetailActivity.EXTRA_IBUKOTA , ibukota)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listCity.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: City)
    }
}
