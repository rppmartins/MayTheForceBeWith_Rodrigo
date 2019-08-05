package com.example.rppma.maytheforcebewith_rodrigo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.Repositories.PersonRepository;

public class PersonViewModel extends ViewModel {

    private PersonRepository repo;

    private MutableLiveData<Person> person;
    private MutableLiveData<String> posted;

    public LiveData<Person> getPerson() {
        if (person == null) {

            repo = new PersonRepository();
            person = new MutableLiveData<>();
        }
        return person;
    }

    public LiveData<String> wasPosted(){
        if(posted == null) posted = new MutableLiveData<>();

        return posted;
    }

    public void setPerson(Person person){
        this.person.setValue(person);
    }

    public void savePerson(){
        repo.savePersonData(person.getValue(), success -> {
            this.posted.setValue(success);
            return null;
        });
    }



}
