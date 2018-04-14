package ua.android.cozy.cozyandroid.recycler.holder;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ua.android.cozy.cozyandroid.recycler.base.BaseRecyclerAdapter;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:46
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private Context context;
    private ViewGroup parent;

    public BaseViewHolder(ViewGroup parent, @LayoutRes int id) {
        super(LayoutInflater.from(parent.getContext()).inflate(id, parent, false));
        this.context = itemView.getContext();
        this.parent = parent;
        ButterKnife.bind(this, itemView);
    }

    public BaseRecyclerAdapter getAdapter() {

        if(getRecyclerView().getAdapter() instanceof BaseRecyclerAdapter){
            return (BaseRecyclerAdapter) getRecyclerView().getAdapter();
        }else {
            throw new IllegalStateException("Use one of implementation of BaseRecyclerAdapter");
        }

    }

    public RecyclerView getRecyclerView() {
        return (RecyclerView) parent;
    }


    protected Context getContext() {
        return context;
    }

    public void bind(Object object) {
        try {
            T t = (T) object;
            bindData(t);
        } catch (ClassCastException ignore) {
        }

    }

    protected abstract void bindData(T data);

    public void itemClick(Runnable runnable) {
        itemView.setOnClickListener(v -> runnable.run());
    }


}
