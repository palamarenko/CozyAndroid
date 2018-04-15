package ua.android.cozy.cozyandroid.mvp.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.android.cozy.cozyandroid.mvp.BasePresenter;
import ua.android.cozy.cozyandroid.mvp.BaseView;
import ua.android.cozy.cozyandroid.navigator.Navigator;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 11:51
 */

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {


    private Unbinder unbinder;
    private View view;


    /**
     * @return fragments layout id
     */

    @LayoutRes
    protected abstract int getLayout();

    /**
     * This method call when all view is bind
     */

    protected abstract void onCreate();

    /**
     * This method call when fragment view again
     */

    public void reloadScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            reloadScreen();
            return view;
        }
        view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        onCreate();
        return view;
    }

    /**
     * get FragmentNavigator from Activity
     */

    protected Navigator getNavigator() {
        if (getActivity() instanceof NavigateActivity) {
            NavigateActivity activity = (NavigateActivity) (getActivity());
            return activity.getNavigator();
        } else {
            throw new RuntimeException(new Throwable("Parent activity can't be cast to NavigateActivity"));
        }
    }

    public BaseFragment setArgumentString(String key, String value) {
        if (getArguments() == null) {
            setArguments(new Bundle());
        }

        getArguments().putString(key, value);
        return this;
    }

    public String getArgumentString(String key) {
        if (getArguments() != null) {
            return getArguments().getString(key);
        } else {
            return null;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    @Override
    public void showMessage(int id) {
        Toast.makeText(getContext(), id, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
