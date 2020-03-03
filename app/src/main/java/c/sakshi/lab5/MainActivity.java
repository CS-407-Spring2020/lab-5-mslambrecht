package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public String usernameKey = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("<c.sakshi.lab5>", Context.MODE_PRIVATE);
        //sharedPreferences.edit().remove("username").apply();
        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String str = sharedPreferences.getString(usernameKey, "");
            goToActivity2(str);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.loginView);
        String str = myTextField.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("<c.sakshi.lab5>", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(usernameKey, str).apply();
        goToActivity2(str);
    }

    public void goToActivity2(String s) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(usernameKey, s);
        startActivity(intent);
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return super.getSharedPreferences("<c.sakshi.lab5>",Context.MODE_PRIVATE);

    }
}
