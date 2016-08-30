package com.directions.route;

import org.json.JSONException;
import org.json.JSONObject;

public class TextValue {
    public String text;
    public Integer value;

    public TextValue(JSONObject json) throws JSONException {
        this.text = (String) json.get("text");
        this.value = (int) json.get("value");
    }

    public String getText() {
        return text;
    }

    public Integer getValue() {
        return value;
    }
}
