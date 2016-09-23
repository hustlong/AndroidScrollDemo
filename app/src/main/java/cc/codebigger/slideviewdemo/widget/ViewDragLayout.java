package cc.codebigger.slideviewdemo.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by code on 9/22/16.
 */

public class ViewDragLayout extends FrameLayout {

    private View mMenuView,mMainView;
    private int mWidth;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldW,int oldH) {
        super.onSizeChanged(w,h,oldW,oldH);
        mWidth = mMenuView.getMeasuredWidth();
    }

    public ViewDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mViewDragHelper = ViewDragHelper.create(this,callback);
    }

    public ViewDragLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ViewDragLayout(Context context) {
        this(context,null);
    }

    private ViewDragHelper mViewDragHelper;

    private final ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView==child;
        }

        @Override
        public int clampViewPositionVertical(View child,int top,int dy) {
            return 0;
        }

        @Override
        public int clampViewPositionHorizontal(View child,int left,int dx) {
            return left;
        }

        @Override
        public void onViewReleased(View child,float xVel,float yVel) {
            super.onViewReleased(child,xVel,yVel);
            if (mMainView.getLeft() < mWidth) {
                mViewDragHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(ViewDragLayout.this);
            } else {
                mViewDragHelper.smoothSlideViewTo(mMainView,mWidth,0);
                ViewCompat.postInvalidateOnAnimation(ViewDragLayout.this);
            }
        }
    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mViewDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

}
