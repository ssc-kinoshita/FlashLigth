package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LightActivity extends AppCompatActivity {

    private static final String TAG = "LightActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("LifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v(TAG, "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v(TAG, "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v(TAG, "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.v(TAG, "onRestart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v(TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }
}