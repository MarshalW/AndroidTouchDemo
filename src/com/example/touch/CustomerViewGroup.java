package com.example.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-3-26
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */
public class CustomerViewGroup extends HorizontalScrollView {

    private View view;

    private int moveCount;

    public CustomerViewGroup(Context context) {
        super(context);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setView(View view) {
        this.view = view;
    }

    private boolean useWebView;

    private float hX, hY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            moveCount = 0;
            hX = event.getX();
            hY = event.getY();
            useWebView = false;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //第一次移动时做视图选择
            if (moveCount == 0) {
                if (Math.abs(event.getY() - hY) > Math.abs(event.getX() - hX)) {
                    event.setAction(MotionEvent.ACTION_DOWN);
                    useWebView = true;
                }
            }
            moveCount++;
        }

        if (useWebView) {
            view.dispatchTouchEvent(event);
        } else {
            super.dispatchTouchEvent(event);
        }

        return true;
    }
}
