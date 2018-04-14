package ua.android.cozy.cozyandroid.recycler.base;

import java.util.List;

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 22:50
 */

public interface BaseRecyclerAdapter<T> {

    void updateList(List<T> list);
    void removeItem(int position);
    void removeItem(T t);
    void addItem(T t, int position);
    void notifyDataSetChanged();
    List<T> getList();
    int getItemCount();
}
