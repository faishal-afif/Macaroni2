package com.example.macaroni.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.macaroni.R
import com.example.macaroni.database.Menu
import com.example.macaroni.databinding.ItemListMenuBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.item_list_menu.view.*

class MenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val notes = arrayListOf<Menu>()

    inner class MenuViewHolder(private val view: ItemListMenuBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(menu: Menu) {
            view.tvItemName.text = menu.title
            view.tvItemDescription.text = menu.price
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ID, menu.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    var compositeDisposable = CompositeDisposable()

    var menus: List<Menu> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = menus.size

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        compositeDisposable.clear()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val menu = menus[position]
        holder.itemView.tv_item_name.text = menu.title
        // holder.itemView.imageFavorite.isChecked = cheese.favorite == 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_menu, parent, false))
        val view = ItemListMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

//    * FUNGSI UNTUK MENAMBAH DATA MENU
    fun menuList(data: List<Menu>) {
        notes.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }




}