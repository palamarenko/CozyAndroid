package ua.android.cozy.cozyandroid.ui;

import android.view.View;
import android.widget.FrameLayout;

import ua.android.cozy.cozyandroid.navigator.Navigator;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 11:46
 */

public class NavigateActivity extends BaseActivity {

    private Navigator navigator;


    public void simpleInit(){
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(View.generateViewId());
        setContentView(frameLayout);
        navigator = new Navigator(frameLayout.getId(),getSupportFragmentManager());
    }


    public Navigator getNavigator() {
        return navigator;
    }
}
