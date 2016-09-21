package cc.codebigger.slideviewdemo.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by yanglong on 2016/9/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle ins) {
        super.onCreate(ins);
        actionBar = getSupportActionBar();
    }

    public void setActionBarTitle(String title) {
        if (actionBar != null)
            actionBar.setTitle(title);
    }

    public void setReturnButton(boolean hasReturnButton) {
        if (hasReturnButton)
            actionBar.setDisplayHomeAsUpEnabled(true);
        else
            actionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public abstract void findViews();

    public abstract void initViews();
}
