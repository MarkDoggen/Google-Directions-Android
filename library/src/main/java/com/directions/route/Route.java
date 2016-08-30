package com.directions.route;
//by Haseem Saheed

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String name;
    private final List<LatLng> points;
    private List<Leg> legs;
    private String copyright;
    private String warning;
    private String country;
    private LatLngBounds latLgnBounds;
    private int length;
    private String polyline;
    private String durationText;
    private int durationValue;
    private String distanceText;
    private int distanceValue;
    private String endAddressText;
    private PolylineOptions polyOptions;

    public PolylineOptions getPolyOptions() {
        return polyOptions;
    }

    public void setPolyOptions(PolylineOptions polyOptions) {
        this.polyOptions = polyOptions;
    }

    public String getEndAddressText() {
        return endAddressText;
    }

    public void setEndAddressText(String endAddressText) {
        this.endAddressText = endAddressText;
    }

    public String getDurationText() {
        return durationText;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
    }

    public String getDistanceText() {
        return distanceText;
    }

    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }

    public int calculateDurationValue() {
        int duration = 0;
        for (Leg leg : getLegs()){
            duration += leg.getDuration().getValue();
        }
        return duration;
    }

    public void setDurationValue(int durationValue) {
        this.durationValue = durationValue;
    }

    public void addDurationValue(int durationValue){
        this.durationValue += durationValue;
    }

    public int calculateDistanceValue() {
        int distance = 0;
        for (Leg leg : getLegs()){
            distance +=leg.getDistance().getValue();
        }
        return distance;
    }

    public int getDurationValue() {
        return durationValue;
    }

    public int getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(int distanceValue) {
        this.distanceValue = distanceValue;
    }

    public void addDistanceValue(int distanceValue){
        this.distanceValue += distanceValue;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public Route() {
        points = new ArrayList<LatLng>();
        legs = new ArrayList<Leg>();
    }

    public void addPoint(final LatLng p) {
        points.add(p);
    }

    public void addPoints(final List<LatLng> points) {
        this.points.addAll(points);
    }

    public List<LatLng> getPoints() {
        return points;
    }

    public void addLeg(final Leg l) {
        legs.add(l);
    }

    public List<Leg> getLegs() {
        return legs;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param copyright the copyright to set
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * @return the copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param warning the warning to set
     */
    public void setWarning(String warning) {
        this.warning = warning;
    }

    /**
     * @return the warning
     */
    public String getWarning() {
        return warning;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }


    /**
     * @param polyline the polyline to set
     */
    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    /**
     * @return the polyline
     */
    public String getPolyline() {
        return polyline;
    }

    /**
     * @return the LatLngBounds object to map camera
     */
    public LatLngBounds getLatLgnBounds() {
        return latLgnBounds;
    }


    public void setLatLgnBounds(LatLng northeast, LatLng southwest) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(northeast);
        builder.include(southwest);
        this.latLgnBounds = builder.build();
    }

}

