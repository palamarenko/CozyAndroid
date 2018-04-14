package ua.android.cozy.cozyandroid.recycler.implementation;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import ua.android.cozy.cozyandroid.get.Get;
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder;

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 23:07
 *
 * SuperSimpleRecyclerAdapter use only when your viewHolder don't need any additional dependence in constructor
 *
 */

public class SuperSimpleRecyclerAdapter<T> extends SimpleRecyclerAdapter<T> {

    private Class<? extends BaseViewHolder<T>> viewHolder;
    private Get<T> onClickListener;

    public SuperSimpleRecyclerAdapter(List<T> list, Class<? extends BaseViewHolder<T>> viewHolder) {
        super(list);
        this.viewHolder = viewHolder;
    }


    @Override
    public BaseViewHolder<T> getViewHolder(ViewGroup parent) {
        try {
            return viewHolder.getDeclaredConstructor(ViewGroup.class).newInstance(parent);
        } catch (Exception ignored) {
            throw new IllegalStateException("set only default constructor");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        super.onBindViewHolder(holder, position);
        if(onClickListener !=null){
            holder.itemClick(()-> onClickListener.get(getList().get(position)));
        }
    }

    public SuperSimpleRecyclerAdapter setOnClickListener(Get<T> onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }
}
