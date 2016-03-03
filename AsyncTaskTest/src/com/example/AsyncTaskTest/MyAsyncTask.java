package com.example.AsyncTaskTest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by ppzhou on 2015/10/20.
 */


/**
* ���ɸ���Ķ��󣬲�����execute����֮��
 * ����ִ�е���onProExecute����
  * ���ִ��doInBackgroup����
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
    protected void onPreExecute() {    //   �����������û�����Excuteʱ�Ľӿڣ�������ִ��֮ǰ��ʼ���ô˷�����������������ʾ���ȶԻ���
        tv.setText(c.getResources().getText(R.string.start));
    }

    /**
         * �����Intege������ӦAsyncTask�еĵڶ�������
        * ��doInBackground�������У���ÿ�ε���publishProgress�������ᴥ��onProgressUpdateִ��
        * onProgressUpdate����UI�߳���ִ�У����п��Զ�UI�ռ���в���
        */

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        pb.setProgress(value);
    }
}
