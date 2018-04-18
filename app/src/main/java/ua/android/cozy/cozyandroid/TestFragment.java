package ua.android.cozy.cozyandroid;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import ua.android.cozy.cozyandroid.mvp.ui.BaseFragment;
import ua.android.cozy.cozyandroid.view.ShapeImageView;
import ua.android.cozy.cozyandroid.view.ShapeTextView;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 13:22
 */

public class TestFragment extends BaseFragment {

    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.text_2)
    TextView textView2;
    @BindView(R.id.ShapeImageView)
    ShapeTextView view;



    public static BaseFragment newInstance() {
       return new TestFragment()
               .setArgumentString("HELLO","HELLO")
               .setArgumentString("BAY","BAY");
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected void onCreate() {
        textView.setText(getArgumentString("HELLO"));
        textView2.setText(getArgumentString("BAY"));
    }

    @OnClick(R.id.button)
    public void click(){}
}
