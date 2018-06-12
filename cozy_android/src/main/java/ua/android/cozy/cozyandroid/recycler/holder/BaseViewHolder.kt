package ua.android.cozy.cozyandroid.recycler.holder

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter
import ua.android.cozy.cozyandroid.utils.Utils

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:46
 */

abstract class BaseViewHolder<T>(val parent: ViewGroup, @LayoutRes id: Int = 0) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(id,parent,false)) {

    protected val context: Context = itemView.context
    private val utils: Utils
    private val recyclerView: RecyclerView get() = parent as RecyclerView


    init {
        this.utils = Utils(context)
    }



    val adapter: BaseRecyclerAdapter<*>
        get() = if (recyclerView.adapter is BaseRecyclerAdapter<*>) {
            recyclerView.adapter as BaseRecyclerAdapter<*>
        } else {
            throw IllegalStateException("Use one of implementation of BaseRecyclerAdapter")
        }



    fun bind(o : Any) {
        try {
            val t = o as T
            bindData(t)
        } catch (ignore: ClassCastException) {
        }

    }



    fun itemClick(runnable: Runnable){
        itemView.setOnClickListener({runnable.run()})
    }


    protected abstract fun bindData(data: T)


}
