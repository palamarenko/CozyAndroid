package ua.android.cozy.cozyandroid.navigator;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import io.reactivex.Completable;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 11:39
 */

public class Navigator {

    private int contId;
    private FragmentManager fragmentManager;

    public Navigator(int contId, FragmentManager fragmentManager) {
        this.contId = contId;
        this.fragmentManager = fragmentManager;
    }

    public int getContId() {
        return contId;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }


    public void showDialog(DialogFragment dialog){
        dialog.show(fragmentManager,"");
    }

    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, true);
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        Completable.fromAction(() -> {

            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(contId, fragment);

            if (addToBackStack) {
                ft.addToBackStack("");
            }
            ft.commitAllowingStateLoss();

        }).subscribe(() -> {}, throwable -> {});
    }

}
