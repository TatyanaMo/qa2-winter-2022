package hw2transport;

import org.junit.jupiter.api.Test;

public class PracticeWithObjects {
@Test
    public void workingWithObjects () {
    Transport firstTransport = new Transport("Car", 10, 70);
    Transport secondTransport = new Transport("Train", 200, 6350);
    Transport thirdTransport = new Transport("Plane", 1700, 90770);

    Routes firstRoute = new Routes("Route1", "Riga", "Ventspils", 198);
    Routes secondRoute = new Routes("Route2", "Tallinn", "Budapest", 1830);
    Routes thirdRoute = new Routes("Route3", "Moscow", "Vladivostok", 9162);


    System.out.println("Transport1+Route1:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());

    double carLitresForRouteOne = firstTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport1+Route2:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());

    double carLitresForRouteTwo = firstTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport1+Route3:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    double carLitresForRouteThree = firstTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (firstTransport.getTankVolume() < carLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport2+Route1:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
    double trainLitresForRouteOne = secondTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport2+Route2:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
    double trainLitresForRouteTwo = secondTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport2+Route3:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    double trainLitresForRouteThree = secondTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (secondTransport.getTankVolume() < trainLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route1:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
    double planeLitresForRouteOne = thirdTransport.getFuelConsumption() / 100 * firstRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route2:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
    double planeLitresForRouteTwo = thirdTransport.getFuelConsumption() / 100 * secondRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route3:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
    double planeLitresForRouteThree = thirdTransport.getFuelConsumption() / 100 * thirdRoute.getDistance();
    if (thirdTransport.getTankVolume() < planeLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
        }
    }
}
