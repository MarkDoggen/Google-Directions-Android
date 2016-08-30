package com.directions.route;

import com.google.android.gms.maps.model.LatLng;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Leg {

    public TextValue distance;
    public TextValue duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;
    public List<Step> steps = new ArrayList<Step>();
//    public List<Object> trafficSpeedEntry = new ArrayList<Object>(); TODO
//    public List<Object> viaWaypoint = new ArrayList<Object>(); TODO

    public Leg(JSONObject json) throws JSONException {
        this.distance = new TextValue(json.getJSONObject("distance"));
        this.duration = new TextValue(json.getJSONObject("duration"));
        this.endAddress = json.getString("end_address");
        this.endLocation = parseLatLng(json.getJSONObject("end_location"));
        this.startAddress = json.getString("start_address");
        this.startLocation = parseLatLng(json.getJSONObject("start_location"));
        this.steps = Step.parseSteps(json.getJSONArray("steps"));
    }

    public static LatLng parseLatLng(JSONObject obj) throws JSONException {
        double lat = obj.getDouble("lat");
        double lng = obj.getDouble("lng");
        return new LatLng(lat, lng);
    }

    public TextValue getDistance() {
        return distance;
    }

    public TextValue getDuration() {
        return duration;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public LatLng getEndLocation() {
        return endLocation;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public LatLng getStartLocation() {
        return startLocation;
    }

    public List<Step> getSteps() {
        return steps;
    }
}