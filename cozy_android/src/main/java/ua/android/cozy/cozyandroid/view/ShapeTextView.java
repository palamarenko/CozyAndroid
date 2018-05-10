package ua.android.cozy.cozyandroid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import ua.android.cozy.cozyandroid.R;
import ua.android.cozy.cozyandroid.view.base.ShapeDrawableFactory;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 22:09
 */

public class ShapeTextView extends android.support.v7.widget.AppCompatTextView {

    private ShapeDrawableFactory drawable;

    public ShapeTextView(Context context) {
        super(context);
        init(null);
    }

    public ShapeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public ShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }


    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.ShapeTextView);
            drawable = getViewShapeDrawable(arr);
            arr.recycle();
        } else {
            drawable = new ShapeDrawableFactory();
        }
    }


    private ShapeDrawableFactory getViewShapeDrawable(TypedArray arr) {
        ShapeDrawableFactory drawable = new ShapeDrawableFactory();
        drawable.setShape(ShapeDrawableFactory.SHAPE.values()[arr.getInt(R.styleable.ShapeTextView_back_shape, 0)]);
        String colorBack = arr.getString(R.styleable.ShapeTextView_back_shape_color);
        if (colorBack != null) {
            drawable.setColorBack(Color.parseColor(colorBack));
        }
        String startColor = arr.getString(R.styleable.ShapeTextView_gradient_start_color);
        if (startColor != null) {
            drawable.setStartColor(Color.parseColor(startColor));
        }
        String endColor = arr.getString(R.styleable.ShapeTextView_gradient_end_color);
        if (endColor != null) {
            drawable.setEndColor(Color.parseColor(endColor));
        }
        int radius = arr.getDimensionPixelSize(R.styleable.ShapeTextView_corners_radius, -1);

        if (radius >= 0) {
            drawable.setRadius(radius);
        }
        boolean border = arr.getBoolean(R.styleable.ShapeTextView_back_shape_border, false);
        drawable.setBorder(border);

        int borderWidth = arr.getDimensionPixelOffset(R.styleable.ShapeTextView_back_shape_border_width, 0);
        if (borderWidth > 0) {
            drawable.setBorderWidth(borderWidth);
        }
        int gradientDirection = arr.getInt(R.styleable.ShapeTextView_gradient_direction, 0);
        drawable.setGradientDirection(gradientDirection);
        return drawable;
    }


    public void setShape(ShapeDrawableFactory.SHAPE shape) {
        drawable.setShape(shape);
        setBackground(drawable.getDrawable());
    }

    public void setShapeColor(@ColorInt int color) {
        drawable.setColorBack(color);
        setBackground(drawable.getDrawable());
    }

    public void setShapeColorFromRes(@ColorRes int color) {
        drawable.setColorBack(ContextCompat.getColor(getContext(), color));
        drawable.setStartColor(null);
        drawable.setEndColor(null);
        setBackground(drawable.getDrawable());
    }


    public void setShapeGradient(@ColorInt int colorStart, @ColorInt int colorEnd) {
        drawable.setStartColor(colorStart);
        drawable.setEndColor(colorEnd);
        setBackground(drawable.getDrawable());
    }


    public void setBorder(boolean needBorder) {
        drawable.setBorder(needBorder);
        setBackground(drawable.getDrawable());
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        drawable.setWidth(w);
        drawable.setHeight(h);
        super.onSizeChanged(w, h, oldw, oldh);
        setBackground(drawable.getDrawable());
    }


}
