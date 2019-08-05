package com.example.rppma.maytheforcebewith_rodrigo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Response;
import com.example.rppma.maytheforcebewith_rodrigo.Repositories.PeopleRepository;

public class PeopleViewModel extends ViewModel {

    private PeopleRepository repo;

    private MutableLiveData<Response> people;
    private MutableLiveData<Person> person;

    public LiveData<Response> getPeople(){
        if (people == null) {

            repo = new PeopleRepository();
            people = new MutableLiveData<>();

            requestPeople(1);
        }
        return people;
    }

    public LiveData<Person> isChanging(){
        if (person == null) person = new MutableLiveData<>();

        return person;
    }

    public void requestPeople(int page){
        repo.getPeople(page, response -> {
            this.people.setValue(response);
            return null;
        });
    }

    public void searchPeople(String name, int page){
        repo.searchPeople(name, page, (response) -> {
            this.people.setValue(response);
            return null;
        });
    }

    public void changeActivity(Person person){
        this.person.setValue(person);
    }

}
