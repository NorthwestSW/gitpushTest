package fj.com.testevent;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Fj on 2018/2/9 0009.
 */

public class MyDragParentView extends FrameLayout {
    private static final int DEFAULT_CHILD_GRAVITY = Gravity.TOP | Gravity.START;
    private int moveY;
    public MyDragParentView(Context context) {
        this(context,null);
    }

    public MyDragParentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyDragParentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }




    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        MyCircleImageView imageView = (MyCircleImageView) getChildAt(1);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
            layoutChildren(l, t, r, b, false /* no force left gravity */);
    }

    void layoutChildren(int left, int top, int right, int bottom, boolean forceLeftGravity) {
        final int count = getChildCount();

        final int parentLeft = 0;
        final int parentRight = right - left;

        final int parentTop = 0;
        final int parentBottom = bottom - top - 0;

        for (int i = 0; i < count; i++) {

                final View child = getChildAt(i);
                if (child.getVisibility() != GONE) {
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                    final int width = child.getMeasuredWidth();
                    final int height = child.getMeasuredHeight();

                    int childLeft;
                    int childTop;

                    int gravity = lp.gravity;
                    if (gravity == -1) {
                        gravity = DEFAULT_CHILD_GRAVITY;
                    }

                    final int layoutDirection = getLayoutDirection();
                    final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                    final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;

                    switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                        case Gravity.CENTER_HORIZONTAL:
                            childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
                                    lp.leftMargin - lp.rightMargin;
                            break;
                        case Gravity.RIGHT:
                            if (!forceLeftGravity) {
                                childLeft = parentRight - width - lp.rightMargin;
                                break;
                            }
                        case Gravity.LEFT:
                        default:
                            childLeft = parentLeft + lp.leftMargin;
                    }

                    switch (verticalGravity) {
                        case Gravity.TOP:
                            childTop = parentTop + lp.topMargin;
                            break;
                        case Gravity.CENTER_VERTICAL:
                            childTop = parentTop + (parentBottom - parentTop - height) / 2 +
                                    lp.topMargin - lp.bottomMargin;
                            break;
                        case Gravity.BOTTOM:
                            childTop = parentBottom - height - lp.bottomMargin;
                            break;
                        default:
                            childTop = parentTop + lp.topMargin;
                    }

                    child.layout(childLeft, childTop, childLeft + width, childTop + height);
                }


        }
    }

}
