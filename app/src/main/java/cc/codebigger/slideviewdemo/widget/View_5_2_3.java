package cc.codebigger.slideviewdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yanglong on 2016/9/21.
 */

public class View_5_2_3 extends View {

    public View_5_2_3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View_5_2_3(Context context) {
        super(context);
    }

    private int lastX,lastY;

    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                params.leftMargin = getLeft() + offsetX;
                params.topMargin = getTop() + offsetY;
                break;
        }

        return true;
    }
}
