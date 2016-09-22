package cc.codebigger.slideviewdemo.ui;

import android.content.Intent;
import android.os.Bundle;

import cc.codebigger.slideviewdemo.R;
import cc.codebigger.slideviewdemo.base.BaseActivity;

/**
 * Created by yanglong on 2016/9/21.
 */

public class Activity_5_2_9 extends BaseActivity {

    @Override
    protected void onCreate(Bundle ins) {
        super.onCreate(ins);
        setContentView(R.layout.activity_5_2_9);

        Intent intent = getIntent();
        if (intent != null)
            setActionBarTitle(intent.getStringExtra("title"));

        setReturnButton(true);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void initViews() {

    }
}
