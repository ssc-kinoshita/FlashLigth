package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LightActivity extends AppCompatActivity {

    static final int RESULT_COLORSELECTACTIVITY = 1000;
    private static final String TAG = "LightActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("LifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        View view = findViewById(R.id.layout);
        view.setBackgroundColor(Color.WHITE);
        Button settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LightActivity.this, ColorSelectActivity.class);
                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v("LifeCycle", "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("LifeCycle", "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("LifeCycle", "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.v("LifeCycle", "onRestart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v("LifeCycle", "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v("LifeCycle", "onDestroy");
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        Log.d(TAG,"onActivityResult呼び出し");
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode == RESULT_OK && requestCode == RESULT_COLORSELECTACTIVITY){
            int res = intent.getIntExtra("Color", 0);
            Log.d(TAG, "変数resは" + res);
            View view = findViewById(R.id.layout);
            switch (res){
                case R.id.red:
                    view.setBackgroundColor(Color.RED);
                    Log.d("red", "赤点灯" );
                    break;

                case R.id.green:
                    view.setBackgroundColor(Color.GREEN);
                    Log.d("green", "緑点灯" );
                    break;

                case R.id.blue:
                    view.setBackgroundColor(Color.BLUE);
                    Log.d("blue", "青点灯" );
                    break;

                case R.id.white:
                    view.setBackgroundColor(Color.WHITE);
                    Log.d("white", "白点灯" );
                    break;

            }
        }
    }
}