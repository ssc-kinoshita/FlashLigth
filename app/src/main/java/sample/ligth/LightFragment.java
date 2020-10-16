package sample.ligth;

import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import java.util.Random;

public class LightFragment<BindService> extends Fragment implements LightService.LightFragmentCallback {

    static final int RESULT_COLORSELECTACTIVITY = 1000;
    private static final String TAG = "LightFragment";
    private static final String SAVE_PREFERENCE_FILE = "LightFragment";
    private static final String COLOR_KEY = "Color";
    LightService mBindService;

    private ServiceConnection mConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            // Serviceとの接続確立時に呼び出される。
            // service引数には、Onbind()で返却したBinderが渡される
            mBindService = ((LightService.LocalBinder) service).getService();
            //必要であればmBoundServiceを使ってバインドしたServiceへの制御を行う

            Log.d(TAG, "setCallbacks呼び出し");
            mBindService.setCallbacks(LightFragment.this);
        }

        public void onServiceDisconnected(ComponentName className) {
            // Serviceとの切断時に呼び出される。
            mBindService = null;
        }
    };

    @Override
    public void onAttach(Activity act) {
        super.onAttach(act);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.light_fragment, container, false);

        //前回設定した背景色を読み込み
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SAVE_PREFERENCE_FILE, Context.MODE_PRIVATE);
        int colorData = sharedPreferences.getInt(COLOR_KEY, Color.WHITE);
        view.setBackgroundColor(colorData);

        Button settingButton = view.findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //LightFragmentからColorSelectFragmentに画面遷移
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ColorSelectActivity.class);
                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
                Log.d(TAG, "startActivityForResult呼び出し");

                Context context = getContext().getApplicationContext();
                Toast.makeText(context, "設定ボタン押下", Toast.LENGTH_LONG).show();
                mBindService.abc();
            }
        });

        //toast表示
        Button startButton = view.findViewById(R.id.startbutton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //serviceの起動
//                Intent intent = new Intent(getActivity(), LightService.class);
//                getActivity().startService(intent);
                // Serviceをbindする
                Intent i = new Intent(getActivity(), LightService.class);
                getActivity().bindService(i, mConnection, Context.BIND_AUTO_CREATE);

            }

        });

        //toast停止
        Button stopButton = view.findViewById(R.id.stopbutton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //serviceの停止
//                Intent intent = new Intent(getActivity(), LightService.class);
//                getActivity().stopService(intent);

                // Serviceをunbindする
                getActivity().unbindService(mConnection);
            }
        });







        return view;
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d(TAG, "onActivityResult呼び出し");
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK && requestCode == RESULT_COLORSELECTACTIVITY) {
            //ColorSelectFragmentからの背景色を受け取る
            View view = getActivity().findViewById(R.id.fragment);
            int setColor = intent.getIntExtra(COLOR_KEY, 0);
            view.setBackgroundColor(setColor);

            //背景色をプリファレンスに保存する
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SAVE_PREFERENCE_FILE, Context.MODE_PRIVATE);
            Editor editor = sharedPreferences.edit();
            editor.putInt(COLOR_KEY, setColor);
            editor.apply();
        }
    }


    public void backgroundColorChange() {

        Log.d(TAG, "backgroundColorChange");

        View view = getActivity().findViewById(R.id.fragment);
        Random random = new Random();
        int randomValue = random.nextInt(4);
        switch (randomValue) {
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
    }
}