package com.sergio.eltiempo;

public class Forecast {
    private long id;
    private String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass;
    private String created;
    private String applicable_date;
    private Float min_temp;
    private Float max_temp;
    private Float the_temp;
    private Float wind_speed;
    private Float wind_direction;
    private Float air_pressure;
    private int humidity;
    private Float visibility;
    private int predictability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public Float getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Float min_temp) {
        this.min_temp = min_temp;
    }

    public Float getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Float max_temp) {
        this.max_temp = max_temp;
    }

    public Float getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(Float the_temp) {
        this.the_temp = the_temp;
    }

    public Float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(Float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public Float getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(Float air_pressure) {
        this.air_pressure = air_pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }
}
