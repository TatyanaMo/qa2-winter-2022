package stepdefs;


import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.*;
import requesters.TicketsRequester;
import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private FlightInfo flightInfo;
    private HomePage homePage;
    private PassengerInfoPage passengerInfoPage;
    private FlightInfoPage flightInfoPage;
    private SeatSelectionPage seatSelectionPage;
    private RegistrationConfirmationPage registrationConfirmationPage;

    private List<Reservation> reservations;
    private Reservation reservationFromApi;

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
    }
    @When("requesting price")
    public void request_price() {
        passengerInfoPage.getPrice();
        flightInfoPage = new FlightInfoPage(baseFunc);
    }

    @Then("passenger name and airports appears")
    public void check_passenger_info_and_airports_and_price () {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), flightInfoPage.getPassengerName(), "Name not equal!");
        Assertions.assertEquals(passengerInfoPage.getFromAirport(), flightInfoPage.getFromAirport2(), "Airports 'From' not equals!");
        Assertions.assertEquals(passengerInfoPage.getToAirport(), flightInfoPage.getToAirport2(), "Airports 'To' not equals!");
    }
    @Then("price is 1080 EUR")
    public void check_price () {
        Assertions.assertEquals(flightInfoPage.getPrice(), String.valueOf(1080), "Price different!");
    }

    @When("we are pressing Book button")
    public void confirm_booking() {
        flightInfoPage.book();
        seatSelectionPage = new SeatSelectionPage(baseFunc);
    }
    @When("selecting seat")
    public void select_seat() {
        seatSelectionPage.selectSeat(flightInfo.getSeatNr());
        registrationConfirmationPage = new RegistrationConfirmationPage(baseFunc);
    }

    @Then("correct seat number appears")
    public void check_seat_nr() {
        Assertions.assertEquals(seatSelectionPage.getSelectedSeatNr(), flightInfo.getSeatNr(), "seat Nr not correct!");
    }

    @When("we are booking selected ticket")
    public void booking_tickets() {
        seatSelectionPage.book();
    }

    @Then("successful registration message appears")
    public void check_successful_registration_message() {
       Assertions.assertTrue(registrationConfirmationPage.isSuccessfulRegistrationTextAppears(),
               "Wrong text on registration confirmation page!" );
    }

    @When("we are requesting reservations data")
    public void request_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation is in the list")
    public void find_reservation(){
        for (Reservation r : reservations) {
            if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
              reservationFromApi = r;
              break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "reservation not found!");
    }

    @Then("all reservation data is correct")
    public void check_reservation_data() {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), reservationFromApi.getName(), "Wrong name!");
        Assertions.assertEquals(flightInfo.getPassenger().getLastName(), reservationFromApi.getSurname(), "Wrong surname!");
        Assertions.assertEquals(flightInfo.getDeparture(), reservationFromApi.getDeparture(), "Wrong Fron airports!");
        Assertions.assertEquals(flightInfo.getDestination(),reservationFromApi.getArrival(), "Wrong To airport!");
        Assertions.assertEquals(flightInfo.getBagsCount(), reservationFromApi.getBagCount(), "Wrong bags!");
        Assertions.assertEquals(flightInfo.getDiscount(),reservationFromApi.getDiscount(), "Wrong discount!");
        Assertions.assertEquals(flightInfo.getChildCount(), reservationFromApi.getChildren(), "Wrong children!");
        Assertions.assertEquals(flightInfo.getFlightDate().substring(0,2), reservationFromApi.getFlight(), "Wrong date!");
        Assertions.assertEquals(flightInfo.getAdultsCount(), reservationFromApi.getAdults(),"Wrong adults!");
        Assertions.assertEquals(flightInfo.getSeatNr(), reservationFromApi.getSeat(), "Wrong seat!");
    }

}
