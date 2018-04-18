package ua.android.cozy.cozyandroid.view.base;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 22:25
 */

public class RectShape extends Shape {
    private RectF mRect = new RectF();

    public RectShape() {}

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float margin = paint.getStrokeWidth() / 2;
        RectF rectF = new RectF(mRect.left + margin, mRect.top + margin, mRect.right - margin, mRect.bottom - margin);
        canvas.drawRect(rectF, paint);
    }



    @Override
    protected void onResize(float width, float height) {
        mRect.set(0, 0, width, height);
    }

    /**
     * Returns the RectF that defines this rectangle's bounds.
     */
    protected final RectF rect() {
        return mRect;
    }

}
