package ua.android.cozy.cozyandroid.recycler.base;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by Palamarenko Andrey on
 * 11.04.2018 23:01
 */

public class DiffUtilsBase extends DiffUtil.Callback {


    private List oldList;
    private List newList;


    public DiffUtilsBase(@NonNull List oldList,@NonNull List newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));

    }
}
