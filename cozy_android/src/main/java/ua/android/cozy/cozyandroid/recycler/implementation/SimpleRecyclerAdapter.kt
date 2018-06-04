package ua.android.cozy.cozyandroid.recycler.implementation

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.nio.file.Path
import java.util.ArrayList

import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter
import ua.android.cozy.cozyandroid.recycler.base.DiffUtilsBase
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder


/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:51
 *
 *
 * SimpleRecyclerAdapter use only when your viewHolder  need additional dependence in constructor
 * use only for single viewHolder type
 */

abstract class SimpleRecyclerAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>, BaseRecyclerAdapter<T> {


    final override var list = ArrayList<T>()


    constructor()
    constructor(list: List<T>?) {
        if (list != null) {
            this.list.addAll(list)
        }
    }

    override fun getItemCount(): Int {
        return adapterSize
    }


    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(list[position] as Any)
    }


    override fun getItemId(position: Int): Long {
        return list[position]?.hashCode()?.toLong() ?: 0
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return getViewHolder(parent)
    }


    abstract fun getViewHolder(parent: ViewGroup): BaseViewHolder<T>

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
        if (this.list.size > position) {
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

    override fun addItem(t: T?, position: Int) {
        if (list.size > position && t != null) {
            this.list.add(position, t)
            notifyDataSetChanged()
        }
    }

    override val adapterSize: Int
        get() = list.size

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
