package sample.ligth;

import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LightFragment extends Fragment {

    static final int RESULT_COLORSELECTACTIVITY = 1000;
    private static final String TAG = "LightFragment";
    private SharedPreferences sharedPreferences;
    private Editor editor;

    @Override
    public void onAttach(Activity act){
        super.onAttach(act);
        Log.d(TAG,"onAttach" );
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

        sharedPreferences = getActivity().getSharedPreferences("LightFragment", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(sharedPreferences.getBoolean("LightFragment", false) == false){
            //初回起動時
            view.setBackgroundColor(Color.WHITE);
            editor.putBoolean("LightFragment", true);
            editor.commit();
        }else{
            //二回目以降
            sharedPreferences = getActivity().getSharedPreferences("LightFragment", Context.MODE_PRIVATE);
            int colorData = sharedPreferences.getInt("Color", 0);
            view.setBackgroundColor(colorData);
        }

        Button settingButton = view.findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ColorSelectActivity.class);
                startActivityForResult(intent, RESULT_COLORSELECTACTIVITY);
                Log.d(TAG, "startActivityForResult呼び出し");
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
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart" );
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        Log.d(TAG,"onDetach");
    }
    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent intent) {
        Log.d(TAG,"onActivityResult呼び出し");
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode == Activity.RESULT_OK && requestCode == RESULT_COLORSELECTACTIVITY){

            View view = getActivity().findViewById(R.id.fragment);
            view.setBackgroundColor(intent.getIntExtra("Color", 0));

            sharedPreferences = getActivity().getSharedPreferences("LightFragment", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putInt("Color", intent.getIntExtra("Color", 0));
            editor.commit();
        }
    }
}