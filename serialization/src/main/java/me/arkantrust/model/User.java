package me.arkantrust.model;

import java.util.ArrayList;

public record User(int id, String name, int age, ArrayList<Pet> pets) {

    public void addPet(Pet pet) {
        
        pets.add(pet);

    }

    public void removePet(Pet pet) {
        
        pets.remove(pet);

    }

    public void removePet(int index) {
        
        pets.remove(index);

    }

    public void clearPets() {
        
        pets.clear();

    }

    public void editPet(int index, Pet pet) {
        
        pets.set(index, pet);

    }

    public void editPet(Pet oldPet, Pet newPet) {
        
        int index = pets.indexOf(oldPet);
        pets.set(index, newPet);

    }

}
