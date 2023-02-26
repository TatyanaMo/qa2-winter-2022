package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;
import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

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
        Assertions.assertEquals(params.get("timezone_offset"), String.valueOf(response.getTimezoneOffset()), "Wrong timezone_offset!");
    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), String.valueOf(response.getCurrent().getDt()), "Wrong dt!");
        Assertions.assertEquals(params.get("sunrise"), String.valueOf(response.getCurrent().getSunrise()), "Wrong sunrise!");
        Assertions.assertEquals(params.get("sunset"), String.valueOf(response.getCurrent().getSunset()), "Wrong sunset!");
        Assertions.assertEquals(params.get("temp"), String.valueOf(response.getCurrent().getTemp()), "Wrong temp!");
        Assertions.assertEquals(params.get("feels_like"), String.valueOf(response.getCurrent().getFeelsLike()), "Wrong feels_like!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getCurrent().getPressure()), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"),String.valueOf(response.getCurrent().getHumidity()), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getCurrent().getDewPoint()), "Wrong dew_point!");
        Assertions.assertEquals(params.get("uvi"), String.valueOf(response.getCurrent().getUvi()), "Wrong uvi!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getCurrent().getClouds()), "Wrong clouds!");
        Assertions.assertEquals(params.get("visibility"), String.valueOf(response.getCurrent().getVisibility()), "Wrong visibility!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getCurrent().getWindSpeed()), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getCurrent().getWindDeg()), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getCurrent().getWindGust()), "Wrong wind_gust!");

    }

    @Then("weather information is:")
    public void check_weather_information (Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"),response.getCurrent().getWeathers().get(0).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "Wrong icon!");
    }

    @Then("minutely weather data is:")
    public void check_minutely_weather(Map<String, Long> params) {
        Assertions.assertEquals(params.get("dt"), response.getMinutely().get(0).getDt(), "Wrong id!");
        Assertions.assertEquals(params.get("precipitation"), response.getMinutely().get(0).getPrecipitation(), "Wrong precipitation!");
    }

    @Then("hourly weather data is:")
    public void check_hourly_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), String.valueOf(response.getHours().get(0).getDt()), "Wrong dt!");
        Assertions.assertEquals(params.get("temp"), String.valueOf(response.getHours().get(0).getTemp()), "Wrong temp!");
        Assertions.assertEquals(params.get("feels_like"), String.valueOf(response.getHours().get(0).getFeelsLike()), "Wrong feels_like!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getHours().get(0).getPressure()), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), String.valueOf(response.getHours().get(0).getHumidity()), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getHours().get(0).getDewPoint()), "Wrong dew_point!");
        Assertions.assertEquals(params.get("uvi"), String.valueOf(response.getHours().get(0).getUvi()), "Wrong uvi!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getHours().get(0).getClouds()), "Wrong clouds!");
        Assertions.assertEquals(params.get("visibility"), String.valueOf(response.getHours().get(0).getVisibility()), "Wrong visibility!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getHours().get(0).getWindSpeed()), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getHours().get(0).getWindDeg()), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getHours().get(0).getWindGust()), "Wrong wind_gust!");
        Assertions.assertEquals(params.get("pop"), String.valueOf(response.getHours().get(0).getPop()), "Wrong pop!");
    }

    @Then("hourly weather information is:")
    public void check_hourly_weather_information(Map<String, String> params){
        Assertions.assertEquals(params.get("id"), String.valueOf(response.getHours().get(0).getWeather().get(0).getId()), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getHours().get(0).getWeather().get(0).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getHours().get(0).getWeather().get(0).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getHours().get(0).getWeather().get(0).getIcon(), "Wrong icon!");
    }

    @Then("daily weather data is:")
    public void check_daily_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), String.valueOf(response.getDays().get(0).getDt()), "Wrong dt!");
        Assertions.assertEquals(params.get("sunrise"), String.valueOf(response.getDays().get(0).getSunrise()), "Wrong sunrise!");
        Assertions.assertEquals(params.get("sunset"), String.valueOf(response.getDays().get(0).getSunset()), "Wrong sunset!");
        Assertions.assertEquals(params.get("moonrise"), String.valueOf(response.getDays().get(0).getMoonrise()), "Wrong moonrise!");
        Assertions.assertEquals(params.get("moonset"), String.valueOf(response.getDays().get(0).getMoonset()), "Wrong moonset!");
        Assertions.assertEquals(params.get("moon_phase"), String.valueOf(response.getDays().get(0).getMoonPhase()), "Wrong moon_phase!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getDays().get(0).getPressure()), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), String.valueOf(response.getDays().get(0).getHumidity()), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getDays().get(0).getDewPoint()), "Wrong dew_point!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getDays().get(0).getWindSpeed()), "Wrong wind_speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getDays().get(0).getWindDeg()), "Wrong wind_deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getDays().get(0).getWindGust()), "Wrong wind_gust!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getDays().get(0).getClouds()), "Wrong clouds!");
        Assertions.assertEquals(params.get("pop"), String.valueOf(response.getDays().get(0).getPop()), "Wrong pop!");
        Assertions.assertEquals(params.get("rain"), String.valueOf(response.getDays().get(0).getRain()), "Wrong rain!");
        Assertions.assertEquals(params.get("uvi"), String.valueOf(response.getDays().get(0).getUvi()), "Wrong uvi!");
    }

    @Then ("temperature is:")
    public void check_temperature(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDays().get(0).getTemp().getDay(), "Wrong day!");
        Assertions.assertEquals(params.get("min"), response.getDays().get(0).getTemp().getMin(), "Wrong min!");
        Assertions.assertEquals(params.get("max"), response.getDays().get(0).getTemp().getMax(), "Wrong max!");
        Assertions.assertEquals(params.get("night"), response.getDays().get(0).getTemp().getNight(), "Wrong night!");
        Assertions.assertEquals(params.get("eve"), response.getDays().get(0).getTemp().getEve(), "Wrong eve!");
        Assertions.assertEquals(params.get("morn"), response.getDays().get(0).getTemp().getMorn(), "Wrong morn!");
    }

    @Then("feels like:")
    public void check_feels_like(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"),response.getDays().get(0).getFeelsLike().getDay(), "Wrong day!");
        Assertions.assertEquals(params.get("night"),response.getDays().get(0).getFeelsLike().getNight(), "Wrong night!");
        Assertions.assertEquals(params.get("eve"),response.getDays().get(0).getFeelsLike().getEve(), "Wrong eve!");
        Assertions.assertEquals(params.get("morn"),response.getDays().get(0).getFeelsLike().getMorn(), "Wrong morn!");
    }

    @Then("daily weather information is:")
    public void check_daily_weather_information(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), String.valueOf(response.getDays().get(0).getWeather().get(0).getId()), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getDays().get(0).getWeather().get(0).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getDays().get(0).getWeather().get(0).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), response.getDays().get(0).getWeather().get(0).getIcon(), "Wrong icon!");
    }

    @Then("alert received:")
    public void check_alert(Map<String, String> params) {
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName(), "Wrong sender_name!");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "Wrong event!");
        Assertions.assertEquals(params.get("start"), String.valueOf(response.getAlerts().get(0).getStart()), "Wrong start!");
        Assertions.assertEquals(params.get("end"), String.valueOf(response.getAlerts().get(0).getEnd()), "Wrong end!");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription(), "Wrong description!");
        Assertions.assertTrue(response.getAlerts().get(0).getTags().isEmpty(), "list not empty");
    }
}
