package main;

import dao.JoinDAO;

public class JoinMainApp {
    public static void main(String[] args) {
        System.out.println("1 : 1 relationship .. ");
        JoinDAO.associationTest();

        System.out.println("\n==============================");
        System.out.println("==============================");

        System.out.println("1 : M relationship ..");
        JoinDAO.collectionTest();

        System.out.println("\n==============================");
        System.out.println("==============================");

        System.out.println("1 : M relationship between a user and comment boards..");
        JoinDAO.collectionTest2();
    }
}
