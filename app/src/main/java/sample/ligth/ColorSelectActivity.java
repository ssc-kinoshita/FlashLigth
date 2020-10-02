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

        Button BlueButton = findViewById(R.id.BlueButton);
        BlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("Color", R.id.blue);
                setResult(RESULT_OK, intent);
                finish();
            }
       });

        Button RedButton = findViewById(R.id.RedButton);
        RedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.red);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button GreenButton = findViewById(R.id.GreenButton);
        GreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.green);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button WhiteButton = findViewById(R.id.WhiteButton);
        WhiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Color", R.id.white);
                setResult(RESULT_OK, intent);
                finish();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ligth,menu);
        return true;


    }




}