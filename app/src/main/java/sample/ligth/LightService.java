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
    final int INTERVAL_PERIOD = 3000;
    final Handler handler = new Handler(Looper.myLooper());
    MyRunnable runnable = new MyRunnable();

    //toastを3秒ごとに表示する
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            Context context = getApplicationContext();
            Toast.makeText(context , "toast", Toast.LENGTH_SHORT).show();
            handler.postDelayed(this,INTERVAL_PERIOD);
        }
    }

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
        //別スレッドでアクセス
        handler.post(runnable);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        //toastの表示を終了する
        handler.removeCallbacks(runnable);
    }
}
