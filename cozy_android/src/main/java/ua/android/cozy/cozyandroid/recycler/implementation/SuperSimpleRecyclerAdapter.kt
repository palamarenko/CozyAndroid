package ua.android.cozy.cozyandroid.recycler.implementation

import android.view.ViewGroup
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 23:07
 *
 * SuperSimpleRecyclerAdapter use only when your viewHolder don't need any additional dependence in constructor
 *
 */

class SuperSimpleRecyclerAdapter<T>(list: List<T>, private val viewHolder: KClass<out BaseViewHolder<T>>) : SimpleRecyclerAdapter<T>(list) {

    private var onClick: ((T) -> Unit)? = null


    override fun getViewHolder(parent: ViewGroup): BaseViewHolder<T> {
        try {
            return viewHolder.primaryConstructor!!.call(parent)
        } catch (ignored: Exception) {
            throw IllegalStateException("set only default constructor")
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        super.onBindViewHolder(holder, position)
            holder.itemClick(Runnable {
                onClick?.invoke(list[position])
            })
    }


    fun setOnClickListener(onClick: (T) -> Unit) : SuperSimpleRecyclerAdapter<T>{
        this.onClick = onClick
        return this
    }




}
