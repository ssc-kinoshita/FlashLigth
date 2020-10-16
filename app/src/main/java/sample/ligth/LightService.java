package sample.ligth;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;


public class LightService extends Service {

    private static final String TAG = "LightService";
    private static final int INTERVAL_PERIOD = 5000;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final MyRunnable mRunnable = new MyRunnable();
    private LightFragmentCallback mLightFragmentCallback;

    public interface LightFragmentCallback{
        public void changeBackgroundColor();
    }

    public void setCallbacks(LightFragmentCallback lightFragmentCallback){
        Log.d(TAG, "setCallbacks");
        this.mLightFragmentCallback = lightFragmentCallback;
    }

    // Serviceに接続するためのBinderクラスを実装する
    public class LocalBinder extends Binder {
        //Serviceの取得
        LightService getService() {
            return LightService.this;
        }
    }

    // Binderの生成
    private final IBinder mBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");

        Log.d(TAG, "post呼び出し");
        mHandler.post(mRunnable);

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Log.d(TAG, "onUnbind");
        // Service切断時に呼び出される
        //onUnbindをreturn trueでoverrideすると次回バインド時にonRebildが呼ばれる

        mHandler.removeCallbacks(mRunnable);

        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    /**
     * 5秒ごとに背景色を変更する
     */
    private class MyRunnable implements Runnable  {

        @Override
        public void run() {

            if(mLightFragmentCallback != null) {
                mLightFragmentCallback.changeBackgroundColor();
            }

            mHandler.postDelayed(this,INTERVAL_PERIOD);
        }
    }
}
