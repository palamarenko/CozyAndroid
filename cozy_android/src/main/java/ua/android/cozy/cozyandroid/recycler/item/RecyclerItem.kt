package ua.android.cozy.cozyandroid.recycler.item

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:46
 *
 * This interface need implement for data list for ItemRecyclerAdapter
 */

interface RecyclerItem {
    /**
     * @return viewType for choice properly ViewHolder
     */

    val viewType: Int

    /**
     * @return data object for binding ViewHolder, this object receives ViewHolder in method bindView(T t)
     */

    val item: Any
}
