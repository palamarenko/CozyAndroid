package ua.android.cozy.cozyandroid.view.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 22:57
 */

public class TriangleShape extends RectShape {

    private Path path = new Path();

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float margin = paint.getStrokeWidth() / 2;
        RectF rectF = new RectF(rect().left, rect().top + margin, rect().right, rect().bottom - margin);
        path.moveTo(rectF.left, rectF.bottom - margin);
        path.lineTo(rectF.centerX(), rectF.top);
        path.lineTo(rectF.right, rectF.bottom);
        path.lineTo(rectF.left, rectF.bottom);
        canvas.drawPath(path, paint);
    }
}
