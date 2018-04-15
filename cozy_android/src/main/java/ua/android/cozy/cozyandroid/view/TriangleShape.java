package ua.android.cozy.cozyandroid.view;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 22:57
 */

public class TriangleShape extends RectShape {

    private Path path = new Path();

    @Override
    public void draw(Canvas canvas, Paint paint) {

        RectF rectF = rect();
        path.moveTo(rectF.left,rectF.bottom);
        path.lineTo(rectF.centerX(),rectF.top);
        path.lineTo(rectF.right,rectF.bottom);
        path.lineTo(rectF.left,rectF.bottom);
        canvas.drawPath(path,paint);
    }


    @Override
    public OvalShape clone() throws CloneNotSupportedException {
        return (OvalShape) super.clone();
    }


}
