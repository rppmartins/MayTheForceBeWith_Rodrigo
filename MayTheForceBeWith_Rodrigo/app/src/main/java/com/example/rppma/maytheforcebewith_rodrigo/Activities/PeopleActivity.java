package com.example.rppma.maytheforcebewith_rodrigo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rppma.maytheforcebewith_rodrigo.Adapters.PeopleListAdapter;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.R;
import com.example.rppma.maytheforcebewith_rodrigo.ViewModel.PeopleViewModel;

public class PeopleActivity extends AppCompatActivity {

    private PeopleViewModel view_model;

    private int people_count = 0;
    private boolean searching = false;

    private TextView search_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        TextView result_number = findViewById(R.id.resultsView);
        search_text = findViewById(R.id.searchText);
        ImageButton search_button = findViewById(R.id.searchButton);
        ImageButton back_button = findViewById(R.id.backButton);
        ImageButton next_button = findViewById(R.id.nextButton);
        TextView page = findViewById(R.id.pageNumber);

        view_model = ViewModelProviders.of(this).get(PeopleViewModel.class);

        view_model.getPeople().observe(this, response -> {

            if (people_count == 0 || people_count != response.getCount()){

                people_count = response.getCount();

                result_number.setText(" " + people_count);
                page.setText("1");
            }

            fillList(response.getResults());
        });

        view_model.isChanging().observe(this, this::changeActivity);

        search_text.setOnClickListener(e -> {

            search_text.setText("");

            if (searching){
                searching = false;
                view_model.requestPeople(1);
            }
        });

        back_button.setOnClickListener( e -> {

            Log.d("$$$$", "BACK");

            int page_number = Integer.parseInt(page.getText().toString());

            if (page_number <= 1) return;

            page_number -= 1;

            if(searching) view_model.searchPeople(getSearchText(), page_number);
            else view_model.requestPeople(page_number);

            page.setText("" + page_number);
        });

        next_button.setOnClickListener( e -> {

            Log.d("$$$$", "NEXT");

            int page_number = Integer.parseInt(page.getText().toString());

            if((people_count - page_number * 10) > 0){

                page_number += 1;

                if (searching) view_model.searchPeople(getSearchText(), page_number);
                else view_model.requestPeople(page_number);

                page.setText("" + page_number);
            }
        });

        search_button.setOnClickListener( e -> {

            String search_name = getSearchText();

            if(search_name.equals(getString(R.string.search)) || search_name.equals(""))
                return;

            searching = true;
            view_model.searchPeople(search_name, 1);
        });
    }

    private String getSearchText(){
        return search_text.getText().toString();
    }

    private void fillList(Person[] people){

        RecyclerView.LayoutManager layoutMgr = new LinearLayoutManager(this);
        RecyclerView.Adapter viewAdapter = new PeopleListAdapter(people, view_model);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutMgr);
        recyclerView.setAdapter(viewAdapter);
    }

    private void changeActivity(Person person){

        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("person", person);

        startActivity(intent);
    }
}