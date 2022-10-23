package hw2transport;

import org.junit.jupiter.api.Test;

public class PracticeWithObjects {
@Test
    public void workingWithObjects () {

    Transport firstTransport = new Transport();
    firstTransport.setVehicleType("Car");
    firstTransport.setFuelConsumption(10);
    firstTransport.setTankVolume(70);

    Transport secondTransport = new Transport();
    secondTransport.setVehicleType("Train");
    secondTransport.setFuelConsumption(200);
    secondTransport.setTankVolume(6350);

    Transport thirdTransport = new Transport();
    thirdTransport.setVehicleType("Plane");
    thirdTransport.setFuelConsumption(1700);
    thirdTransport.setTankVolume(90770);


    Routes firstRoute = new Routes();
    firstRoute.setRouteName("Route1");
    firstRoute.setStartPoint("Riga");
    firstRoute.setEndPoint("Ventspils");
    firstRoute.setDistance(198);

    Routes secondRoute = new Routes();
    secondRoute.setRouteName("Route2");
    secondRoute.setStartPoint("Tallinn");
    secondRoute.setEndPoint("Budapest");
    secondRoute.setDistance(1830);

    Routes thirdRoute = new Routes();
    thirdRoute.setRouteName("Route3");
    thirdRoute.setStartPoint("Moscow");
    thirdRoute.setEndPoint("Vladivostok");
    thirdRoute.setDistance(9162);


    //-------------------VIVOD V KONSOLJ-----------------

    System.out.println("Transport1+Route1:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
    // carLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double carLitresForRouteOne = firstTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport1+Route2:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
    //carLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double carLitresForRouteTwo = firstTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport1+Route3:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    //carLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double carLitresForRouteThree = firstTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport2+Route1:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
    //trainLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double trainLitresForRouteOne = secondTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport2+Route2:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
        //trainLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double trainLitresForRouteTwo = secondTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport2+Route3:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    // trainLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double trainLitresForRouteThree = secondTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport3+Route1:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
    // planeLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double planeLitresForRouteOne = thirdTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route2:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
    //planeLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double planeLitresForRouteTwo = thirdTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route3:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    //planeLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
    double planeLitresForRouteThree = thirdTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
        }
    }
}
