package cc.codebigger.slideviewdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yanglong on 2016/9/21.
 */

public class View_5_2_4 extends View {
    public View_5_2_4(Context context) {
        super(context);
    }

    public View_5_2_4(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int lastX,lastY;

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

                ((View)getParent()).scrollBy(-offsetX,-offsetY);

                break;
        }

        return true;
    }
}
