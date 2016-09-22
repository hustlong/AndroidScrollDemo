package cc.codebigger.slideviewdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;

import cc.codebigger.slideviewdemo.R;

/**
 * Created by code on 9/22/16.
 */

public class UIScrollView extends FrameLayout {

    private int duration;


    public UIScrollView(Context context) {
        this(context, null);
    }

    public UIScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.UIScrollView, defStyleAttr, 0);
        if (a != null) {
            duration = a.getInteger(R.styleable.UIScrollView_duration,600);
        }
        scroller = new Scroller(context);
    }

    private int lastY;
    private Scroller scroller;
    private int initX,initY;


    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w,h,oldW,oldH);
        initX = getLeft();
        initY = getTop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (scroller.computeScrollOffset())
                    scroller.forceFinished(true);
                lastY = y;
                Log.d("TAG", "ACTION_DOWN: lastY = " + lastY);
                break;
            case MotionEvent.ACTION_MOVE:
                int scrollY = y - lastY;
                Log.d("TAG", "onTouchEvent: getTop() = " + getTop() + "   scrollY = " + scrollY + "   y = " + y + "   rawY = " + event.getRawY());
                offsetTopAndBottom(scrollY/3-getTop());
                break;
            case MotionEvent.ACTION_UP:
                scroller.startScroll(getLeft(),getTop(),0,-getTop()+initY,duration);
                invalidate();
                break;
        }

        return true;
    }



//    private static final int TOUCH_STATE_REST = 1;
//    private static final int TOUCH_STATE_SCROLLING = 2;
//
//    private int mTouchState = 1;
//    private int mTouchSlop = 3;
//    private float mLastMotionX,mLastMotionY;
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d("TAG", "onInterceptTouchEvent-slop:"+mTouchSlop);
//
//        final int action = ev.getAction();
//        if ((action == MotionEvent.ACTION_MOVE) && (mTouchState != TOUCH_STATE_REST))
//        {
//            return true;
//        }
//
//        final float x = ev.getX();
//        final float y = ev.getY();
//
//        switch (action)
//        {
//            case MotionEvent.ACTION_MOVE:
//                final int yDiff = (int)Math.abs(mLastMotionY-y);
//                if (yDiff>mTouchSlop)
//                {
//                    mTouchState = TOUCH_STATE_SCROLLING;
//                }
//                break;
//
//            case MotionEvent.ACTION_DOWN:
//                mLastMotionX = x;
//                mLastMotionY = y;
//                mTouchState = scroller.isFinished()? TOUCH_STATE_REST : TOUCH_STATE_SCROLLING;
//                break;
//
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_UP:
//                mTouchState = TOUCH_STATE_REST;
//                break;
//        }
//
//        return mTouchState != TOUCH_STATE_REST;
//    }


    @Override
    public void computeScroll() {
        super.computeScroll();

        if (scroller.computeScrollOffset()) {
            offsetTopAndBottom(scroller.getCurrY()-getTop());
            invalidate();
        }
    }
}
