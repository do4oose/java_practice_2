package com.company;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector(2,3,4);
        Vector vectorA = new Vector(5,7,6);
        Vector vectorC;
        Vector vectorAdd;
        Vector vectorSub;
        System.out.printf("Длина вектора: %.2f", vector.legthVector());
        System.out.print("\n");
        System.out.println("Скалярное произведение: "+ vector.scalarProduct(vectorA));
        vectorC = vector.crossProduct(vectorA);
        System.out.println("Векторное произведение: x="+ vectorC.getX()+", y="+vectorC.getY()+", z="+vectorC.getZ());
        System.out.printf("Косинус угла между векторами: %.2f", vector.cosinus(vectorA));
        System.out.print("\n");
        vectorAdd = vector.addition(vectorA);
        System.out.println("Сумма векторов : x="+ vectorAdd.getX()+", y="+vectorAdd.getY()+", z="+vectorAdd.getZ());
        vectorSub = vector.subtraction(vectorA);
        System.out.println("Разность векторов : x="+ vectorSub.getX()+", y="+vectorSub.getY()+", z="+vectorSub.getZ());
        Vector.mas(3);
    }
}

class Vector {

    private double x, y, z;

    public Vector (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector vector){
        this (vector.x, vector.y, vector.z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double legthVector() {
        return Math.sqrt(x*x+y*y+z*z);
    }

    public double scalarProduct(Vector vector) {
        return vector.x*x+vector.y*y+vector.z*z;
    }

    public Vector crossProduct(Vector vector){

        double x =(vector.y*z-vector.z*y);
        double y = (vector.z*x-vector.x*z);
        double z = (vector.x*y-vector.y*x);
        return new Vector(x,y,z);
    }

    public double cosinus(Vector vector){
        return scalarProduct(vector)/legthVector()*vector.legthVector();
    }

    public Vector addition(Vector vector){

        double x =(getX()+vector.x);
        double y = (getY()+vector.y);
        double z = (getZ()+vector.z);
        return new Vector(x,y,z);
    }

    public Vector subtraction(Vector vector){

        double x =(getX()-vector.x);
        double y = (getY()-vector.y);
        double z = (getZ()-vector.z);
        return new Vector(x,y,z);
    }

    public static void mas(int n){

        Vector [] masV = new Vector[n];
        for ( int i = 0; i < n; i++ ){
            double x =(Math.random()*10);
            double y =(Math.random()*10);
            double z =(Math.random()*10);
            masV[i] = new Vector(x,y,z);
            System.out.print("Вектор №"+(i+1));
            System.out.printf(" x=%.2f",x);
            System.out.printf("; y=%.2f",y);
            System.out.printf("; z=%.2f",z);
            System.out.print("\n");
        }
    }
}


