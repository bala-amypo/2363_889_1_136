package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Studententity;
// post use mapip
@Service
public class Studentservice {
    Map<Integer,Studententity> mp = new HashMap<>();
    //give the data as it is 
    public Studententity savedata(Studententity st){
        mp.put(st.getId(),st);
        return st;

    }
    //retrive all the data
    public List<Studententity> retdata() {
        return new ArrayList<>(mp.values());
    }
    //retrive particular data
    public Studententity id(int id) {
        return mp.get(id);
    }
    //update
    public Studententity ids(int id, Studententity st) {
        return mp.put(id, st);
    }
    //delete
    public Studententity ideas(int id) {
        return mp.remove(id);
    }
}