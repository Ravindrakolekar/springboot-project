package com.project.springboot.CodingPracties;

public class SingletonClass {

    private static SingletonClass dbconnection;

    private SingletonClass(){

    }
    public static SingletonClass getInstance(){

        if(dbconnection==null){
            dbconnection = new SingletonClass();
        }
        return dbconnection;
    }

    public String getMessages(){
        return "Db connecion successfully connected";
    }

    public static void main(String[] args) {
        SingletonClass sg = SingletonClass.getInstance();

        System.out.println(sg.getMessages());
    }
}
