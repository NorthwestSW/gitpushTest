package fj.com.testevent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Fj on 2018/2/9 0009.
 */

public class DragView extends View {

    private int mDragHeight;
    private int mDragWidth;
    private int mDragColor;
    private int mDragIv;
    /*********************************/
    private Context mContext;
    private Paint topPaint;
    private int circleRadious;
    private Paint centerPaint;


    public DragView(Context context) {
        this(context, null);

    }


    public DragView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        getAttrs(context, attrs);
        initView(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mDragWidth, mDragHeight + circleRadious);
    }

    /**
     * 获取自定义属性
     *
     * @param context
     * @param attrs
     */
    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DragView);
        mDragHeight = (int) array.getDimension(R.styleable.DragView_DragHeight, DensityUtils.dp2px(context, mDragHeight));
        mDragWidth = (int) array.getDimension(R.styleable.DragView_DragWidth, DensityUtils.dp2px(context, mDragWidth));
        mDragColor = array.getColor(R.styleable.DragView_DragColor, mDragColor);
        mDragIv = array.getResourceId(R.styleable.DragView_DragIv, mDragIv);
        array.recycle();
    }

    //初始化操作
    private void initView(Context context) {
        if (mDragWidth != 0) {
            circleRadious = mDragWidth / 2;
        }
        initCircle();
        initBount();


    }


    /**
     * 初始化矩形的画笔
     */
    private void initBount() {
        centerPaint = new Paint();
        if (mDragColor != 0) {
            centerPaint.setColor(mDragColor);
        } else {
            centerPaint.setColor(Color.RED);
        }
        centerPaint.setDither(true);  //防抖动
        centerPaint.setStyle(Paint.Style.FILL);
        centerPaint.setAntiAlias(true); //抗锯齿
    }

    /**
     * 初始化圆的画笔
     */
    private void initCircle() {
        topPaint = new Paint();
        if (mDragColor != 0) {
            topPaint.setColor(mDragColor);
        } else {
            topPaint.setColor(Color.RED);
        }
        topPaint.setDither(true);  //防抖动
        topPaint.setStyle(Paint.Style.FILL);
        topPaint.setAntiAlias(true); //抗锯齿

    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawTopCircle(canvas);
        drawBottomCircle(canvas);
        drawCenterView(canvas);

    }

    /**
     * 画底部的圆
     *
     * @param canvas
     */
    private void drawBottomCircle(Canvas canvas) {
        if (mDragHeight != 0) {
            canvas.drawCircle(circleRadious, mDragHeight, circleRadious, topPaint);
        }

    }

    /**
     * 画中间矩形
     *
     * @param canvas
     */
    private void drawCenterView(Canvas canvas) {
        Rect rect = null;
        if (mDragHeight != 0) {
            rect = new Rect(0, circleRadious, mDragWidth, mDragHeight);
            canvas.drawRect(rect, centerPaint);
        }

    }

    /**
     * 圆
     *
     * @param canvas
     */
    private void drawTopCircle(Canvas canvas) {
        canvas.drawCircle(circleRadious, circleRadious, circleRadious, topPaint);
    }


}
