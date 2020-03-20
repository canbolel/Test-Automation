package com.turkishairlinesmobile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerInfo {

    private String passengerTc;
    private String passengerName;
    private String passengerLastName;
    private String passengerPhone;
    private String passengerEmail;
    private String passengerDateOfBirth;
    private String passengerGender;

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public String getPassengerTc() {
        return passengerTc;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public String getPassengerDateOfBirth() {
        return passengerDateOfBirth;
    }

    public void setPassengerTc(String passengerTc) {
        this.passengerTc = passengerTc;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public void setPassengerDateOfBirth(String passengerDateOfBirth) {
        this.passengerDateOfBirth = passengerDateOfBirth;
    }

    public ArrayList<PassengerInfo> getPassengers() {
        MySqlDatabase database = new MySqlDatabase("root", "password", "THY");
        ArrayList<PassengerInfo> passengerInfoList = new ArrayList<>();
        PassengerInfo passengerInfo = new PassengerInfo();

        try {
            ResultSet result = database.resultSet("SELECT * FROM customerInfo");
            while (result.next()) {
                passengerInfo.setPassengerTc(result.getString("customerTC"));
                passengerInfo.setPassengerName(result.getString("customerName"));
                passengerInfo.setPassengerLastName(result.getString("customerSurname"));
                passengerInfo.setPassengerPhone(result.getString("customerCellPhone"));
                passengerInfo.setPassengerDateOfBirth(result.getString("customerBirthday"));
                passengerInfo.setPassengerEmail(result.getString("customerEmail"));
                passengerInfo.setPassengerGender(result.getString("customerGender"));
                passengerInfoList.add(passengerInfo);
                passengerInfo = new PassengerInfo();
            }
            database.close();
            return passengerInfoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
