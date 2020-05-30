package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_hero.view.*
import java.security.AccessControlContext

class HeroAdapter internal constructor(private var context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView

    }

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = heroes.size


    private inner class ViewHolder internal constructor(private val view: View) {
        //        private val txtName: TextView = view.findViewById(R.id.txt_name)
////        private val txtDescription: TextView = view.findViewById(R.id.txt_Description)
////        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
////
////        internal fun bind(hero: Hero) {
////            txtName.text = hero.name
////            txtDescription.text = hero.description
////            imgPhoto.setImageResource(hero.photo)
////        }

        // dibawah adalah cara singkat dengan Memfaktor Ulang (Refactor) menggunakan Kotlin Android Extensions.
        fun bind(hero: Hero) {
            with(view) {
                txt_name.text = hero.name
                txt_Description.text = hero.description
                img_photo.setImageResource(hero.photo)
            }
        }
    }
}