package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // DONE: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        ArrayList<String> jobElementNames = new ArrayList<>(
                Arrays.asList("Employer", "Location", "Position Type", "Core Competency"));
        //create arraylist of values for job elements
        ArrayList<JobElement> jobElements = new ArrayList<>(
                Arrays.asList(employer, location, positionType, coreCompetency));

        //check if list is entirely null and name is null
        if ((jobElements.stream().allMatch(Objects::isNull)) && (name == null)) {
            return "This job does not appear to exist";
        }

        //value for if name is null
        String outputName = name;
        if (name.isBlank()) {
            outputName = "Data not available";
        }

        //create arraylist of all job element names
        String outputString = "ID: " + id + "\n" + "Name: " + outputName;
        for (int i = 0; i < jobElementNames.size(); i++) {
            if (jobElements.get(i).toString().isBlank()) {
                outputString += "\n" + jobElementNames.get(i) + ": Data not available";
            } else {
                outputString += "\n" + jobElementNames.get(i) + ": " + jobElements.get(i).toString();
            }
        }

        return outputString + "\n";
    }


    // DONE: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    // DONE: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
