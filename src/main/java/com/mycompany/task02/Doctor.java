package com.mycompany.task02;

public class Doctor implements Comparable<Doctor> {
    public Doctor(String FIO, String specialty, int num, int hours, boolean attestation){
        this.FIO = FIO;
        this.specialty = specialty;
        this.num = num;
        this.hours = hours;
        this.attestation = attestation;
    }
    String FIO;
    String specialty;
    Integer num;
    Integer hours;
    Boolean attestation;

    @Override
    public int compareTo(Doctor o) {
        return FIO.compareTo(o.FIO);
    }
}
