package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Weather;
import model.WeatherResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;


public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;  //Null - tut on pustoj, a v metode  request_weather uzhe dannie v nego popadajut

    @Given("city ID is: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("latitude"), response.getLat(), "Wrong latitude!");
        Assertions.assertEquals(params.get("longitude"), response.getLon(), "Wrong longitude!");
    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {
        Assertions.assertEquals(params.get("timezone"), response.getTimezone(), "Wrong timezone!");
        Assertions.assertEquals(params.get("timezone_offset"), response.getTimezoneOffset(), "Wrong timezone_offset!");
    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getCurrent().getDt(), "Wrong dt!");
        Assertions.assertEquals(params.get("sunrise"), response.getCurrent().getSunrise(), "Wrong sunrise!");
        Assertions.assertEquals(params.get("sunset"), response.getCurrent().getSunset(), "Wrong sunset!");
        Assertions.assertEquals(params.get("temp"), response.getCurrent().getTemp(), "Wrong temp!");
        Assertions.assertEquals(params.get("feels_like"), response.getCurrent().getFeelsLike(), "Wrong feels_like!");
        Assertions.assertEquals(params.get("pressure"), response.getCurrent().getPressure(), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), response.getCurrent().getHumidity(), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), response.getCurrent().getDewPoint(), "Wrong dew_point!");
        Assertions.assertEquals(params.get("uvi"), response.getCurrent().getUvi(), "Wrong uvi!");
        Assertions.assertEquals(params.get("clouds"), response.getCurrent().getClouds(), "Wrong clouds!");
        Assertions.assertEquals(params.get("visibility"), response.getCurrent().getVisibility(), "Wrong visibility!");
        Assertions.assertEquals(params.get("wind_speed"), response.getCurrent().getWindSpeed(), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), response.getCurrent().getWindDeg(), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), response.getCurrent().getWindGust(), "Wrong wind_gust!");
        Assertions.assertEquals(params.get("wind_gust"), response.getCurrent().getWindGust(), "Wrong wind_gust!");
    }

    @Then("weather information is:")
    public void check_weather_information (Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), response.getCurrent().getWeather().get(0).getId(), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeather().get(1).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeather().get(2).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeather().get(3).getIcon(), "Wrong icon!");
    }

    @Then("minutely weather data is:")
    public void check_minutely_weather(Map<String, Long> params) {
        Assertions.assertEquals(params.get("dt"), response.getMinutely().get(0), "Wrong id!");
        Assertions.assertEquals(params.get("precipitation"), response.getMinutely().get(1), "Wrong precipitation!");
    }

    @Then("hourly weather data is:")
    public void check_hourly_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getHours().get(0).getDt(), "Wrong dt!");
        Assertions.assertEquals(params.get("temp"), response.getHours().get(1).getTemp(), "Wrong temp!");
        Assertions.assertEquals(params.get("feels_like"), response.getHours().get(2).getFeelsLike(), "Wrong feels_like!");
        Assertions.assertEquals(params.get("pressure"), response.getHours().get(3).getPressure(), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), response.getHours().get(4).getHumidity(), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), response.getHours().get(5).getDewPoint(), "Wrong dew_point!");
        Assertions.assertEquals(params.get("uvi"), response.getHours().get(6).getUvi(), "Wrong uvi!");
        Assertions.assertEquals(params.get("clouds"), response.getHours().get(7).getClouds(), "Wrong clouds!");
        Assertions.assertEquals(params.get("visibility"), response.getHours().get(8).getVisibility(), "Wrong visibility!");
        Assertions.assertEquals(params.get("wind_speed"), response.getHours().get(9).getWindSpeed(), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), response.getHours().get(10).getWindDeg(), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), response.getHours().get(11).getWindGust(), "Wrong wind_gust!");
        Assertions.assertEquals(params.get("pop"), response.getHours().get(13).getPop(), "Wrong pop!");
    }

    @Then("hourly weather information is:")
    public void check_hourly_weather_information(Map<String, String> params){
        //kak sozdatj dlja spiska weather tut proverki ?
        Assertions.assertEquals(params.get("id"), response.getHours().get(13).getWeather().get(0).getId(), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getHours().get(13).getWeather().get(1).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getHours().get(13).getWeather().get(2).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getHours().get(13).getWeather().get(3).getIcon(), "Wrong icon!");
    }

    @Then("daily weather data is:")
    public void check_daily_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getDays().get(0).getDt(), "Wrong dt!");
        Assertions.assertEquals(params.get("sunrise"), response.getDays().get(1).getSunrise(), "Wrong sunrise!");
        Assertions.assertEquals(params.get("sunset"), response.getDays().get(2).getSunset(), "Wrong sunset!");
        Assertions.assertEquals(params.get("moonrise"), response.getDays().get(3).getMoonrise(), "Wrong moonrise!");
        Assertions.assertEquals(params.get("moonset"), response.getDays().get(4).getMoonset(), "Wrong moonset!");
        Assertions.assertEquals(params.get("moon_phase"), response.getDays().get(5).getMoonPhase(), "Wrong moon_phase!");
        Assertions.assertEquals(params.get("pressure"), response.getDays().get(8).getPressure(), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), response.getDays().get(9).getHumidity(), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), response.getDays().get(10).getDewPoint(), "Wrong dew_point!");
        Assertions.assertEquals(params.get("wind_speed"), response.getDays().get(11).getWindSpeed(), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), response.getDays().get(12).getWindDeg(), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), response.getDays().get(13).getWindGust(), "Wrong wind_gust!");
        Assertions.assertEquals(params.get("clouds"), response.getDays().get(15).getClouds(), "Wrong clouds!");
        Assertions.assertEquals(params.get("pop"), response.getDays().get(16).getPop(), "Wrong pop!");
        Assertions.assertEquals(params.get("rain"), response.getDays().get(17).getRain(), "Wrong rain!");
        Assertions.assertEquals(params.get("uvi"), response.getDays().get(18).getUvi(), "Wrong uvi!");
    }

    @Then ("temperature is:")
    public void check_temperature(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDays().get(6).getTemp().getDay(), "Wrong day!");
        Assertions.assertEquals(params.get("min"), response.getDays().get(6).getTemp().getMin(), "Wrong min!");
        Assertions.assertEquals(params.get("max"), response.getDays().get(6).getTemp().getMax(), "Wrong max!");
        Assertions.assertEquals(params.get("night"), response.getDays().get(6).getTemp().getNight(), "Wrong night!");
        Assertions.assertEquals(params.get("eve"), response.getDays().get(6).getTemp().getEve(), "Wrong eve!");
        Assertions.assertEquals(params.get("morn"), response.getDays().get(6).getTemp().getMorn(), "Wrong morn!");
    }

    @Then("feels like:")
    public void check_feels_like(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"),response.getDays().get(7).getFeelsLike().getDay(), "Wrong day!");
        Assertions.assertEquals(params.get("night"),response.getDays().get(7).getFeelsLike().getNight(), "Wrong night!");
        Assertions.assertEquals(params.get("eve"),response.getDays().get(7).getFeelsLike().getEve(), "Wrong eve!");
        Assertions.assertEquals(params.get("morn"),response.getDays().get(7).getFeelsLike().getMorn(), "Wrong morn!");
    }

    @Then("daily weather information is:")
    public void check_daily_weather_information(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), response.getDays().get(14).getWeather().get(0).getId(), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getDays().get(14).getWeather().get(1).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getDays().get(14).getWeather().get(2).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getDays().get(14).getWeather().get(3).getIcon(), "Wrong icon!");
    }

    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName(), "Wrong sender_name!");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(1).getEvent(), "Wrong event!");
        Assertions.assertEquals(params.get("start"), response.getAlerts().get(2).getStart(), "Wrong start!");
        Assertions.assertEquals(params.get("end"), response.getAlerts().get(3).getEnd(), "Wrong end!");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(4).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(4).getDescription(), "Wrong description!");
    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {
        Assertions.assertEquals("Sunny", response.getAlerts().get(5).getTags().get(0), "Wrong tag!");
        Assertions.assertEquals("Clouds", response.getAlerts().get(5).getTags().get(1), "Wrong tag!");
    }
}
