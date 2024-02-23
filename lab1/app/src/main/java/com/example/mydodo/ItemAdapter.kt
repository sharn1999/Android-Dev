package com.example.mydodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydodo.templates.PizzaItem

class ItemAdapter(private val items: List<PizzaItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(), Filterable {
    private var itemsFiltered = items

    interface OnItemClickListener {
        fun onItemClick(item: PizzaItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_pizza_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsFiltered[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
        holder.title.text = item.title
        holder.description.text = item.description
        holder.image.setImageResource(item.image)
        holder.price.text = "от " + item.price.toString() + " KZT"
    }

    override fun getItemCount(): Int = itemsFiltered.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvName)
        val description: TextView = view.findViewById(R.id.tvDescription)
        val image: ImageView = view.findViewById(R.id.ivImg)
        val price: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList: List<PizzaItem> = if (constraint == null || constraint.isEmpty()) {
                    items
                } else {
                    val filteredResults = items.filter {
                        it.title.contains(constraint, ignoreCase = true)
                    }
                    filteredResults
                }

                return FilterResults().apply { values = filteredList }
            }

            @SuppressWarnings("unchecked")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemsFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as List<PizzaItem>
                notifyDataSetChanged()
            }
        }
    }
}