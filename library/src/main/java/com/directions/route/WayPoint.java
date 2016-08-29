package com.directions.route;

import com.google.android.gms.maps.model.LatLng;

public class WayPoint {
    private LatLng latLng;
    private String address;

    public WayPoint(LatLng latLng) {
        this.latLng = latLng;
    }

    public WayPoint(String address) {
        this.address = address;
    }

    public String render(){
        if (latLng != null){
            return latLng.latitude+","+latLng.longitude;
        }
        return address;
    }
}
