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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("LifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.container, new LightFragment());
//        fragmentTransaction.commit();


//        // Fragmentを作成します
//        LightFragment fragment = new LightFragment();
//        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        // 新しく追加を行うのでaddを使用します
//        // 他にも、よく使う操作で、replace removeといったメソッドがあります
//        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
//        transaction.add(R.id.container, fragment);
//        // 最後にcommitを使用することで変更を反映します
//        transaction.commit();
//        View view = findViewById(R.id.layout);
//        view.setBackgroundColor(Color.WHITE);
//        Button settingButton = findViewById(R.id.settingButton);
//        settingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LightActivity.this, ColorSelectActivity.class);
//                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
//            }
//        });


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

//    @Override
//    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
//        Log.d(TAG,"onActivityResult呼び出し");
//        super.onActivityResult(requestCode, resultCode, intent);
//        if(resultCode == RESULT_OK && requestCode == RESULT_COLORSELECTACTIVITY){
//            int res = intent.getIntExtra("Color", 0);
//            Log.d(TAG, "変数resは" + res);
//            View view = findViewById(R.id.layout);
//            switch (res){
//                case R.id.red:
//                    view.setBackgroundColor(Color.RED);
//                    Log.d(TAG, "赤点灯" );
//                    break;
//
//                case R.id.green:
//                    view.setBackgroundColor(Color.GREEN);
//                    Log.d(TAG, "緑点灯" );
//                    break;
//
//                case R.id.blue:
//                    view.setBackgroundColor(Color.BLUE);
//                    Log.d(TAG, "青点灯" );
//                    break;
//
//                case R.id.white:
//                    view.setBackgroundColor(Color.WHITE);
//                    Log.d(TAG, "白点灯" );
//                    break;
//
//            }
//        }
//    }
}