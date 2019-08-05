package com.example.rppma.maytheforcebewith_rodrigo.Domain.Dtos;

import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;

class PersonDto {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    private String[] films;
    private String[] species;
    private String[] vehicles;
    private String[] starships;

    PersonDto(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year,
              String gender, String[] films, String[] species, String[] vehicles, String[] starships){
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
    }

    Person toDomain(){
        return new Person(name, height, mass, hair_color, skin_color, eye_color, birth_year, gender,
                films.length, species.length, vehicles.length, starships.length);
    }
}
