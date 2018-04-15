package ua.android.cozy.cozyandroid.recycler.item;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:46
 *
 * This interface need implement for data list for ItemRecyclerAdapter
 */

public interface RecyclerItem {
    /**
     * @return viewType for choice properly ViewHolder
     */

    int getViewType();

    /**
     * @return data object for binding ViewHolder, this object receives ViewHolder in method bindView(T t)
     */

    Object getItem();
}
