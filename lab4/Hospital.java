/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author School
 */
public class Hospital implements Comparable<Hospital>{

    int capacity;
    String name;
    
    @Override
    public int compareTo(Hospital h){
        return getName().compareTo(h.getName());
    }

    public Hospital(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    public Hospital() {
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hospital " + "capacity=" + capacity + ", name=" + name;
    }

}
