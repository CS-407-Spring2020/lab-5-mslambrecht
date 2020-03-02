package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = (TextView) findViewById(R.id.mytextView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        textView2.setText("Welcome " + str + "!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.act2menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:
                Intent intent = new Intent(this, MainActivity.class);
                SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
                sharedPreferences.edit().remove("username").apply();
                finish();
                startActivity(intent);
                return true;
            case R.id.addnote:
                Intent intent2 = new Intent(this, Main3Activity.class);
                SharedPreferences sharedPreferences2 = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
                startActivity(intent2);
                return true;


            default: return super.onOptionsItemSelected(item);
        }
    }
}
