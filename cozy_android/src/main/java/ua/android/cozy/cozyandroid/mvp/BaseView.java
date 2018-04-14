package ua.android.cozy.cozyandroid.mvp;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 11:54
 */

public interface BaseView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void showMessage(@StringRes int id);
    @StateStrategyType(SkipStrategy.class)
    void showMessage(String text);

    void showProgress();
    void hideProgress();

}
