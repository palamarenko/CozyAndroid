package ua.android.cozy.cozyandroid.mvp;

import com.arellomobile.mvp.MvpPresenter;

import ua.android.cozy.cozyandroid.navigator.Navigator;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 13:03
 */

public class BasePresenter<T extends BaseView> extends MvpPresenter<T> {

    private Navigator navigator;


    public BasePresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}
