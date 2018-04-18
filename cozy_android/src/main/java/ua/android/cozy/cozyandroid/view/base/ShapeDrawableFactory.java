package ua.android.cozy.cozyandroid.view.base;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 10:17
 */

public class ShapeDrawableFactory {
    public enum SHAPE {
        OVAL, RECTANGLE, ROUND_RECT, TRIANGLE
    }

    private int w = 100;
    private int h = 100;
    private SHAPE shape = SHAPE.RECTANGLE;
    private String colorBack = "#000000";
    private String startColor = null;
    private String endColor = null;
    private int gradientDirection = 0;
    private int radius = 10;
    private boolean border = false;
    private int borderWidth = 10;


    public Drawable getDrawable() {

        ShapeDrawable shapeDrawable = new ShapeDrawable(getShape(shape, radius));

        setColor(shapeDrawable.getPaint());

        if (border) {
            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable.getPaint().setStrokeWidth(borderWidth);
        }

        return shapeDrawable;
    }

    private RectShape getShape(SHAPE shape, int radius) {
        if (shape == null) {
            return new RectShape();
        }

        switch (shape) {
            case OVAL:
                return new OvalShape();
            case RECTANGLE:
                return new RectShape();
            case ROUND_RECT:
                float[] R = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
                return new RoundRectShape(R, null, null);
            case TRIANGLE:
                return new TriangleShape();
            default:
                return new RectShape();
        }
    }


    private void setColor(Paint paint) {

        if (startColor == null || endColor == null) {
            int colorRes = colorBack == null ? Color.BLACK : Color.parseColor(colorBack);
            paint.setColor(colorRes);
        } else {
            int startX = gradientDirection == 0 ? 0 : w / 2;
            int startY = gradientDirection == 0 ? h / 2 : 0;
            int endX = gradientDirection == 0 ? w : w / 2;
            int endY = gradientDirection == 0 ? h / 2 : h;

            LinearGradient shader = new LinearGradient(startX, startY, endX, endY, Color.parseColor(startColor), Color.parseColor(endColor), Shader.TileMode.CLAMP);
            paint.setShader(shader);
        }
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public SHAPE getShape() {
        return shape;
    }

    public void setShape(SHAPE shape) {
        this.shape = shape;
    }

    public String getColorBack() {
        return colorBack;
    }

    public void setColorBack(String colorBack) {
        this.colorBack = colorBack;
    }

    public String getStartColor() {
        return startColor;
    }

    public void setStartColor(String startColor) {
        this.startColor = startColor;
    }

    public String getEndColor() {
        return endColor;
    }

    public void setEndColor(String endColor) {
        this.endColor = endColor;
    }

    public int getGradientDirection() {
        return gradientDirection;
    }

    public void setGradientDirection(int gradientDirection) {
        this.gradientDirection = gradientDirection;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}
