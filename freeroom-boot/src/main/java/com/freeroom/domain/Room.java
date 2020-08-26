package com.freeroom.domain;

public class Room {
    private Integer id;

    private String buildname;

    private String room;

    private String week;

    private Integer session;

    private Integer schoolweek;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname == null ? null : buildname.trim();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Integer getSchoolweek() {
        return schoolweek;
    }

    public void setSchoolweek(Integer schoolweek) {
        this.schoolweek = schoolweek;
    }
}