package com.example.rppma.maytheforcebewith_rodrigo.Domain;

public class Response {

    private int count;
    private Person[] results;

    public Response(int count, Person[] results){
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public Person[] getResults() {
        return results;
    }
}
