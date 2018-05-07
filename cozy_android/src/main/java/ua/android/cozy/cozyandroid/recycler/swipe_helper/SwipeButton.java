package ua.android.cozy.cozyandroid.recycler.swipe_helper;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by Palamarenko Andrey on
 * 07.05.2018 14:38
 */

public abstract class SwipeButton {

    private RectF clickRegion;
    private int position;
    private int id;

    public SwipeButton(int id) {
        this.id = id;
    }

    public void draw(Canvas canvas, RectF rect, int pos){
        clickRegion = rect;
        position = pos;
        onDraw(canvas,rect,pos);
    }

    public RectF getClickRegion() {
        return clickRegion;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }


    abstract void onDraw(Canvas canvas, RectF rect, int pos);



    public boolean setClick(float x, float y) {
        if (clickRegion != null && clickRegion.contains(x, y)) {
            return true;
        }

        return false;
    }

}

