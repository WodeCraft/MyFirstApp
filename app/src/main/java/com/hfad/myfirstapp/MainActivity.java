package com.hfad.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hfad.adapters.PersonAdapter;
import com.hfad.comparators.PersonNameComparator;
import com.hfad.entities.Pensionist;
import com.hfad.entities.Person;
import com.hfad.entities.Worker;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Person> people = new ArrayList<>();
    private PersonAdapter adapter;
    private PersonNameComparator nameComparator = new PersonNameComparator();

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

        people.add(new Person("A person", 33));
        people.add(new Worker("A worker", 42, 15000));
        people.add(new Pensionist("A pensionist", 72, 2010));

        sb = new StringBuilder();
        for(Person per : people) {
            sb.append(per.toString());
            sb.append(System.getProperty("line.separator"));
        }

        Toast peopleToast = Toast.makeText(context, sb.toString(), duration);
        peopleToast.setGravity(Gravity.CENTER, 0, 0);
        peopleToast.show();

        // Populate the list view
        adapter = new PersonAdapter(this, people);
        ListView peopleView = findViewById(R.id.myList);
        peopleView.setAdapter(adapter);

    }

    public void onClickSayHello(View view) {
        EditText inputName = findViewById(R.id.txtName);
        Toast.makeText(getApplicationContext(), "Hello " + inputName.getText() + "!", Toast.LENGTH_LONG).show();
    }

    public void onClickButton2(View view) {
        adapter.add(new Person("A new person", 13));
        adapter.sort(nameComparator);
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "Button 2 pressed!", Toast.LENGTH_SHORT).show();
    }
}
