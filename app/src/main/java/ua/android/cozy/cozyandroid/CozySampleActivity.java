package ua.android.cozy.cozyandroid;

import android.os.Bundle;

import ua.android.cozy.cozyandroid.viewlayer.NavigateActivity;

public class CozySampleActivity extends NavigateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleInit();
        getNavigator().replaceFragment(new TestFragment()
                .setArgumentString("HELLO","HELLO")

        );
    }
}
