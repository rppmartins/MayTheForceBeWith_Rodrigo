package com.example.rppma.maytheforcebewith_rodrigo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.R;
import com.example.rppma.maytheforcebewith_rodrigo.ViewModel.PersonViewModel;

public class PersonActivity extends AppCompatActivity {

    private PersonViewModel view_model;

    private TextView nameView, heightView, massView, hair_colorView, skin_colorView, eye_colorView,
            birth_yearView, genderView, filmsView, speciesView, vehiclesView, starshipsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        view_model = ViewModelProviders.of(this).get(PersonViewModel.class);

        view_model.getPerson().observe(this, this::setView);
        view_model.wasPosted().observe(this, this::showToast);

        findViewById(R.id.saveButton).setOnClickListener(e -> view_model.savePerson());

        Intent intent = getIntent();
        view_model.setPerson(intent.getParcelableExtra("person"));
    }

    private void setView(Person person){
        initView();

        nameView.setText(person.getName());
        heightView.setText(person.getHeight());
        massView.setText(person.getMass());
        hair_colorView.setText(person.getHairColor());
        skin_colorView.setText(person.getSkinColor());
        eye_colorView.setText(person.getEyeColor());
        birth_yearView.setText(person.getBirthYear());
        genderView.setText(person.getGender());
        filmsView.setText("" + person.getFilms());
        speciesView.setText("" + person.getSpecies());
        vehiclesView.setText("" + person.getVehicles());
        starshipsView.setText("" + person.getStarships());
    }

    private void initView(){
        nameView = findViewById(R.id.nameView);
        heightView = findViewById(R.id.heightView);
        massView = findViewById(R.id.massView);
        hair_colorView = findViewById(R.id.hair_colorView);
        skin_colorView = findViewById(R.id.skin_colorView);
        eye_colorView = findViewById(R.id.eye_colorView);
        birth_yearView = findViewById(R.id.birth_yearView);
        genderView = findViewById(R.id.genderView);
        filmsView = findViewById(R.id.filmsView);
        speciesView = findViewById(R.id.speciesView);
        vehiclesView = findViewById(R.id.vehiclesView);
        starshipsView = findViewById(R.id.starshipsView);
    }

    private void showToast(String text){

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
