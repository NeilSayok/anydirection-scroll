package neilsayok.github.anydirectionscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class PanView extends ScrollView {

    View panView;
    HorizontalScrollView hScroll;
    ScrollView vScroll;



    public PanView(Context context) {
        super(context);
        init(context);
    }



    public PanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PanView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(Context context) {

        panView = inflate(context, R.layout.pan_view, this);

        hScroll = panView.findViewById(R.id.scrollHorizontal);
        vScroll = hScroll.findViewById(R.id.scrollVertical);

        //vScroll = (ScrollView)  inflate(context, R.layout.pan_view, this);
        //hScroll = vScroll.findViewById(R.id.scrollHorizontal);


        vScroll.setOnTouchListener(new View.OnTouchListener() { //inner scroll listener
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        /*hScroll.setOnTouchListener(new View.OnTouchListener() { //outer scroll listener
            private float mx, my, curX, curY;
            private boolean started = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                curX = event.getX();
                curY = event.getY();
                int dx = (int) (mx - curX);
                int dy = (int) (my - curY);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (started) {
                            vScroll.scrollBy(0, dy);
                            hScroll.scrollBy(dx, 0);
                        } else {
                            started = true;
                        }
                        mx = curX;
                        my = curY;
                        break;
                    case MotionEvent.ACTION_UP:
                        vScroll.scrollBy(0, dy);
                        hScroll.scrollBy(dx, 0);
                        started = false;
                        break;
                }
                return true;
            }
        });*/


    }



}
