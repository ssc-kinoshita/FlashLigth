package sample.ligth;


import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class LightService extends Service {

    private static final String TAG = "LightService";
    private static final int INTERVAL_PERIOD = 5000;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final MyRunnable mRunnable = new MyRunnable();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        //別スレッドでtoastを表示
        mHandler.post(mRunnable);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        //toastの表示を終了する
        mHandler.removeCallbacks(mRunnable);
    }



    /**
     * toastを3秒ごとに表示する
     */
    private class MyRunnable implements Runnable  {

        @Override
        public void run() {

            Context context = getApplicationContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
//            Toast.makeText(context , "toast", Toast.LENGTH_SHORT).show();

            View view = layoutInflater.inflate(R.layout.light_fragment, null);
            Random random = new Random();
            int randomValue = random.nextInt(4);
            switch (randomValue){
                case 0:
                    view.setBackgroundColor(Color.RED);
                    Log.d(TAG, "赤点灯");
                    break;
                case 1:
                    view.setBackgroundColor(Color.BLUE);
                    Log.d(TAG, "青点灯");
                    break;
                case 2:
                    view.setBackgroundColor(Color.GREEN);
                    Log.d(TAG, "緑点灯");
                    break;
                case 3:
                    view.setBackgroundColor(Color.WHITE);
                    Log.d(TAG, "白点灯");
                    break;
                default:
                    Log.d(TAG, "error");


            }

            mHandler.postDelayed(this,INTERVAL_PERIOD);
        }
    }
}
