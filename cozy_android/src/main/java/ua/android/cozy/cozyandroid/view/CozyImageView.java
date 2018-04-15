package ua.android.cozy.cozyandroid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;

import ua.android.cozy.cozyandroid.R;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 18:02
 * <p>
 * CozyImageView xml params:
 * back_shape: Circle, Rectangle, RoundRect (additional: corners_radius)
 * back_shape_color: default back
 */

public class CozyImageView extends android.support.v7.widget.AppCompatImageView {


    public CozyImageView(Context context) {
        super(context);
    }

    public CozyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomAttributes(attrs);
    }

    public CozyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomAttributes(attrs);
    }


    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.CozyImageView);
        drawShapeBack(arr);

        arr.recycle();
    }


    private void drawShapeBack(TypedArray arr) {
        int shape = arr.getInt(R.styleable.CozyImageView_back_shape, 0);
        String colorBack = arr.getString(R.styleable.CozyImageView_back_shape_color);
        int radius = arr.getDimensionPixelSize(R.styleable.CozyImageView_corners_radius, 0);
        drawBack(colorBack, shape, radius);
    }


    public void drawBack(String color, int shape, int radius) {
        RectShape rectShape = null;
        switch (shape) {
            case 1:
                rectShape = new OvalShape();
                break;
            case 2:
                rectShape = new RectShape();
                break;
            case 3:
                float[] R = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
                rectShape = new RoundRectShape(R, null, null);
                break;
        }

        if (rectShape == null) {
            return;
        }
        int colorRes = color == null ? Color.BLACK : Color.parseColor(color);

        ShapeDrawable circle = new ShapeDrawable(rectShape);
        circle.getPaint().setColor(colorRes);
        setBackground(circle);
    }

}
