package ua.android.cozy.cozyandroid

import android.view.ViewGroup
import android.view.ViewParent
import kotlinx.android.synthetic.main.item_test.view.*
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder
import ua.android.cozy.cozyandroid.viewlayer.BaseViewModel

class ViewHolder(parent: ViewGroup) : BaseViewHolder<String>(parent, R.layout.item_test) {


    override fun bindData(data: String) {
        itemView.text.text = data
    }
}

