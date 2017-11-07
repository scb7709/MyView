package com.myview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.myview.R;

/**
 * Created by abc on 2017/10/13.
 */
public class TestView extends View {
    Paint paint;
    int mColor;

    public TestView(Context context) {
        super(context);
        init();
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestView);
        mColor = typedArray.getColor(R.styleable.TestView_myview_color, Color.RED);
        typedArray.recycle();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);


        paint.setStrokeWidth(3);
        paint.setTextSize(40);
        paint.setColor(Color.RED);
        paint.setTextAlign(Paint.Align.LEFT);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int hight = canvas.getHeight();
        int width = canvas.getWidth();
        int R = Math.min(hight, width) / 2;
        // canvas.drawCircle(width / 2, hight / 2, R, paint);
        Rect bounds = new Rect();
        String testString = "迪丽热巴";
        paint.getTextBounds(testString, 0, testString.length(), bounds);
        canvas.drawText(testString, getMeasuredWidth() / 2 - bounds.width() / 2, getMeasuredHeight() / 2 + bounds.height() / 2, paint);
        //canvas.drawText("迪丽热巴", width / 2, hight / 2, paint);


    }
}
