package cc.codebigger.slideviewdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by yanglong on 2016/9/21.
 */

public class View_5_2_5 extends View {

    public View_5_2_5(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public View_5_2_5(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    private int lastX,lastY;
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
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                if (scroller.computeScrollOffset())
                    scroller.forceFinished(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
            case MotionEvent.ACTION_UP:
                scroller.startScroll(getLeft(),getTop(),-getLeft()+initX,-getTop()+initY,2000);
                invalidate();

                break;
        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (scroller.computeScrollOffset()) {
            offsetLeftAndRight(scroller.getCurrX()-getLeft());
            offsetTopAndBottom(scroller.getCurrY()-getTop());
            invalidate();
        }
    }

}
