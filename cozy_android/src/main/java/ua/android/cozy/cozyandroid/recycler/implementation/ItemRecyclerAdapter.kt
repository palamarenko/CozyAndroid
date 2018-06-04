package ua.android.cozy.cozyandroid.recycler.implementation

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import ua.android.cozy.cozyandroid.recycler.item.RecyclerItem
import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter
import ua.android.cozy.cozyandroid.recycler.base.DiffUtilsBase
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder


/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:43
 *
 *
 * ItemRecyclerAdapter use when your need create two or more different types of viewHolder
 * Use RecyclerItem for get viewType and model
 */

abstract class ItemRecyclerAdapter<T : RecyclerItem> : RecyclerView.Adapter<BaseViewHolder<*>>, BaseRecyclerAdapter<T> {

     final override val list = ArrayList<T>()

    constructor()

    constructor(list: List<T>?) {
        if (list != null) {
            this.list.addAll(list)
        }
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.bind(list[position].item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }

    override fun updateList(list: List<T>?) {
        if (list != null) {
            val diffResult = DiffUtil.calculateDiff(DiffUtilsBase(this.list, list))
            diffResult.dispatchUpdatesTo(this)
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun removeItem(position: Int) {
        if (list.size > position) {
            this.list.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun removeItem(t: T?) {
        if (t != null) {
            this.list.remove(t)
            notifyDataSetChanged()
        }

    }

    override val adapterSize: Int
        get() = itemCount

    override fun addItem(t: T?, position: Int) {

        if (list.size > position && t != null) {
            this.list.add(position, t)
        }
    }


    override val realAdapter: RecyclerView.Adapter<*>
        get() = this


    override fun addItem(t: T?) {
        if (t != null) {
            list.add(t)
            notifyDataSetChanged()
        }

    }

    override fun updateItem(t: T?, position: Int) {
        if (t != null && position > 0 &&position < list.size){
            list[position] = t
            notifyDataSetChanged()
        }
    }

    override fun updateItem(t: T?) {
        if(t != null){
            list[list.indexOf(t)] = t
            notifyDataSetChanged()
        }
    }
}
