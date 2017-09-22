package com.ksingle.switchbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * @link https://github.com/tjuksingle/SwitchButton
 * @author Ksingle
 * @version v1.0.0
 * Created by Ksingle on 2017/9/21.
 */

public class SwitchButton extends View {

    //switchMode
    static final int button_like = 0;
    static final int switch_normal = -1;
    static final int switch_default = -2;

    private int switchMode; //You can set switchMode by using setMode().

    private boolean check;

    //default color for rectangle and text
    private int switchOnColor = Color.parseColor("#CD000000");
    private int switchOffColor = Color.parseColor("#45000000");
    private int textColor = Color.parseColor("#FFFFFF");

    //the result size of the view
    private int widthResultSize;
    private int heightResultSize;
    private final int maxHeightSize = 80;

    private Paint paint,switchOnPaint,switchOffPaint;
    private Rect rect,leftRect,rightRect;
//
//    private Paint cyclePaint;
//    private Canvas cycleCanvas;
//    private RectF rectf;

    private String leftSideString,rightSideString;


    public SwitchButton(Context context) {
        super(context);
        init();
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);
        switchOnPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        switchOffPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//        cyclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        cyclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        cycleCanvas = new Canvas();
//        rectf = new RectF();

        setPaint();

        rect = new Rect();
        leftRect = new Rect();
        rightRect = new Rect();

        switchMode = switch_default;
    }

    private void setPaint(){
        paint.setColor(textColor);

        switchOnPaint.setColor(switchOnColor);

        switchOffPaint.setColor(switchOffColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY){
            widthResultSize = widthSize;
        }else{
            widthResultSize = 400;
            if (widthMode == MeasureSpec.AT_MOST){
                widthResultSize = Math.max(widthResultSize,widthSize);
            }
        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.UNSPECIFIED){
            heightResultSize = maxHeightSize;
        }else {
            heightResultSize = maxHeightSize;
            if (heightMode == MeasureSpec.AT_MOST) { //wrap_content
                heightResultSize = Math.min(heightResultSize, heightSize);
            }
        }
//      rectf.set(0,0,widthResultSize,heightResultSize);
        rect.set(0,0,widthResultSize,heightResultSize);
        leftRect.set(0,0, widthResultSize /2,heightResultSize);
        rightRect.set(widthResultSize /2,0, widthResultSize,heightResultSize);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthResultSize,heightResultSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (check){
            canvas.drawRect(leftRect,switchOnPaint);
            canvas.drawRect(rightRect,switchOffPaint);
        }else {
            canvas.drawRect(leftRect,switchOffPaint);
            canvas.drawRect(rightRect,switchOnPaint);
        }
        if (leftSideString != null && rightSideString != null){
            paint.getTextBounds(leftSideString,0,leftSideString.length(),rect);
            paint.getTextBounds(rightSideString,0,rightSideString.length(),rect);
            canvas.drawText(rightSideString,canvas.getWidth()*3/4-rect.width()/2,canvas.getHeight()/2-(paint.descent()+paint.ascent())/2,paint);
            canvas.drawText(leftSideString,canvas.getWidth()/4-rect.width()/2,canvas.getHeight()/2-(paint.descent()+paint.ascent())/2,paint);
        }
//
//        if (switchMode == SwitchButton.switch_normal){ //有没有大佬把矩形图像的圆角做了,感激不尽
//            cycleCanvas.drawRoundRect(rectf,10,10,cyclePaint);
//        }
        super.onDraw(canvas);
    }

    public void setText(String leftSideString,String rightSideString) {
        this.leftSideString = leftSideString;
        this.rightSideString = rightSideString;

        invalidate();
    }

    public void setMode(int switchMode) {
        this.switchMode = switchMode;
    }

    public void setChecked(boolean flag){
        check = flag;
        invalidate();
    }

    public boolean isChecked(){
        return check;
    }
    
    /**
     * @deprecated
     * */
    public void setColor(int switchOnColor,int switchOffColor) {
        this.switchOnColor = switchOnColor;
        this.switchOffColor = switchOffColor;
        setPaint();
        invalidate();
    }

    /**
     * @deprecated
     * */

    public void setColor(int switchOnColor,int switchOffColor,int textColor) {
        this.switchOnColor = switchOnColor;
        this.switchOffColor = switchOffColor;
        this.textColor = textColor;
        setPaint();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (switchMode == button_like){
            if (event.getX()>widthResultSize/2){
                setChecked(false);
            }else {
                setChecked(true);
            }
        }else if (event.getAction() == MotionEvent.ACTION_DOWN){
            check = !check;
            invalidate();
        }

        return super.onTouchEvent(event);
    }
}
