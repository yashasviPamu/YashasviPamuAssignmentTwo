package com.example.yashasvipamuassignmenttwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class drawing extends View {
    Path p;
    Paint paint;
    Boolean b=true;
    Bitmap bitmap_light;
    Bitmap bitmap_dark;
    int draw_dark=R.drawable.ic_autorenew_black_24dp;
    int draw_light=R.drawable.ic_autorenew_black_lightdp;

    public drawing(Context context) {
        super(context);
        paint=new Paint();
        bitmap_light=getBitFromVector(context,draw_light);
        bitmap_dark=getBitFromVector(context,draw_dark);
        p=new Path();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(25f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 100;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        setMeasuredDimension(width, 1000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
        canvas.drawPath(p,paint);
        if(b)
        {
            canvas.drawBitmap(bitmap_dark,10,10,paint);
        }
        else {
            canvas.drawBitmap(bitmap_light,10,10,paint);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                p.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                b = true;
                p.lineTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                int x=(int) event.getX();
                int y =(int)event.getY();
                if((x>=10 & x<=110) & (y>=10 & y<=120)) {
                    b=false;
                    p.reset();
                }
        }
        invalidate();
        return true;
    }
    public  static Bitmap getBitFromVector(Context context, int drawableId)

    {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);

        drawable = (DrawableCompat.wrap(drawable)).mutate();

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0,80,80);
        drawable.draw(canvas);

        return bitmap;

    }
}
