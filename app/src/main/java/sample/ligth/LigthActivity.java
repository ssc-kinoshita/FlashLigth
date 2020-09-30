package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LigthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligth);
        View view = findViewById(R.id.layout);
        view.setBackgroundColor(Color.WHITE);
        int i = 1;
        Log.d("デバッグ", "変数iは" + i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ligth,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        View view = findViewById(R.id.layout);
        switch (item.getItemId()){
            case R.id.red:
                view.setBackgroundColor(Color.RED);
                Log.d("red", "赤点灯" );
                return true;
            case R.id.green:
                view.setBackgroundColor(Color.GREEN);
                Log.d("green", "緑点灯" );
                return true;
            case R.id.blue:
                view.setBackgroundColor(Color.BLUE);
                Log.d("blue", "青点灯" );
                return true;
            case R.id.white:
                view.setBackgroundColor(Color.WHITE);
                Log.d("white", "白点灯" );
                return true;
        }
        return false;
    }

}