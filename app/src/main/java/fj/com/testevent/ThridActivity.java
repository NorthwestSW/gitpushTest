package fj.com.testevent;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThridActivity extends AppCompatActivity {


    private MySoildView mySoildView;
   int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        initView();
    }

    private void initView() {
        mySoildView = (MySoildView) findViewById(R.id.bigChange);
    }

    public void scrollViewBtn(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(25, 100);
        valueAnimator.setDuration(7000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                 value = (int) animation.getAnimatedValue();
                Log.d("TAG", "cuurent value is " + value);
                mySoildView.setChangeView(value);
            }
        });
        valueAnimator.start();

    }
}
