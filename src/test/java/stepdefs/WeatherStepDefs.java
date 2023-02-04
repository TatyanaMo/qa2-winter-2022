package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {
    @Given("city ID is: {long}")
    public void set_city_id(long id) {

    }

    @When("we are requesting weather forecast")
    public void request_weather() {

    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {

    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {

    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {

    }

    @Then("weather information is:")
    public void check_weather_information (Map<String, String> params) {

    }

    @Then("minutely weather data is:")
    public void check_minutely_weather(Map<String, Long> params) {

    }

    @Then("hourly weather data is:")
    public void check_hourly_weather(Map<String, String> params) {

    }

    @Then("hourly weather information is:")
    public void check_hourly_weather_information(Map<String, String> params){

    }

    @Then("daily weather data is:")
    public void check_daily_weather(Map<String, Long> params) {

    }

    @Then ("temperature is:")
    public void check_temperature(Map<String, Double> params) {

    }

    @Then("feels like:")
    public void check_feels_like(Map<String, Double> params) {

    }

    @Then("daily weather information is:")
    public void check_daily_weather_information(Map<String, String> params) {

    }

    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {

    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {

    }
}
