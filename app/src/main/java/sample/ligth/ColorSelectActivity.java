package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ColorSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorselect);

        Button blueButton = findViewById(R.id.BlueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("Color", R.id.blue);
                setResult(RESULT_OK, intent);
                finish();
            }
       });

        Button redButton = findViewById(R.id.RedButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.red);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button greenButton = findViewById(R.id.GreenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.green);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button whiteButton = findViewById(R.id.WhiteButton);
        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.white);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}