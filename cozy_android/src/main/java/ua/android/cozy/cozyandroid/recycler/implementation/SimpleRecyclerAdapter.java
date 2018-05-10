package ua.android.cozy.cozyandroid.recycler.implementation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter;
import ua.android.cozy.cozyandroid.recycler.base.DiffUtilsBase;
import ua.android.cozy.cozyandroid.recycler.holder.BaseViewHolder;


/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:51
 * <p>
 * SimpleRecyclerAdapter use only when your viewHolder  need additional dependence in constructor
 * use only for single viewHolder type
 */

public abstract class SimpleRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> implements BaseRecyclerAdapter<T> {

    private final List<T> list = new ArrayList<>();

    public SimpleRecyclerAdapter() {
    }

    public SimpleRecyclerAdapter(@Nullable List<T> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).hashCode();
    }


    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(parent);
    }


    public abstract BaseViewHolder<T> getViewHolder(ViewGroup parent);

    @Override
    public void updateList(@Nullable List<T> list) {
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
        if (this.list.size() > position) {
            this.list.remove(position);
            notifyDataSetChanged();
        }

    }

    @Override
    public void removeItem(@Nullable T t) {
        if (t != null) {
            this.list.remove(t);
            notifyDataSetChanged();
        }

    }

    @Override
    public void addItem(@Nullable T t, int position) {
        if (list.size() > position && t != null) {
            this.list.add(position, t);
            notifyDataSetChanged();
        }
    }

    @Override
    public List<T> getList() {
        return list;
    }


    @Override
    public RecyclerView.Adapter getRealAdapter() {
        return this;
    }

    @Override
    public Object getDataFromAdapter() {
        return null;
    }

    @Override
    public void setDataForAdapter(Object o) {
    }



}
