package ua.android.cozy.cozyandroid.recycler.item;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 16:23
 */

public class SimpleItem implements RecyclerItem {

    private Object object;
    private int viewType;

    public SimpleItem(Object object, int viewType) {
        this.object = object;
        this.viewType = viewType;
    }

    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public Object getItem() {
        return object;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleItem that = (SimpleItem) o;

        if (viewType != that.viewType) return false;
        return object != null ? object.equals(that.object) : that.object == null;
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + viewType;
        return result;
    }
}
