package org.launchcode.techjobs_oo;

public abstract class JobElement {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobElement() {
        this.id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobElement that = (JobElement) o;

        if (id != that.id) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public JobElement(String value) {
        this();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
