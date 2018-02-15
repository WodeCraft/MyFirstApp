package com.hfad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hfad.entities.Person;
import com.hfad.myfirstapp.R;

import java.util.ArrayList;

/**
 * Created by Jens Christian Rasch on 15-02-2018.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;

    public PersonAdapter(Context context, ArrayList<Person> people) {
        super(context, 0, people);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.person_list_view, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        name.setText(person.getName());

        return convertView;
    }
}
