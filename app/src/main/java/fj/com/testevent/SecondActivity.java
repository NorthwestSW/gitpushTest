package fj.com.testevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void finishBtn(View view) {
        EventBus.getDefault().post(new MessageEvent("不知道从哪传过来的"));
        Intent intent = new Intent(this, ThridActivity.class);
        startActivity(intent);
        finish();
    }
}
