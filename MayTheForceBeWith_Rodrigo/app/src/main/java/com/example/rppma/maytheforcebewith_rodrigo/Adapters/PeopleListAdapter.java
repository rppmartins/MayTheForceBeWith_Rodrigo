package com.example.rppma.maytheforcebewith_rodrigo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.R;
import com.example.rppma.maytheforcebewith_rodrigo.ViewModel.PeopleViewModel;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.PeopleViewHolder> {

    private Person[] people;
    private PeopleViewModel view_model;

    public PeopleListAdapter(Person[] people, PeopleViewModel view_model){
        this.people = people;
        this.view_model = view_model;
    }

    static class PeopleViewHolder extends RecyclerView.ViewHolder{
        PeopleViewHolder(View view) {
            super(view);
        }
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_entry, parent, false);

        return new PeopleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {

        Person person = people[position];

        TextView name = holder.itemView.findViewById(R.id.nameView);
        TextView height = holder.itemView.findViewById(R.id.heightView);
        TextView gender = holder.itemView.findViewById(R.id.genderView);

        name.setText(person.getName());
        height.setText(person.getHeight().concat(" cm"));
        gender.setText(person.getGender());

        holder.itemView.setOnClickListener(e -> view_model.changeActivity(person));
    }

    @Override
    public int getItemCount() {
        return people.length;
    }
}
