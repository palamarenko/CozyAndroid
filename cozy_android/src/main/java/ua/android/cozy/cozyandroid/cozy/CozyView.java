package ua.android.cozy.cozyandroid.cozy;

import android.view.View;
import android.view.ViewTreeObserver;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 11:24
 */

public class CozyView {
    public static Single<View> getViewWithSize(View view) {
        PublishSubject<View> publishSubject = PublishSubject.create();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                publishSubject.onNext(view);
                publishSubject.onComplete();
            }
        });

        return publishSubject.singleOrError();
    }

    public static Single<Integer> getViewHeight(View view) {
        return getViewWithSize(view).map(View::getHeight);
    }

    public static Single<Integer> getViewWidth(View view) {
        return getViewWithSize(view).map(View::getWidth);
    }
}
