package com.example.AsyncTaskTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView tv;
    private ProgressBar bar;
    private Button btn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        bar = (ProgressBar) findViewById(R.id.pb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask task = new MyAsyncTask(tv,bar,MyActivity.this);
                task.execute(1000);
            }
        });

    }
}
