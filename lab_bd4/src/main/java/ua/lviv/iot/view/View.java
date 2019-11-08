package ua.lviv.iot.view;

import org.hibernate.Session;
import ua.lviv.iot.Printable;
import ua.lviv.iot.controller.*;
import ua.lviv.iot.controller.implementetion.*;
import ua.lviv.iot.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private CityController cityController = new CityControllerImpl();
    private ClientController clientController = new ClientControllerImpl();
    private GuideController guideController = new GuideControllerImpl();
    private HotelController hotelController = new HotelControllerImpl();
    private RoomTypeController roomTypeController = new RoomTypeControllerImpl();
    private RouteCotroller routeController = new RouteControllerImpl();
    private RouteGuideController routeGuideController = new RouteGuideControllerImpl();
    private RouteTypeController routeTypeController = new RouteTypeControllerImpl();
    private StopPointController stopPointController = new StopPointControllerImpl();
    private TourController tourController = new TourControllerImpl();
    private CountryController countryController = new CountryControllerImpl();

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View(Session session) {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("01", "  01 - Table: City");
        menu.put("11", "  11 - Create for City");
        menu.put("12", "  12 - Update City");
        menu.put("13", "  13 - Delete from City");
        menu.put("14", "  14 - Select City");
        menu.put("15", "  15 - Find City by ID");

        menu.put("02", "  02 - Table: Client");
        menu.put("21", "  21 - Create for Client");
        menu.put("22", "  22 - Update Client");
        menu.put("23", "  23 - Delete from Client");
        menu.put("24", "  24 - Select Client");
        menu.put("25", "  25 - Find Client by ID");

        menu.put("03", "  03 - Table: Guide");
        menu.put("31", "  31 - Create for Guide");
        menu.put("32", "  32 - Update Guide");
        menu.put("33", "  33 - Delete from Guide");
        menu.put("34", "  34 - Select Guide");
        menu.put("35", "  35 - Find Guide by ID");
        menu.put("36", "  26 - Find Guide by Name");
        menu.put("37", "  37 - Find Guide by Sex");

        menu.put("04", "  04 - Table: Hotel");
        menu.put("41", "  41 - Create for Hotel");
        menu.put("42", "  42 - Update Hotel");
        menu.put("43", "  43 - Delete from Hotel");
        menu.put("44", "  44 - Select Hotel");
        menu.put("45", "  45 - Find Hotel by ID");

        menu.put("06", "  06 - Table: RoomType");
        menu.put("61", "  61 - Create for RoomType");
        menu.put("62", "  62 - Update RoomType");
        menu.put("63", "  63 - Delete from RoomType");
        menu.put("64", "  64 - Select RoomType");
        menu.put("65", "  65 - Find RoomType by ID");

        menu.put("07", "  07 - Table: Route");
        menu.put("71", "  71 - Create for Route");
        menu.put("72", "  72 - Update Route");
        menu.put("73", "  73 - Delete from Route");
        menu.put("74", "  74 - Select Route");
        menu.put("75", "  75 - Find Route by ID");

        menu.put("08", "  08 - Table: RouteGuide");
        menu.put("81", "  81 - Create for RouteGuide");
        menu.put("82", "  82 - Update RouteGuide");
        menu.put("83", "  83 - Delete from RouteGuide");
        menu.put("84", "  84 - Select RouteGuide");
        menu.put("85", "  85 - Find RouteGuide by Guide ID");
        menu.put("86", "  86 - Find RouteGuide by Route ID");

        menu.put("010", "  010 - Table: RouteType");
        menu.put("101", "  101 - Create for RouteType");
        menu.put("102", "  102 - Update RouteType");
        menu.put("103", "  103 - Delete from RouteType");
        menu.put("104", "  104 - Select RouteType");
        menu.put("105", "  105 - Find RouteType by ID");
        menu.put("106", "  106 - Find RouteType by Name");

        menu.put("011", "  011 - Table: StopPoint");
        menu.put("111", "  111 - Create for StopPoint");
        menu.put("112", "  112 - Update StopPoint");
        menu.put("113", "  113 - Delete from StopPoint");
        menu.put("114", "  114 - Select StopPoint");
        menu.put("115", "  115 - Find StopPoint by ID");

        menu.put("013", "  013 - Table: Tour");
        menu.put("131", "  131 - Create for Tour");
        menu.put("132", "  132 - Update Tour");
        menu.put("133", "  133 - Delete from Tour");
        menu.put("134", "  134 - Select Tour");
        menu.put("135", "  135 - Find Tour by ID");

        menu.put("014", "  014 - Table: Country");
        menu.put("141", "  141 - Create for Country");
        menu.put("142", "  142 - Update Country");
        menu.put("143", "  143 - Delete from Country");
        menu.put("144", "  144 - Select Country");
        menu.put("145", "  145 - Find Country by ID");

        
        methodsMenu.put("11", () -> createForCity(session));
        methodsMenu.put("12", () -> updateCity(session));
        methodsMenu.put("13", () -> deleteFromCity(session));
        methodsMenu.put("14", () -> selectCity(session));
        methodsMenu.put("15", () -> findCityByID(session));
        
        methodsMenu.put("21", () -> createForClient(session));
        methodsMenu.put("22", () -> updateClient(session));
        methodsMenu.put("23", () -> deleteFromClient(session));
        methodsMenu.put("24", () -> selectClient(session));
        methodsMenu.put("25", () -> findClientByID(session));
        
        methodsMenu.put("31", () -> createForGuide(session));
        methodsMenu.put("32", () -> updateGuide(session));
        methodsMenu.put("33", () -> deleteFromGuide(session));
        methodsMenu.put("34", () -> selectGuide(session));
        methodsMenu.put("35", () -> findGuideByID(session));
        
        methodsMenu.put("41", () -> createForHotel(session));
        methodsMenu.put("42", () -> updateHotel(session));
        methodsMenu.put("43", () -> deleteFromHotel(session));
        methodsMenu.put("44", () -> selectHotel(session));
        methodsMenu.put("45", () -> findHotelByID(session));
        
        methodsMenu.put("61", () -> createForRoomType(session));
        methodsMenu.put("62", () -> updateRoomType(session));
        methodsMenu.put("63", () -> deleteFromRoomType(session));
        methodsMenu.put("64", () -> selectRoomType(session));
        methodsMenu.put("65", () -> findRoomTypeByID(session));
        
        methodsMenu.put("71", () -> createForRoute(session));
        methodsMenu.put("72", () -> updateRoute(session));
        methodsMenu.put("73", () -> deleteFromRoute(session));
        methodsMenu.put("74", () -> selectRoute(session));
        methodsMenu.put("75", () -> findRouteByID(session));
        
        methodsMenu.put("101", () -> createForRouteType(session));
        methodsMenu.put("102", () -> updateRouteType(session));
        methodsMenu.put("103", () -> deleteFromRouteType(session));
        methodsMenu.put("104", () -> selectRouteType(session));
        methodsMenu.put("105", () -> findRouteTypeByID(session));
        
        methodsMenu.put("111", () -> createForStopPoint(session));
        methodsMenu.put("112", () -> updateStopPoint(session));
        methodsMenu.put("113", () -> deleteFromStopPoint(session));
        methodsMenu.put("114", () -> selectStopPoint(session));
        methodsMenu.put("115", () -> findStopPointByID(session));

        methodsMenu.put("131", () -> createForTour(session));
        methodsMenu.put("132", () -> updateTour(session));
        methodsMenu.put("133", () -> deleteFromTour(session));
        methodsMenu.put("134", () -> selectTour(session));
        methodsMenu.put("135", () -> findTourByID(session));
        
        methodsMenu.put("141", () -> createForCountry(session));
        methodsMenu.put("142", () -> updateCountry(session));
        methodsMenu.put("143", () -> deleteFromCountry(session));
        methodsMenu.put("144", () -> selectCountry(session));
        methodsMenu.put("145", () -> findCountryByID(session));
    }

    private void deleteFromCity(Session session) throws SQLException {
        System.out.println("Input ID for City: ");
        int id = input.nextInt();
        input.nextLine();
        cityController.delete(id, session);
    }

    private void createForCity(Session session) throws SQLException {
        System.out.println("Input cityName for City: ");
        String cityName = input.nextLine();
        System.out.println("Input cityCountryId for City: ");
        int cityCountryId = input.nextInt();
        input.nextLine();
        City entity = new City(0, cityName, cityCountryId);
        cityController.create(entity, session);
    }

    private void updateCity(Session session) throws SQLException {
        System.out.println("Input cityId for City: ");
        int cityId = input.nextInt();
        input.nextLine();
        System.out.println("Input cityName for City: ");
        String cityName = input.nextLine();
        System.out.println("Input cityCountryId for City: ");
        int cityCountryId = input.nextInt();
        input.nextLine();
        City entity = new City(cityId, cityName, cityCountryId);
        cityController.update(entity, session);
    }

    private void selectCity(Session session) throws SQLException {
        System.out.println("\nTable: City");
        cityController.select(session);
    }

    private void findCityByID(Session session) throws SQLException {
        System.out.println("Input ID for City: ");
        int id = input.nextInt();
        input.nextLine();
        cityController.findById(id, session);
    }

    private void deleteFromClient(Session session) throws SQLException {
        System.out.println("Input ID for Client: ");
        int id = input.nextInt();
        input.nextLine();
        clientController.delete(id, session);
    }

    private void createForClient(Session session) throws SQLException {
        System.out.println("Input ClientFirstName for Client: ");
        String ClientFirstName = input.nextLine();
        System.out.println("Input ClientLastName for Client: ");
        String clientLastName = input.nextLine();
        System.out.println("Input clientBirthday(yyyy-MM-dd) for Client: ");
        Date clientBirthday = Date.valueOf(input.next());
        Client entity = new Client(0, ClientFirstName, clientLastName, clientBirthday);
        clientController.create(entity, session);
    }

    private void updateClient(Session session) throws SQLException, ParseException {
        System.out.println("Input ClientId for Client: ");
        int clientId = input.nextInt();
        input.nextLine();
        System.out.println("Input ClientFirstName for Client: ");
        String ClientFirstName = input.nextLine();
        System.out.println("Input ClientLastName for Client: ");
        String clientLastName = input.nextLine();
        System.out.println("Input clientBirthday(yyyy-MM-dd) for Client: ");
        Date clientBirthday = Date.valueOf(input.next());
        Client entity = new Client(clientId, ClientFirstName, clientLastName, clientBirthday);
        clientController.update(entity, session);
    }

    private void selectClient(Session session) throws SQLException {
        System.out.println("\nTable: Client");
        clientController.select(session);
    }

    private void findClientByID(Session session) throws SQLException {
        System.out.println("Input ID for Client: ");
        int id = input.nextInt();
        input.nextLine();
        clientController.findById(id, session);
    }

    private void deleteFromGuide(Session session) throws SQLException {
        System.out.println("Input ID for Guide: ");
        int id = input.nextInt();
        input.nextLine();
        guideController.delete(id, session);
    }

    private void createForGuide(Session session) throws SQLException {
        System.out.println("Input guideFirstName for Guide: ");
        String guideFirstName = input.nextLine();
        System.out.println("Input guideLastName for Guide: ");
        String guideLastName = input.nextLine();
        System.out.println("Input GuideBirthday for Guide: ");
        Date guideBirthday = Date.valueOf(input.next());
        System.out.println("Input Sex for Guide: ");
        String guideSex = input.next();
        Guide entity = new Guide(0, guideFirstName, guideLastName, guideBirthday, guideSex);
        guideController.create(entity, session);
    }

    private void updateGuide(Session session) throws SQLException {
        System.out.println("Input GuideId for Guide: ");
        int guideId = input.nextInt();
        input.nextLine();
        System.out.println("Input guideFirstName for Guide: ");
        String guideFirstName = input.nextLine();
        System.out.println("Input guideLastName for Guide: ");
        String guideLastName = input.nextLine();
        System.out.println("Input GuideBirthday for Guide: ");
        Date guideBirthday = Date.valueOf(input.next());
        System.out.println("Input Sex for Guide: ");
        String guideSex = input.next();
        Guide entity = new Guide(guideId, guideFirstName, guideLastName, guideBirthday, guideSex);
        guideController.update(entity, session);
    }

    private void selectGuide(Session session) throws SQLException {
        System.out.println("\nTable: Guide");
        guideController.select(session);
    }

    private void findGuideByID(Session session) throws SQLException {
        System.out.println("Input ID for Guide: ");
        int id = input.nextInt();
        input.nextLine();
        guideController.findById(id, session);
    }

    private void deleteFromHotel(Session session) throws SQLException {
        System.out.println("Input ID for Hotel: ");
        int id = input.nextInt();
        input.nextLine();
        hotelController.delete(id, session);
    }

    private void createForHotel(Session session) throws SQLException {
        System.out.println("Input HotelName for Hotel: ");
        String HotelName = input.nextLine();
        System.out.println("Input HotelCityId for Hotel: ");
        int HotelCityId = input.nextInt();
        input.nextLine();
        Hotel entity = new Hotel(0, HotelName, HotelCityId);
        hotelController.create(entity, session);
    }

    private void updateHotel(Session session) throws SQLException {
        System.out.println("Input HotelId for Hotel: ");
        int HotelId = input.nextInt();
        input.nextLine();
        System.out.println("Input HotelName for Hotel: ");
        String HotelName = input.nextLine();
        System.out.println("Input HotelCityId for Hotel: ");
        int HotelCityId = input.nextInt();
        input.nextLine();
        Hotel entity = new Hotel(HotelId, HotelName, HotelCityId);
        hotelController.update(entity, session);
    }

    private void selectHotel(Session session) throws SQLException {
        System.out.println("\nTable: Hotel");
        hotelController.select(session);
    }

    private void findHotelByID(Session session) throws SQLException {
        System.out.println("Input ID for Hotel: ");
        int id = input.nextInt();
        input.nextLine();
        hotelController.findById(id, session);
    }

    private void deleteFromRoomType(Session session) throws SQLException {
        System.out.println("Input ID for RoomType: ");
        int id = input.nextInt();
        input.nextLine();
        roomTypeController.delete(id, session);
    }

    private void createForRoomType(Session session) throws SQLException {
        System.out.println("Input roomTypeName for RoomType: ");
        String roomTypeName = input.nextLine();
        System.out.println("Input personAmount for RoomType: ");
        int personAmount = input.nextInt();
        input.nextLine();
        RoomType entity = new RoomType(0, roomTypeName, personAmount);
        roomTypeController.create(entity, session);
    }

    private void updateRoomType(Session session) throws SQLException {
        System.out.println("Input roomTypeId for RoomType: ");
        int roomTypeId = input.nextInt();
        input.nextLine();
        System.out.println("Input roomTypeName for RoomType: ");
        String roomTypeName = input.nextLine();
        System.out.println("Input roomTypeCountryId for RoomType: ");
        int personAmount = input.nextInt();
        input.nextLine();
        RoomType entity = new RoomType(roomTypeId, roomTypeName, personAmount);
        roomTypeController.update(entity, session);
    }

    private void selectRoomType(Session session) throws SQLException {
        System.out.println("\nTable: RoomType");
        roomTypeController.select(session);
    }

    private void findRoomTypeByID(Session session) throws SQLException {
        System.out.println("Input ID for RoomType: ");
        int id = input.nextInt();
        input.nextLine();
        roomTypeController.findById(id, session);
    }

    private void deleteFromRoute(Session session) throws SQLException {
        System.out.println("Input ID for Route: ");
        int id = input.nextInt();
        input.nextLine();
        routeController.delete(id, session);
    }

    private void createForRoute(Session session) throws SQLException {
        System.out.println("Input description for Route: ");
        String description = input.nextLine();
        System.out.println("Input routeCountryId for Route: ");
        int routeCountryId = input.nextInt();
        input.nextLine();
        Route entity = new Route(0, description, routeCountryId);
        routeController.create(entity, session);
    }

    private void updateRoute(Session session) throws SQLException {
        System.out.println("Input routeId for Route: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeName for Route: ");
        String routeName = input.nextLine();
        System.out.println("Input routeCountryId for Route: ");
        int routeCountryId = input.nextInt();
        input.nextLine();
        Route entity = new Route(routeId, routeName, routeCountryId);
        routeController.update(entity, session);
    }

    private void selectRoute(Session session) throws SQLException {
        System.out.println("\nTable: Route");
        routeController.select(session);
    }

    private void findRouteByID(Session session) throws SQLException {
        System.out.println("Input ID for Route: ");
        int id = input.nextInt();
        input.nextLine();
        routeController.findById(id, session);
    }

    private void deleteFromRouteGuide(Session session) throws SQLException {
        System.out.println("Input ID for RouteGuide: ");
        int id = input.nextInt();
        input.nextLine();
        routeGuideController.delete(id, session);
    }

    private void createForRouteGuide(Session session) throws SQLException {
        System.out.println("Input guideId for RouteGuide: ");
        int guideId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeId for RouteGuide: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input startDate for Guide: ");
        Date startDate = Date.valueOf(input.nextLine());
        System.out.println("Input lastDate for Guide: ");
        Date lastDate = Date.valueOf(input.nextLine());
        RouteGuide entity = new RouteGuide(0, guideId, routeId, startDate, lastDate);
        routeGuideController.create(entity, session);
    }

    private void updateRouteGuide(Session session) throws SQLException {
        System.out.println("Input routeGuideId for RouteGuide: ");
        int routeGuideId = input.nextInt();
        input.nextLine();
        System.out.println("Input guideId for RouteGuide: ");
        int guideId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeId for RouteGuide: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input startDate for Guide: ");
        Date startDate = Date.valueOf(input.next());
        System.out.println("Input lastDate for Guide: ");
        Date lastDate = Date.valueOf(input.next());
        RouteGuide entity = new RouteGuide(routeGuideId, guideId, routeId, startDate, lastDate);
        routeGuideController.update(entity, session);
    }

    private void selectRouteGuide(Session session) throws SQLException {
        System.out.println("\nTable: RouteGuide");
        routeGuideController.select(session);
    }

    private void findRouteGuideByID(Session session) throws SQLException {
        System.out.println("Input ID for RouteGuide: ");
        int id = input.nextInt();
        input.nextLine();
        routeGuideController.findById(id, session);
    }

    private void deleteFromRouteType(Session session) throws SQLException {
        System.out.println("Input ID for RouteType: ");
        int id = input.nextInt();
        input.nextLine();
        routeTypeController.delete(id, session);
    }

    private void createForRouteType(Session session) throws SQLException {
        System.out.println("Input routeTypeName for RouteType: ");
        String routeTypeName = input.nextLine();
        RouteType entity = new RouteType(0, routeTypeName);
        routeTypeController.create(entity, session);
    }

    private void updateRouteType(Session session) throws SQLException {
        System.out.println("Input routeTypeId for RouteType: ");
        int routeTypeId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeTypeName for RouteType: ");
        String routeTypeName = input.nextLine();
        RouteType entity = new RouteType(routeTypeId, routeTypeName);
        routeTypeController.update(entity, session);
    }

    private void selectRouteType(Session session) throws SQLException {
        System.out.println("\nTable: RouteType");
        routeTypeController.select(session);
    }

    private void findRouteTypeByID(Session session) throws SQLException {
        System.out.println("Input ID for RouteType: ");
        int id = input.nextInt();
        input.nextLine();
        routeTypeController.findById(id, session);
    }

    private void deleteFromStopPoint(Session session) throws SQLException {
        System.out.println("Input ID for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.delete(id, session);
    }

    private void createForStopPoint(Session session) throws SQLException {
        System.out.println("Input description for StopPoint: ");
        String description = input.nextLine();
        System.out.println("Input stopPointCityId for StopPoint: ");
        int stopPointCityId = input.nextInt();
        input.nextLine();
        System.out.println("Input stopPointHotelId for StopPoint: ");
        int stopPointHotelId = input.nextInt();
        input.nextLine();
        StopPoint entity = new StopPoint(0, description, stopPointCityId, stopPointHotelId);
        stopPointController.create(entity, session);
    }

    private void updateStopPoint(Session session) throws SQLException {
        System.out.println("Input stopPointId for StopPoint: ");
        int stopPointId = input.nextInt();
        input.nextLine();
        System.out.println("Input description for StopPoint: ");
        String description = input.nextLine();
        System.out.println("Input stopPointCityId for StopPoint: ");
        int stopPointCityId = input.nextInt();
        input.nextLine();
        System.out.println("Input stopPointHotelId for StopPoint: ");
        int stopPointHotelId = input.nextInt();
        input.nextLine();
        StopPoint entity = new StopPoint(stopPointId, description, stopPointCityId, stopPointHotelId);
        stopPointController.update(entity, session);
    }

    private void selectStopPoint(Session session) throws SQLException {
        System.out.println("\nTable: StopPoint");
        stopPointController.select(session);
    }

    private void findStopPointByID(Session session) throws SQLException {
        System.out.println("Input ID for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.findById(id, session);
    }

    private void deleteFromTour(Session session) throws SQLException {
        System.out.println("Input ID for Tour: ");
        int id = input.nextInt();
        input.nextLine();
        tourController.delete(id, session);
    }

    private void createForTour(Session session) throws SQLException {
        System.out.println("Input startDate for Tour: ");
        Date startDate = Date.valueOf(input.next());
        System.out.println("Input lastDate for Tour: ");
        Date lastDate = Date.valueOf(input.next());
        input.nextLine();
        System.out.println("Input routeId for Tour: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input price for Tour: ");
        double price = input.nextDouble();
        input.nextLine();
        Tour entity = new Tour(0, startDate, lastDate, routeId, price);
        tourController.create(entity, session);
    }

    private void updateTour(Session session) throws SQLException {
        System.out.println("Input tourId for Tour: ");
        int tourId = input.nextInt();
        input.nextLine();
        System.out.println("Input startDate for Tour: ");
        Date startDate = Date.valueOf(input.next());
        System.out.println("Input lastDate for Tour: ");
        Date lastDate = Date.valueOf(input.next());
        System.out.println("Input routeId for Tour: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input price for Tour: ");
        double price = input.nextDouble();
        input.nextLine();
        Tour entity = new Tour(tourId, startDate, lastDate, routeId, price);
        tourController.update(entity, session);
    }

    private void selectTour(Session session) throws SQLException {
        System.out.println("\nTable: Tour");
        tourController.select(session);
    }

    private void findTourByID(Session session) throws SQLException {
        System.out.println("Input ID for Tour: ");
        int id = input.nextInt();
        input.nextLine();
        tourController.findById(id, session);
    }

    private void deleteFromCountry(Session session) throws SQLException {
        System.out.println("Input ID for Country: ");
        int id = input.nextInt();
        input.nextLine();
        countryController.delete(id, session);
    }

    private void createForCountry(Session session) throws SQLException {
        System.out.println("Input Name for Country: ");
        String countryName = input.nextLine();
        Country entity = new Country(0, countryName);
        countryController.create(entity, session);
    }

    private void updateCountry(Session session) throws SQLException {
        System.out.println("Input Id for Country: ");
        int countryId = input.nextInt();
        input.nextLine();
        System.out.println("Input Name for Country: ");
        String countryName = input.nextLine();
        Country entity = new Country(countryId, countryName);
        countryController.update(entity, session);
    }

    private void selectCountry(Session session) throws SQLException {
        System.out.println("\nTable: Country");
        countryController.select(session);
    }

    private void findCountryByID(Session session) throws SQLException {
        System.out.println("Input ID for Country: ");
        int id = input.nextInt();
        input.nextLine();
        countryController.findById(id, session);
    }

    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));
    }
}

