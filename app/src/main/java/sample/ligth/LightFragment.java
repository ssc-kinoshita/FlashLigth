package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

public class LightFragment extends Fragment {

    static final int RESULT_COLORSELECTACTIVITY = 1000;
    private static final String TAG = "LightFragment";

//    static LightFragment newInstance(int count){
//        // LightFragment インスタンス生成
//        LightFragment fragment01 = new LightFragment();
//
//        // Bundle にパラメータを設定
//        Bundle args = new Bundle();
//        args.putInt("Counter", count);
//        fragment01.setArguments(args);
//
//        return fragment01;
//    }

//    public static LightFragment newInstance(String str){
//
////        // Fragemnt01 インスタンス生成
////        TestFragment fragment = new TestFragment();
////
////        // Bundle にパラメータを設定
////        Bundle barg = new Bundle();
////        barg.putString("Message", str);
////        fragment.setArguments(barg);
////
////        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_light_fragment, container, false);
//        View v = view.findViewById(R.id.layout);
//        v.setBackgroundColor(Color.WHITE);
        Button settingButton = view.findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ColorSelectActivity.class);
                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
                Log.d(TAG, "startActivityForResult呼び出し");

//                FragmentManager fragmentManager = getFragmentManager();
//
//                if(fragmentManager != null){
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    // BackStackを設定
//                    fragmentTransaction.addToBackStack(null);
//
//                    fragmentTransaction.replace(R.id.container,new ColorSelectFragment());
//                    fragmentTransaction.commit();
//                }
            }
        });

        return view;
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreate");
//        view = view.findViewById(R.id.layout);
//        view.setBackgroundColor(Color.WHITE);
//        Button settingButton = view.findViewById(R.id.settingButton);
//        settingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LightActivity.this, ColorSelectActivity.class);
//                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
//            }
//        });

    }

//        @Override
//    public void onActivityResult( int requestCode, int resultCode, Intent intent) {
//        Log.d(TAG,"onActivityResult呼び出し");
//        super.onActivityResult(requestCode, resultCode, intent);
//        if(resultCode == RESULT_OK && requestCode == RESULT_COLORSELECTACTIVITY){
//            int res = intent.getIntExtra("Color", 0);
//            Log.d(TAG, "変数resは" + res);
//            View view = getView().findViewById(R.id.layout);
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