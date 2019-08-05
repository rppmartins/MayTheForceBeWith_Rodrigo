package com.example.rppma.maytheforcebewith_rodrigo.Domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    private int films;
    private int species;
    private int vehicles;
    private int starships;

    public Person(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
                  String birth_year, String gender, int films, int species, int vehicles, int starships){
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

    protected Person(Parcel in) {
        name = in.readString();
        height = in.readString();
        mass = in.readString();
        hair_color = in.readString();
        skin_color = in.readString();
        eye_color = in.readString();
        birth_year = in.readString();
        gender = in.readString();
        films = in.readInt();
        species = in.readInt();
        vehicles = in.readInt();
        starships = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hair_color;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public int getFilms() {
        return films;
    }

    public int getSpecies() {
        return species;
    }

    public int getVehicles() {
        return vehicles;
    }

    public int getStarships() {
        return starships;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(height);
        dest.writeString(mass);
        dest.writeString(hair_color);
        dest.writeString(skin_color);
        dest.writeString(eye_color);
        dest.writeString(birth_year);
        dest.writeString(gender);
        dest.writeInt(films);
        dest.writeInt(species);
        dest.writeInt(vehicles);
        dest.writeInt(starships);
    }
}
