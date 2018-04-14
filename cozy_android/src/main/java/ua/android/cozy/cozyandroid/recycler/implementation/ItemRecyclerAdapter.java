package ua.android.cozy.cozyandroid.recycler.implementation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ua.android.cozy.cozyandroid.recycler.base.BaseItem;
import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter;
import ua.android.cozy.cozyandroid.recycler.base.DiffUtilsBase;
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder;


/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:43
 *
 * ItemRecyclerAdapter use when your need create two or more different types of viewHolder
 * Use BaseItem for get viewType and model
 */

public abstract class ItemRecyclerAdapter<T extends BaseItem> extends RecyclerView.Adapter<BaseViewHolder> implements BaseRecyclerAdapter<T> {

    private List<T> list;

    public ItemRecyclerAdapter(@Nullable List<T> list) {
        this.list = new ArrayList<>();
        if (list != null) {
            this.list.addAll(list);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(list.get(position).getItem());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).hashCode();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getViewType();
    }

    @Override
    public void updateList(List<T> list) {
        if (list != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtilsBase(this.list, list));
            diffResult.dispatchUpdatesTo(this);
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public void removeItem(int position) {
        if (list.size() > position) {
            this.list.remove(position);
            notifyDataSetChanged();
        }

    }

    @Override
    public void removeItem(T t) {
        this.list.remove(t);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(T t, int position) {

        if (list.size() > position) {
            this.list.add(position, t);
        }
    }

    @Override
    public List<T> getList() {
        return list;
    }
}
