package com.example.rppma.maytheforcebewith_rodrigo.Repositories;

import androidx.arch.core.util.Function;

import com.example.rppma.maytheforcebewith_rodrigo.DataAccess.HttpRequests;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;

public class PersonRepository {

    private HttpRequests http;

    public PersonRepository(){
        http = new HttpRequests();
    }

    public void savePersonData(Person person, Function<String, ?> cb){

        http.post(person, cb);
    }
}
