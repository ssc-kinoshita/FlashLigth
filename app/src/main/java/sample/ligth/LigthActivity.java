package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LigthActivity extends AppCompatActivity {

    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligth);
        View view = findViewById(R.id.layout);
        view.setBackgroundColor(Color.WHITE);
        //int i = 1;
        //Log.d("デバッグ", "変数iは" + i);
        Log.v("LifeCycle", "onCreate");

        Button button = findViewById(R.id.setting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ColorSelectActivity.class);
                int requestCode = 1000;
                startActivityForResult(intent, requestCode);
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
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d("test01","test01");
        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY){
            int res = intent.getIntExtra("Color", 0);
            Log.d("test02", "変数resは" + res);
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


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//
//        View view = findViewById(R.id.layout);
//        switch (item.getItemId()){
//            case R.id.red:
//                view.setBackgroundColor(Color.RED);
//                Log.d("red", "赤点灯" );
//                return true;
//            case R.id.green:
//                view.setBackgroundColor(Color.GREEN);
//                Log.d("green", "緑点灯" );
//                return true;
//            case R.id.blue:
//                view.setBackgroundColor(Color.BLUE);
//                Log.d("blue", "青点灯" );
//                return true;
//            case R.id.white:
//                view.setBackgroundColor(Color.WHITE);
//                Log.d("white", "白点灯" );
//                return true;
//        }
//        return false;
//    }
}