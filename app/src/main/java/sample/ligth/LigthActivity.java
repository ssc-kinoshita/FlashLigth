package sample.ligth;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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
                return true;
            case R.id.green:
                view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.blue:
                view.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.white:
                view.setBackgroundColor(Color.WHITE);
                return true;
        }
        return false;
    }

}