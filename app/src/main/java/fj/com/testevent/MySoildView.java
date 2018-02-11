package fj.com.testevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Fj on 2018/2/10 0010.
 */

public class MySoildView extends View {
    private int Size;
    private Context mContext;
    private Paint mPaint;

    public MySoildView(Context context) {
        this(context,null);
    }

    public MySoildView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySoildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.FILL);
        Size=DensityUtils.dp2px(mContext,25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        WindowManager wm = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
              canvas.drawCircle(DensityUtils.dp2px(mContext,width/2),DensityUtils.dp2px(mContext,height/2),Size,mPaint);
    }

    public void setChangeView(int s){
       this.Size=s;
       invalidate();
    }
}
