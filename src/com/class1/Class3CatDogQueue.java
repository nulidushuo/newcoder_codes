package com.class1;

import java.util.LinkedList;
import java.util.Queue;

public class Class3CatDogQueue {
    public static class Pet{
        private String type;
        public Pet(String type){ this.type = type; }
        public String getPetType(){
            return type;
        }
    }

    public static class Cat extends Pet{
        public Cat(){ super("cat");}
    }

    public static class Dog extends Pet{
        public Dog(){ super("dog");}
    }

    public static class PetEnter{
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return pet;
        }

        public long getCount(){
            return count;
        }

        public String getPetType(){
            return pet.getPetType();
        }
    }

    public static class CatDogQueue{
        private Queue<PetEnter> catQueue;
        private Queue<PetEnter> dogQueue;
        private long count;

        public CatDogQueue(){
            catQueue = new LinkedList<>();
            dogQueue = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet){
            if(pet.getPetType().equals("cat")){
                catQueue.add(new PetEnter(pet, this.count++));
            }else if (pet.getPetType().equals("dog")){
                dogQueue.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("error, not dog or cat");
            }
        }

        public Pet pollAll(){
            if(!catQueue.isEmpty() && !dogQueue.isEmpty()){
                if(catQueue.peek().getCount() < dogQueue.peek().getCount()){
                    return catQueue.poll().getPet();
                }else {
                    return dogQueue.poll().getPet();
                }
            } else if (!catQueue.isEmpty()) {
                return catQueue.poll().getPet();
            }else if (!dogQueue.isEmpty()){
                return dogQueue.poll().getPet();
            }else {
                throw new RuntimeException("queue is empty");
            }
        }

        public Dog pollDog(){
            if(dogQueue.isEmpty()){
                throw new RuntimeException("no dog");
            }else {
                return (Dog) dogQueue.poll().getPet();
            }
        }

        public Cat pollCat(){
            if(catQueue.isEmpty()){
                throw new RuntimeException("no dog");
            }else {
                return (Cat) catQueue.poll().getPet();
            }
        }

        public boolean isEmpty(){
            if(catQueue.isEmpty() && dogQueue.isEmpty()){
                return true;
            }else
                return false;
        }

        public boolean isDogEmpty(){
            if(dogQueue.isEmpty()){
                return true;
            }else
                return false;
        }

        public boolean isCatEmpty(){
            if(catQueue.isEmpty()){
                return true;
            }else
                return false;
        }

    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
