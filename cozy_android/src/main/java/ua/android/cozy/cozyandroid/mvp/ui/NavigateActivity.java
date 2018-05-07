package ua.android.cozy.cozyandroid.mvp.ui;

import android.support.v4.app.FragmentManager;
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


    @Override
    public void onBackPressed() {
        FragmentManager manager = getNavigator().getFragmentManager();
        int count = manager.getBackStackEntryCount();
        if (count == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
