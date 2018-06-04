package ua.android.cozy.cozyandroid.recycler.base

import android.support.v7.util.DiffUtil

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 23:01
 */

class DiffUtilsBase(private val oldList: List<*>, private val newList: List<*>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]

    }
}
