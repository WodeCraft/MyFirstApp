package com.hfad.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person p = new Person("Arthur Dent", 42);
        Log.d("Person", p.toString());

        ArrayList<Person> cast = new ArrayList<>();
        cast.add(new Person("Tricia", 28));
        cast.add(new Person("Zaphod", 172));
        cast.add(new Person("Ford", 76));

        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < cast.size(); x++) {
            sb.append(cast.get(x).toString());
            if (x < cast.size() - 1)
                sb.append(System.getProperty("line.separator"));
            Log.d("Cast", cast.get(x).toString());
        }

        Context context = getApplicationContext();
        CharSequence text = p.toString();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();

        Toast castToast = Toast.makeText(context, sb.toString(), duration);
        castToast.setGravity(Gravity.CENTER, 0,0);
        castToast.show();

    }

    public void onClickSayHello(View view) {
        EditText inputName = findViewById(R.id.txtName);
        Toast.makeText(getApplicationContext(), "Hello " + inputName.getText() + "!", Toast.LENGTH_LONG).show();
    }

    public void onClickButton2(View view) {
        Toast.makeText(getApplicationContext(), "Button 2 pressed!", Toast.LENGTH_SHORT).show();
    }
}
