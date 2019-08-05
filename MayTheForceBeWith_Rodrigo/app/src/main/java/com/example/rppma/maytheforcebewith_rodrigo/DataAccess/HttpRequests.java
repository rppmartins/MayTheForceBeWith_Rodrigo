package com.example.rppma.maytheforcebewith_rodrigo.DataAccess;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Dtos.ResponseDto;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Person;
import com.example.rppma.maytheforcebewith_rodrigo.Domain.Response;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import androidx.arch.core.util.Function;
import android.content.Context;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class HttpRequests {

    private static RequestQueue queue = null;

    public static void init(Context app_context){
        queue = Volley.newRequestQueue(app_context);
    }

    public void get(String url, Function<Response, ?> cb){

        String basic_url = "https://swapi.co/api/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, basic_url.concat(url),
                response -> cb.apply(getResponse(response)), //cb::apply
                error -> System.out.println(error.getMessage())
        );
        queue.add(stringRequest);
    }

    public void post(Person person, Function<String, ?> cb){

        String url = "http://webhook.site/4fdf0be2-0e34-4c56-ae36-508687adcd64";

        HashMap params = setPersonParams(person);

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                response -> cb.apply("Posted Successfully"),
                error -> cb.apply(error.getMessage()) //TODO throwing exception without visible reason
        )
        {
            @Override
            public Map<String, String> getHeaders(){

                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");

                return headers;
            }
        };

        queue.add(postRequest);
    }

    private Response getResponse(String response){

        ResponseDto dto = null;

        try {
            Gson gson = new Gson();
            dto = gson.fromJson(response, ResponseDto.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return dto.toDomain();
    }

    private HashMap setPersonParams(Person person){

        HashMap<String, String> params = new HashMap<>();

        params.put("name", person.getName());
        params.put("height", person.getHeight());
        params.put("mass", person.getMass());
        params.put("hair_color", person.getHairColor());
        params.put("skin_color", person.getSkinColor());
        params.put("eye_color", person.getEyeColor());
        params.put("birth_year", person.getBirthYear());
        params.put("gender", person.getGender());
        params.put("number_films", ""+person.getFilms());
        params.put("number_species", ""+person.getSpecies());
        params.put("number_vehicles", ""+person.getVehicles());
        params.put("number_starships", ""+person.getStarships());

        return params;
    }
}
