package ua.android.cozy.cozyandroid.mvp.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.android.cozy.cozyandroid.mvp.BaseView;
import ua.android.cozy.cozyandroid.navigator.Navigator;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 22:43
 */

public abstract class BaseFullscreenDialog extends MvpAppCompatDialogFragment implements BaseView {

    private Unbinder unbinder;
    private View v;


    /**
     * @return fragments layout id
     */

    @LayoutRes
    protected abstract int getLayout();

    /**
     * This method call when all view is bind
     */

    protected abstract void onCreate();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        v = View.inflate(getContext(), getLayout(), null);
        unbinder = ButterKnife.bind(this, v);
        onCreate();
        return v;
    }


    protected void setCancelable() {
        v.setSoundEffectsEnabled(false);
        v.setOnClickListener(v1 -> dismiss());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if(window!=null){
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
    }


    @Override
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isDestroyed() && getFragmentManager() != null && isAdded()) {
                super.dismiss();
            }
        } catch (Exception ignored) {
        }

    }


    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}


    @Override
    public void showMessage(int message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

    protected Navigator getNavigator() {
        if (getActivity() instanceof NavigateActivity) {
            NavigateActivity activity = (NavigateActivity) (getActivity());
            return activity.getNavigator();
        } else {
            throw new RuntimeException(new Throwable("Parent activity can't be cast to NavigateActivity"));
        }
    }
}
