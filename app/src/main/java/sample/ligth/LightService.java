package sample.ligth;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;



public class LightService extends Service {

    private static final String TAG = "LightService";
    private static final int INTERVAL_PERIOD = 3000;
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
    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            Context context = getApplicationContext();
            Toast.makeText(context , "toast", Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(this,INTERVAL_PERIOD);
        }
    }
}
