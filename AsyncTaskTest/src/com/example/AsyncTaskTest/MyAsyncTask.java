package com.example.AsyncTaskTest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by ppzhou on 2015/10/20.
 */


/**
* 生成该类的对象，并调用execute方法之后
 * 首先执行的是onProExecute方法
  * 其次执行doInBackgroup方法
 *
 */

public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {   //Params Progress Result
    private TextView tv;
    private ProgressBar pb;
    private Context c;
    public MyAsyncTask(TextView tv,ProgressBar pb,Context c){
        super();
        this.tv = tv;
        this.pb = pb;
        this.c = c;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int i = 0;
        for ( i =10 ;i<100; i+=10){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);



        }
        return i+params[0].intValue()+"";
    }

    @Override
    protected void onPostExecute(String s) {
        tv.setText(s);
    }

    @Override
    protected void onPreExecute() {    //   这里是最终用户调用Excute时的接口，当任务执行之前开始调用此方法，可以在这里显示进度对话框。
        tv.setText(c.getResources().getText(R.string.start));
    }

    /**
         * 这里的Intege参数对应AsyncTask中的第二个参数
        * 在doInBackground方法当中，，每次调用publishProgress方法都会触发onProgressUpdate执行
        * onProgressUpdate是在UI线程中执行，所有可以对UI空间进行操作
        */

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        pb.setProgress(value);
    }
}
