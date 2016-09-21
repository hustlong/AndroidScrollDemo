package cc.codebigger.slideviewdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cc.codebigger.slideviewdemo.R;

public class MainActivity_5 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_5);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                goActivity(Activity_5_2_1.class,v);
                break;
            case R.id.button2:
                goActivity(Activity_5_2_2.class,v);
                break;
            case R.id.button3:
                goActivity(Activity_5_2_3.class,v);
                break;
            case R.id.button4:
                goActivity(Activity_5_2_4.class,v);
                break;
            case R.id.button5:
                goActivity(Activity_5_2_5.class,v);
                break;
            case R.id.button6:
                goActivity(Activity_5_2_6.class,v);
                break;
            case R.id.button7:
                goActivity(Activity_5_2_7.class,v);
                break;
        }
    }

    public void goActivity(Class<?> cls,View v) {
        startActivity(new Intent(this,cls).putExtra("title",((Button)v).getText().toString()));
    }
}
