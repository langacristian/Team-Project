package com.example.projectp3;

import java.util.Date;

public class Student{

        private long id;
        private String First_Name;
        private String Last_Name;
        private Date DOR;
        private long PhoneNr;
        private String Email;
        private String County;
        private String City;
        private String Sex;
        private long CNP;
        private long StdYear;
        private long StdGroup;

        Student(long id, String First_Name, String Last_Name, Date DOR, long PhoneNr, String Email, String County, String City, String Sex, long CNP, long StdYear, long StdGroup) {

                this.id = id;
                this.First_Name = First_Name;
                this.Last_Name = Last_Name;
                this.DOR = DOR;
                this.PhoneNr = PhoneNr;
                this.Email = Email;
                this.County = County;
                this.City = City;
                this.Sex = Sex;
                this.CNP = CNP;
                this.StdYear = StdYear;
                this.StdGroup = StdGroup;

        }

        public long getId() {
                return id;
        }

        public String getFirst_name() {

                return First_Name;
        }

        public String getLast_name() {
                return this.Last_Name;

        }
        public Date getDOR() {
                return this.DOR;
        }

        public long getPhoneNr() {
                return this.PhoneNr;
        }

        public String getEmail() {
                return this.Email;
        }

        public String getCounty() {
                return this.County;
        }

        public String getCity() {
                return this.City;
        }

        public String getSex() {
                return this.Sex;
        }

        public long getCNP() {
                return this.CNP;
        }

        public long getStdYear() {
                return StdYear;
        }

        public long getStdGroup() {
                return StdGroup;
        }




}