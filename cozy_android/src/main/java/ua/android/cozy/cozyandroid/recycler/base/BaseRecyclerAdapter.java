package ua.android.cozy.cozyandroid.recycler.base;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 22:50
 *
 * @param <T> - item in recyclerAdapter
 */

public interface BaseRecyclerAdapter<T> {

    void updateList(@Nullable List<T> list);

    void removeItem(int position);

    void removeItem(@Nullable T t);

    void addItem(@Nullable T t, int position);

    void notifyDataSetChanged();

    List<T> getList();

    int getItemCount();


    Object getDataFromAdapter();

    RecyclerView.Adapter getRealAdapter();
}
