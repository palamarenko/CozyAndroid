package ua.android.cozy.cozyandroid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;

import ua.android.cozy.cozyandroid.R;

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 18:02
 * <p>
 * CozyImageView xml params:
 * back_shape: Circle, Rectangle, RoundRect (additional: corners_radius)
 * back_shape_color: default back
 * back_shape_border: if true use border instead fill shape (additional:back_shape_border_width = default 3px)
 * gradient_direction - vertical and horizontal
 * gradient_start_color, gradient_end_color - color for gradient
 */

public class ShapeView extends View {

    private AttributeSet arr;
    private int w;
    private int h;
    private int shape;
    private String colorBack;
    private String startColor;
    private String endColor;
    private int gradientDirection;
    private int radius;
    private boolean border;
    private int borderWidth;


    public ShapeView(Context context) {
        super(context);
    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        arr = attrs;
        setCustomAttributes(arr);

    }

    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        arr = attrs;
        setCustomAttributes(arr);

    }


    private void setCustomAttributes(AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.ShapeView);
        drawShapeBack(arr);
        arr.recycle();
    }


    private void drawShapeBack(TypedArray arr) {
        shape = arr.getInt(R.styleable.ShapeView_back_shape, 0);
        colorBack = arr.getString(R.styleable.ShapeView_back_shape_color);
        startColor = arr.getString(R.styleable.ShapeView_gradient_start_color);
        endColor = arr.getString(R.styleable.ShapeView_gradient_end_color);
        radius = arr.getDimensionPixelSize(R.styleable.ShapeView_corners_radius, 0);
        border = arr.getBoolean(R.styleable.ShapeView_back_shape_border, false);
        borderWidth = arr.getDimensionPixelOffset(R.styleable.ShapeView_back_shape_border_width, 3);
        gradientDirection = arr.getInt(R.styleable.ShapeView_gradient_direction, 0);
    }


    public Drawable drawBack(int shape, int radius, boolean border, int borderWidth) {
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
            return null;
        }

        ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);

        setColor(shapeDrawable.getPaint());

        if (border) {
            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable.getPaint().setStrokeWidth(borderWidth);
        }

        return shapeDrawable;
    }


    private void setColor(Paint paint) {

        if (startColor == null || endColor == null) {
            int colorRes = colorBack == null ? Color.BLACK : Color.parseColor(colorBack);
            paint.setColor(colorRes);
        } else {


            int startX = gradientDirection == 0 ? 0 : w / 2;
            int startY = gradientDirection == 0 ? h / 2 : 0;
            int endX = gradientDirection == 0 ? w : w / 2;
            int endY = gradientDirection == 0 ? h/2 : h;

            LinearGradient shader = new LinearGradient(startX, startY, endX, endY, Color.parseColor(startColor), Color.parseColor(endColor), Shader.TileMode.CLAMP);
            paint.setShader(shader);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = drawBack(shape, radius, border, borderWidth);
        int pixelBorder = border ? borderWidth / 2 : 0;
        drawable.setBounds(pixelBorder, pixelBorder, w - pixelBorder, h - pixelBorder);
        drawable.draw(canvas);
    }


    public int getShape() {
        return shape;
    }

    public ShapeView setShape(int shape) {
        this.shape = shape;
        invalidate();
        return this;
    }

    public String getColorBack() {
        return colorBack;
    }

    public ShapeView setColorBack(String colorBack) {
        this.colorBack = colorBack;
        invalidate();
        return this;
    }

    public String getStartColor() {
        return startColor;
    }

    public ShapeView setStartColor(String startColor) {
        this.startColor = startColor;
        invalidate();
        return this;
    }

    public String getEndColor() {
        return endColor;
    }

    public ShapeView setEndColor(String endColor) {
        this.endColor = endColor;
        invalidate();
        return this;
    }

    public int getGradientDirection() {
        return gradientDirection;
    }

    public ShapeView setGradientDirection(int gradientDirection) {
        this.gradientDirection = gradientDirection;
        invalidate();
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public ShapeView setRadius(int radius) {
        this.radius = radius;
        invalidate();
        return this;
    }

    public boolean isBorder() {
        return border;
    }

    public ShapeView setBorder(boolean border) {
        this.border = border;
        invalidate();
        return this;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public ShapeView setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        invalidate();
        return this;
    }
}
