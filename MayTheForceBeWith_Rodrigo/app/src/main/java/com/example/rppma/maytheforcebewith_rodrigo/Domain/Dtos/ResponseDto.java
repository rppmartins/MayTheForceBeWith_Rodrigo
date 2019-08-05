package com.example.rppma.maytheforcebewith_rodrigo.Domain.Dtos;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Response;

public class ResponseDto {

    private int count;
    private PersonDto[] results;

    public ResponseDto(int count, PersonDto[] results){
        this.count = count;
        this.results = results;
    }

    public Response toDomain(){

        Person[] results_arr = new Person[results.length];

        for (int i = 0; i < results.length; i++) results_arr[i] = results[i].toDomain();

        return new Response(count, results_arr);
    }
}
