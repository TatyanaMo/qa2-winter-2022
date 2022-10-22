package hw2transport;

import org.junit.jupiter.api.Test;

public class PracticeWithObjects {
@Test
    public void workingWithObjects () {

    Transport firstTransport = new Transport();
    firstTransport.setVehicleType("Car");
    firstTransport.setFuelConsumption(10);
    firstTransport.setTankVolume(70);
        /* carFC - eto fuel consumption/100 dlja transporta 1 ( car)
           carTank - eto objem baka u transporta 1 (car)
         */
    double carFC = firstTransport.getFuelConsumption() / 100;
    double carTank = firstTransport.getTankVolume();


    Transport secondTransport = new Transport();
    secondTransport.setVehicleType("Train");
    secondTransport.setFuelConsumption(200);
    secondTransport.setTankVolume(6350);
         /* trainFC - eto fuel consumption/100 dlja transporta 2 ( train)
           trainTank - eto objem baka u transporta 2 (train)
         */
    double trainFC = secondTransport.getFuelConsumption() / 100;
    double trainTank = secondTransport.getTankVolume();


    Transport thirdTransport = new Transport();
    thirdTransport.setVehicleType("Plane");
    thirdTransport.setFuelConsumption(1700);
    thirdTransport.setTankVolume(90770);
         /* plainFC  - eto fuel consumption/100 dlja transporta 3 (plane)
           plainTank - eto objem baka u transporta 2 (plane
           */
    double planeFC = thirdTransport.getFuelConsumption() / 100;
    double planeTank = thirdTransport.getTankVolume();


    Routes firstRoute = new Routes();
    firstRoute.setRouteName("Route1");
    firstRoute.setStartPoint("Riga");
    firstRoute.setEndPoint("Ventspils");
    firstRoute.setDistance(198);
    // distanceRouteOne - distancija marshruta 1
    double distanceRouteOne = firstRoute.getDistance();


    Routes secondRoute = new Routes();
    secondRoute.setRouteName("Route2");
    secondRoute.setStartPoint("Tallinn");
    secondRoute.setEndPoint("Budapest");
    secondRoute.setDistance(1830);
    //distanceRouteTwo - distancija marshruta 2
    double distanceRouteTwo = secondRoute.getDistance();

    Routes thirdRoute = new Routes();
    thirdRoute.setRouteName("Route3");
    thirdRoute.setStartPoint("Moscow");
    thirdRoute.setEndPoint("Vladivostok");
    thirdRoute.setDistance(9162);
    //distanceRouteThree - distancija marshruta 3
    double distanceRouteThree = thirdRoute.getDistance();


    //-------------------VIVOD V KONSOLJ-----------------

    System.out.println("Transport1+Route1:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
        /*
         carLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double carLitresForRouteOne = carFC * distanceRouteOne;
    if (carTank < carLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport1+Route2:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
        /*
         carLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double carLitresForRouteTwo = carFC * distanceRouteTwo;
    if (carTank < carLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport1+Route3:");
    System.out.println(firstTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
        /*
         carLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double carLitresForRouteThree = carFC * distanceRouteThree;
    if (carTank < carLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport2+Route1:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
        /*
         trainLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double trainLitresForRouteOne = trainFC * distanceRouteOne;
    if (trainTank < trainLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport2+Route2:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
        /*
        trainLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
         */
    double trainLitresForRouteTwo = trainFC * distanceRouteTwo;
    if (trainTank < trainLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport2+Route3:");
    System.out.println(secondTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
        /*
        trainLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double trainLitresForRouteThree = trainFC * distanceRouteThree;
    if (trainTank < trainLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }


    System.out.println("Transport3+Route1:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(firstRoute.getStartPoint() + "-" + firstRoute.getEndPoint());
        /*
        planeLitresForRouteOne - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double planeLitresForRouteOne = planeFC * distanceRouteOne;
    if (planeTank < planeLitresForRouteOne) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route2:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(secondRoute.getStartPoint() + "-" + secondRoute.getEndPoint());
        /*
        planeLitresForRouteTwo - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double planeLitresForRouteTwo = planeFC * distanceRouteTwo;
    if (planeTank < planeLitresForRouteTwo) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
    }

    System.out.println("Transport3+Route3:");
    System.out.println(thirdTransport.getVehicleType());
    System.out.println(thirdRoute.getStartPoint() + "-" + thirdRoute.getEndPoint());
        /*
        planeLitresForRouteThree - eto kol-vo litrov, neobxodimoe transportu dlja proezda marshruta
        */
    double planeLitresForRouteThree = planeFC * distanceRouteThree;
    if (planeTank < planeLitresForRouteThree) {
        System.out.println("don't pass the route on one fuel tank");
    } else {
        System.out.println("pass the route on one fuel tank");
        }
    }
}
