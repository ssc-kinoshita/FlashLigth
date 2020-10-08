package sample.ligth;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.app.Activity.RESULT_OK;

public class ColorSelectFragment extends Fragment {

    private static final String TAG = "ColorSelectFragment";

    @Override
    public void onAttach(Activity act){
        super.onAttach(act);
        Log.d(TAG,"onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

    }

    public void getData(int color){
        Intent intent = new Intent();
        intent.putExtra("Color", color);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();


    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.color_select_fragment,
                container, false);

        Button blueButton = view.findViewById(R.id.BlueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "青ボタン押下");

                getData(Color.BLUE);
            }
        });

        Button redButton = view.findViewById(R.id.RedButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "赤ボタン押下");

                getData(Color.RED);
            }
        });

        Button greenButton = view.findViewById(R.id.GreenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "緑ボタン押下");

                getData(Color.GREEN);
            }
        });

        Button whiteButton = view.findViewById(R.id.WhiteButton);
        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "白ボタン押下");
//                
                getData(Color.WHITE);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        Log.d(TAG,"onActivityCreated");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
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
}