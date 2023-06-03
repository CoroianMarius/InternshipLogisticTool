package com.ibm.den.entities.connection;

import java.util.ArrayList;

public class RegisterTeam {

    private ArrayList<String> members = new ArrayList<>();
    private String activity;

    public RegisterTeam() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}
