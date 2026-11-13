package com.example.multipleactivitiesapplication;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements View.OnTouchListener {
    private final GestureDetector detector;

    public OnSwipeTouchListener(Context context) {
        detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            private static final int DISTANCE = 100;
            private static final int VELOCITY = 100;

            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent first, MotionEvent last, float velocityX, float velocityY) {
                if (first == null || last == null) return false;
                float dx = last.getX() - first.getX();
                float dy = last.getY() - first.getY();
                if (Math.abs(dx) > Math.abs(dy) && Math.abs(dx) > DISTANCE
                        && Math.abs(velocityX) > VELOCITY) {
                    if (dx > 0) onSwipeRight();
                    else onSwipeLeft();
                    return true;
                }
                return false;
            }
        });
    }

    public void onSwipeLeft() { }
    public void onSwipeRight() { }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        boolean handled = detector.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_UP && handled) view.performClick();
        return handled;
    }
}
