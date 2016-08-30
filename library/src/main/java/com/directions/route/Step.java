package com.directions.route;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.directions.route.Leg.parseLatLng;

public class Step {
    public TextValue distance;
    public TextValue duration;
    public LatLng endLocation;
    public String htmlInstructions;
    public Polyline polyline;
    public LatLng startLocation;
    public String travelMode;
    public String maneuver;

    public Step(JSONObject json) throws JSONException {
        this.distance = new TextValue(json.getJSONObject("distance"));
        this.duration = new TextValue(json.getJSONObject("duration"));
        this.endLocation = parseLatLng(json.getJSONObject("end_location"));
        //Strip html from google directions and set as turn instruction
        this.htmlInstructions = json.getString("html_instructions").replaceAll("<(.*?)*>", "");
        this.polyline = new Polyline(json.getJSONObject("polyline"));
        this.startLocation = parseLatLng(json.getJSONObject("start_location"));
        this.travelMode = json.getString("travel_mode");
        if (json.has("maneuver")) {
            this.maneuver = json.getString("maneuver");
        }
    }

    public static List<Step> parseSteps(JSONArray json) throws JSONException {
        List<Step> steps = new ArrayList<>();
        for (int i=0;i<json.length();i++){
            Step step = new Step(json.getJSONObject(i));
            steps.add(step);
        }
        return steps;
    }

    public TextValue getDistance() {
        return distance;
    }

    public TextValue getDuration() {
        return duration;
    }

    public LatLng getEndLocation() {
        return endLocation;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public LatLng getStartLocation() {
        return startLocation;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public String getManeuver() {
        return maneuver;
    }
}