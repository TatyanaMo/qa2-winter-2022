package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.*;

import java.util.Map;

public class TicketsStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; // null
    private PassengerInfoPage passengerInfoPage;
    private FlightInfoPage flightInfoPage;
    private SeatSelectionPage seatSelectionPage;
    private RegistrationConfirmationPage registrationConfirmationPage;


    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "http://www.qaguru.lv:8089/tickets/";


    @Given("flight info:")
    public void set_flight_info(Map<String,String> params) {
        flightInfo = new FlightInfo(params.get("departure"), params.get("destination"), params.get("discount"),
                Integer.parseInt(params.get("adults")), Integer.parseInt(params.get("children")),Integer.parseInt(params.get("bags")),
                params.get("flight date"), Integer.parseInt(params.get("seat")));
    }

    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params){
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        passengerInfoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void check_airports() {
        Assertions.assertEquals(flightInfo.getDeparture(), passengerInfoPage.getFromAirport(), "Airports 'From' not equals!");
        Assertions.assertEquals(flightInfo.getDestination(), passengerInfoPage.getToAirport(), "Airports 'To' not equals!");
    }

    @When("we are filling in passenger registration form")
    public void fill_in_passenger_registration_form() {
        passengerInfoPage.fillInPassengerInfo(flightInfo);
        flightInfo.getPassenger().getFirstName();
        flightInfo.getPassenger().getLastName();
        flightInfo.getDiscount();
        flightInfo.getAdultsCount();
        flightInfo.getChildCount();
        flightInfo.getBagsCount();
        flightInfo.getFlightDate();
    }
    @And("requesting price")
    public void request_price() {
        flightInfoPage = new FlightInfoPage(baseFunc);
        passengerInfoPage.getPrice();
    }

    @Then("passenger name and airports appears")
    public void check_passenger_info_and_airports_and_price () {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), flightInfoPage.getPassengerName(), "Name not equal!");
        Assertions.assertEquals(passengerInfoPage.getFromAirport(), flightInfoPage.getFromAirport2(), "Airports 'From' not equals!");
        Assertions.assertEquals(passengerInfoPage.getToAirport(), flightInfoPage.getToAirport2(), "Airports 'To' not equals!");
    }
    @And("price is 500 EUR")
    public void check_price () {
        Assertions.assertEquals(flightInfoPage.getPrice(), 500, "Price not correct");
    }

    @When("we are pressing Book button")
    public void confirm_booking() {
        flightInfoPage.book();
    }
    @And("selecting seat")
    public void select_seat() {
        seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(flightInfo.getSeatNr());
    }

    @Then("correct seat number appears")
    public void check_seat_nr() {
        Assertions.assertEquals(seatSelectionPage.getSelectedSeatNr(), flightInfo.getSeatNr(), "seat Nr not correct!");
    }

    @When("we are booking selected ticket")
    public void booking_tickets() {
        registrationConfirmationPage = new RegistrationConfirmationPage(baseFunc);
        seatSelectionPage.book();
    }

    @Then("successful registration message appears")
    public void check_successful_registration_message() {
       Assertions.assertTrue(registrationConfirmationPage.isSuccessfulRegistrationTextAppears(),
               "Wrong text on registration confirmation page!" );
    }
}
