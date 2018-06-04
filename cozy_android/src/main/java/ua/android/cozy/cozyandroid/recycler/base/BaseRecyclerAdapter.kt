package ua.android.cozy.cozyandroid.recycler.base

import android.support.v7.widget.RecyclerView

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 22:50
 *
 * @param <T> - item in recyclerAdapter
</T> */

interface BaseRecyclerAdapter<T> {

    /**
     * data list
     */

    val list: List<T>

    /**
     * adapter size
     */

    val adapterSize: Int

    /**
     * if BaseRecyclerAdapter api don't not enough use this method to get RecyclerView.Adapter
     */

    val realAdapter: RecyclerView.Adapter<*>

    /**
     * method for update list
     * this method call notifyDataSetChanged()
     */

    fun updateList(list: List<T>?)

    /**
     * remove item by position
     * this method call notifyDataSetChanged()
     */

    fun removeItem(position: Int)

    /**
     * remove item by hashCode
     * this method call notifyDataSetChanged()
     */

    fun removeItem(t: T?)

    /**
     * add item for position
     * this method call notifyDataSetChanged()
     */

    fun addItem(t: T?, position: Int)

    /**
     * add item
     * this method call notifyDataSetChanged()
     */

    fun addItem(t: T?)

    /**
     * update item by position
     * this method call notifyDataSetChanged()
     */

    fun updateItem(t: T?, position: Int)

    /**
     * update item by hashCode
     * this method call notifyDataSetChanged()
     */

    fun updateItem(t: T?)


    /**
     * Update adapter
     */

    fun notifyDataSetChanged()


    /**
     * Use this method in baseViewHolder for get data from adapter
     */


    fun getDataFromAdapter(): Any? {
       return null
    }

    /**
     * Use this method if need save data for adapter
     */

    fun setDataForAdapter(o: Any){

    }
}
