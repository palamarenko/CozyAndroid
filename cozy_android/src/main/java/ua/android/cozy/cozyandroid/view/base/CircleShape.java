package ua.android.cozy.cozyandroid.view.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 22:33
 */

public class CircleShape extends RectShape {

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float margin = paint.getStrokeWidth() / 2;
        RectF rectF = new RectF(rect().left + margin, rect().top + margin, rect().right - margin, rect().bottom - margin);
        canvas.drawOval(rectF,paint);
    }
}
