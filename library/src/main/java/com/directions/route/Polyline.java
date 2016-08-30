package com.directions.route;
// com.google.android.gms.maps.model.Polyline;

import org.json.JSONException;
import org.json.JSONObject;

public class Polyline {
    public String points;

    public Polyline(JSONObject json) throws JSONException {
        this.points = json.getString("points");
    }
}