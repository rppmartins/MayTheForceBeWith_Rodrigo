package com.example.rppma.maytheforcebewith_rodrigo.Repositories;

import androidx.arch.core.util.Function;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Response;
import com.example.rppma.maytheforcebewith_rodrigo.DataAccess.HttpRequests;

public class PeopleRepository {

    private HttpRequests http;

    public PeopleRepository(){
        http = new HttpRequests();
    }

    public void getPeople(int page, Function<Response, ?> cb){

        http.get("people/?page=" + page, cb );
    }

    public void searchPeople(String search, int page, Function<Response, ?> cb){

        http.get("people/?search=".concat(search).concat("&page=") + page, cb );
    }
}
