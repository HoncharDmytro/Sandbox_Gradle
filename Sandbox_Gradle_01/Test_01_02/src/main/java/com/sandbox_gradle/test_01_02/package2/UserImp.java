package com.sandbox_gradle.test_01_02.package2;

import org.springframework.stereotype.Service;

public class UserImp implements User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private String country;
    private String speciality;
    private int experience = 0;

    public UserImp(
            String firstName,
            String lastName,
            int age,
            String country,
            String speciality
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        if(speciality.isEmpty()){
            this.speciality = "None";
        }
        else {
            this.speciality = speciality;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "UserImp{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience=" + experience +
                '}';
    }
}
