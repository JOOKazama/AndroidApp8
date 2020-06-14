package com.catclients.validator;
import com.catclients.classes.Cat;
import java.util.ArrayList;

public class Validator
{
    public String AddValidator(Cat cat, ArrayList<Cat>cats)
    {
        int count=0;
        String warning="";

        for(Cat cat1:cats)
        { if(!cat1.getName().equals(cat.getName())) count++; }

        if(cat.getName().equals("") || cat.getBreed().equals("") || cat.getCondition().equals(""))
        { warning="One or more of the fields are empty!"; }
        else if(cat.getName().length()>10 || cat.getBreed().length()>10 || cat.getCondition().length()>10)
        { warning="One or more of the fields are with length bigger than 10!"; }
        else if(count!=cats.size()) { warning="Cat already exists!"; }
        return warning;
    }
}