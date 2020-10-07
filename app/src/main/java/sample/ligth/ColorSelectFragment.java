package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ColorSelectFragment extends Fragment {

    private static final String TAG = "ColorSelectFragment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");


//        Button blueButton = getView().findViewById(R.id.BlueButton);
//        blueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent();
//                intent.putExtra("Color", R.id.blue);
//                setTargetFragment(RESULT_OK, intent);
//                finish();
//
//            }
//        });



        return inflater.inflate(R.layout.activity_color_select_fragment,
                container, false);
    }
}