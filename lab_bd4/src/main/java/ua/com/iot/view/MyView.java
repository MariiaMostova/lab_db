package ua.com.iot.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Date;

import ua.com.iot.controller.*;
import ua.com.iot.controller.implementetion.*;
import ua.com.iot.model.*;

public class MyView {

    private CityController cityController = new CityControllerImpl();
    private ClientController clientController = new ClientControllerImpl();
    private GuideController guideController = new GuideControllerImpl();
    private HotelController hotelController = new HotelControllerImpl();
    private HotelRoomController hotelRoomController = new HotelRoomControllerImpl();
    private RoomTypeController roomTypeController = new RoomTypeControllerImpl();
    private RouteCotroller routeController = new RouteControllerImpl();
    private RouteGuideController routeGuideController = new RouteGuideControllerImpl();
    private RouteStopPointController routeStopPointController = new RouteStopPointControllerImpl();
    private RouteTypeController routeTypeController = new RouteTypeControllerImpl();
    private StopPointController stopPointController = new StopPointControllerImpl();
    private TourClientController tourClientController = new TourClientControllerImpl();
    private TourController tourController = new TourControllerImpl();
    private CountryController countryController = new CountryControllerImpl();

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("01", "  01 - Table: City");
        menu.put("11", "  11 - Create for City");
        menu.put("12", "  12 - Update City");
        menu.put("13", "  13 - Delete from City");
        menu.put("14", "  14 - Select City");
        menu.put("15", "  15 - Find City by ID");
        menu.put("16", "  16 - Find City by Name");

        menu.put("02", "  02 - Table: Client");
        menu.put("21", "  21 - Create for Client");
        menu.put("22", "  22 - Update Client");
        menu.put("23", "  23 - Delete from Client");
        menu.put("24", "  24 - Select Client");
        menu.put("25", "  25 - Find Client by ID");
        menu.put("26", "  26 - Find Client by Name");

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
        menu.put("46", "  26 - Find Hotel by Name");

        menu.put("05", "  05 - Table: HotelRoom");
        menu.put("51", "  51 - Create for HotelRoom");
        menu.put("52", "  52 - Update HotelRoom");
        menu.put("53", "  53 - Delete from HotelRoom");
        menu.put("54", "  54 - Select HotelRoom");
        menu.put("55", "  55 - Find HotelRoom by Room Type ID");
        menu.put("56", "  56 - Find HotelRoom by Hotel ID");

        menu.put("06", "  06 - Table: RoomType");
        menu.put("61", "  61 - Create for RoomType");
        menu.put("62", "  62 - Update RoomType");
        menu.put("63", "  63 - Delete from RoomType");
        menu.put("64", "  64 - Select RoomType");
        menu.put("65", "  65 - Find RoomType by ID");
        menu.put("66", "  66 - Find RoomType by Name");
        menu.put("67", "  67 - Find RoomType by Rerson Amount");

        menu.put("07", "  07 - Table: Route");
        menu.put("71", "  71 - Create for Route");
        menu.put("72", "  72 - Update Route");
        menu.put("73", "  73 - Delete from Route");
        menu.put("74", "  74 - Select Route");
        menu.put("75", "  75 - Find Route by ID");
        menu.put("76", "  76 - Find Route by Room Type ID");

        menu.put("08", "  08 - Table: RouteGuide");
        menu.put("81", "  81 - Create for RouteGuide");
        menu.put("82", "  82 - Update RouteGuide");
        menu.put("83", "  83 - Delete from RouteGuide");
        menu.put("84", "  84 - Select RouteGuide");
        menu.put("85", "  85 - Find RouteGuide by Guide ID");
        menu.put("86", "  86 - Find RouteGuide by Route ID");

        menu.put("09", "  09 - Table: RouteStopPoint");
        menu.put("91", "  91 - Create for RouteStopPoint");
        menu.put("92", "  92 - Update RouteStopPoint");
        menu.put("93", "  93 - Delete from RouteStopPoint");
        menu.put("94", "  94 - Select RouteStopPoint");
        menu.put("95", "  95 - Find RouteStopPoint by Route ID");
        menu.put("96", "  96 - Find RouteStopPoint by Stop Point ID");

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
        menu.put("116", "  116 - Find StopPoint by City ID");
        menu.put("117", "  117 - Find StopPoint by Hotel ID");

        menu.put("012", "  012 - Table: TourClient");
        menu.put("121", "  121 - Create for TourClient");
        menu.put("122", "  122 - Update TourClient");
        menu.put("123", "  123 - Delete from TourClient");
        menu.put("124", "  124 - Select TourClient");
        menu.put("125", "  125 - Find TourClient by Tour ID");
        menu.put("126", "  126 - Find TourClient by Client ID");

        menu.put("013", "  013 - Table: Tour");
        menu.put("131", "  131 - Create for Tour");
        menu.put("132", "  132 - Update Tour");
        menu.put("133", "  133 - Delete from Tour");
        menu.put("134", "  134 - Select Tour");
        menu.put("135", "  135 - Find Tour by ID");
        menu.put("136", "  136 - Find Tour by Start Date");
        menu.put("137", "  137 - Find Tour by End Date");
        menu.put("138", "  138 - Find Tour by Route ID");
        menu.put("139", "  139 - Find Tour by Price");

        menu.put("014", "  014 - Table: Country");
        menu.put("141", "  141 - Create for Country");
        menu.put("142", "  142 - Update Country");
        menu.put("143", "  143 - Delete from Country");
        menu.put("144", "  144 - Select Country");
        menu.put("145", "  145 - Find Country by ID");
        menu.put("146", "  146 - Find Country by Name");

        
        methodsMenu.put("11", this::createForCity);
        methodsMenu.put("12", this::updateCity);
        methodsMenu.put("13", this::deleteFromCity);
        methodsMenu.put("14", this::selectCity);
        methodsMenu.put("15", this::findCityByID);
        methodsMenu.put("16", this::findCityByName);
        
        methodsMenu.put("21", this::createForClient);
        methodsMenu.put("22", this::updateClient);
        methodsMenu.put("23", this::deleteFromClient);
        methodsMenu.put("24", this::selectClient);
        methodsMenu.put("25", this::findClientByID);
        methodsMenu.put("26", this::findClientByName);
        
        methodsMenu.put("31", this::createForGuide);
        methodsMenu.put("32", this::updateGuide);
        methodsMenu.put("33", this::deleteFromGuide);
        methodsMenu.put("34", this::selectGuide);
        methodsMenu.put("35", this::findGuideByID);
        methodsMenu.put("36", this::findGuideByName);
        methodsMenu.put("37", this::findGuideBySex);
        
        methodsMenu.put("41", this::createForHotel);
        methodsMenu.put("42", this::updateHotel);
        methodsMenu.put("43", this::deleteFromHotel);
        methodsMenu.put("44", this::selectHotel);
        methodsMenu.put("45", this::findHotelByID);
        methodsMenu.put("46", this::findHotelByName);
        
        methodsMenu.put("51", this::createForHotelRoom);
        methodsMenu.put("52", this::updateHotelRoom);
        methodsMenu.put("53", this::deleteFromHotelRoom);
        methodsMenu.put("54", this::selectHotelRoom);
        methodsMenu.put("55", this::findHotelRoomByHotelId);
        methodsMenu.put("56", this::findHotelRoomByRoomTypeId);
        
        methodsMenu.put("61", this::createForRoomType);
        methodsMenu.put("62", this::updateRoomType);
        methodsMenu.put("63", this::deleteFromRoomType);
        methodsMenu.put("64", this::selectRoomType);
        methodsMenu.put("65", this::findRoomTypeByID);
        methodsMenu.put("66", this::findRoomTypeByName);
        methodsMenu.put("67", this::findRoomTypeByPersonAmount);
        
        methodsMenu.put("71", this::createForRoute);
        methodsMenu.put("72", this::updateRoute);
        methodsMenu.put("73", this::deleteFromRoute);
        methodsMenu.put("74", this::selectRoute);
        methodsMenu.put("75", this::findRouteByID);
        methodsMenu.put("76", this::findRouteByRoomTypeId);
        
        methodsMenu.put("81", this::createForRouteGuide);
        methodsMenu.put("82", this::updateRouteGuide);
        methodsMenu.put("83", this::deleteFromRouteGuide);
        methodsMenu.put("84", this::selectRouteGuide);
        methodsMenu.put("85", this::findRouteGuideByGuideId);
        methodsMenu.put("86", this::findRouteGuideByRouteId);
        
        methodsMenu.put("91", this::createForRouteStopPoint);
        methodsMenu.put("92", this::updateRouteStopPoint);
        methodsMenu.put("93", this::deleteFromRouteStopPoint);
        methodsMenu.put("94", this::selectRouteStopPoint);
        methodsMenu.put("95", this::findRouteStopPointByStopPointId);
        methodsMenu.put("96", this::findRouteStopPointByRouteId);
        
        methodsMenu.put("101", this::createForRouteType);
        methodsMenu.put("102", this::updateRouteType);
        methodsMenu.put("103", this::deleteFromRouteType);
        methodsMenu.put("104", this::selectRouteType);
        methodsMenu.put("105", this::findRouteTypeByID);
        methodsMenu.put("106", this::findRouteTypeByName);
        
        methodsMenu.put("111", this::createForStopPoint);
        methodsMenu.put("112", this::updateStopPoint);
        methodsMenu.put("113", this::deleteFromStopPoint);
        methodsMenu.put("114", this::selectStopPoint);
        methodsMenu.put("115", this::findStopPointByID);
        methodsMenu.put("116", this::findStopPointByCityId);
        methodsMenu.put("117", this::findStopPointByHotelId);
        
        methodsMenu.put("121", this::createForTourClient);
        methodsMenu.put("122", this::updateTourClient);
        methodsMenu.put("123", this::deleteFromTourClient);
        methodsMenu.put("124", this::selectTourClient);
        methodsMenu.put("125", this::findTourClientByClientId);
        methodsMenu.put("126", this::findTourClientByTourId);
        
        methodsMenu.put("131", this::createForTour);
        methodsMenu.put("132", this::updateTour);
        methodsMenu.put("133", this::deleteFromTour);
        methodsMenu.put("134", this::selectTour);
        methodsMenu.put("135", this::findTourByID);
        methodsMenu.put("136", this::findTourByStartDate);
        methodsMenu.put("137", this::findTourByEndDate);
        methodsMenu.put("138", this::findTourByRouteID);
        methodsMenu.put("139", this::findTourByPrice);
        
        methodsMenu.put("141", this::createForCountry);
        methodsMenu.put("142", this::updateCountry);
        methodsMenu.put("143", this::deleteFromCountry);
        methodsMenu.put("144", this::selectCountry);
        methodsMenu.put("145", this::findCountryByID);
        methodsMenu.put("146", this::findCountryByName);
    }

    private void deleteFromCity() throws SQLException {
        System.out.println("Input ID for City: ");
        int id = input.nextInt();
        input.nextLine();
        cityController.delete(id);
    }

    private void createForCity() throws SQLException {
        System.out.println("Input cityName for City: ");
        String cityName = input.nextLine();
        System.out.println("Input cityCountryId for City: ");
        int cityCountryId = input.nextInt();
        input.nextLine();
        City entity = new City(0, cityName, cityCountryId);
        cityController.create(entity);
    }

    private void updateCity() throws SQLException {
        System.out.println("Input cityId for City: ");
        int cityId = input.nextInt();
        input.nextLine();
        System.out.println("Input cityName for City: ");
        String cityName = input.nextLine();
        System.out.println("Input cityCountryId for City: ");
        int cityCountryId = input.nextInt();
        input.nextLine();
        City entity = new City(cityId, cityName, cityCountryId);
        cityController.update(entity);
    }

    private void selectCity() throws SQLException {
        System.out.println("\nTable: City");
        cityController.select();
    }

    private void findCityByID() throws SQLException {
        System.out.println("Input ID for City: ");
        int id = input.nextInt();
        input.nextLine();
        cityController.findById(id);
    }

    private void findCityByName() throws SQLException {
        System.out.println("Input name for City: ");
        String name = input.nextLine();
        cityController.findByName(name);
    }

    private void deleteFromClient() throws SQLException {
        System.out.println("Input ID for Client: ");
        int id = input.nextInt();
        input.nextLine();
        clientController.delete(id);
    }

    private void createForClient() throws SQLException, ParseException {
        try {
            System.out.println("Input ClientFirstName for Client: ");
            String ClientFirstName = input.nextLine();
            System.out.println("Input ClientLastName for Client: ");
            String clientLastName = input.nextLine();
            System.out.println("Input clientBirthday(yyyy-MM-dd) for Client: ");
            Date clientBirthday = Date.valueOf(input.next());
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            Date clientBirthday = format.parse(dateString);
            Client entity = new Client(0, ClientFirstName, clientLastName, clientBirthday);
            clientController.create(entity);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void updateClient() throws SQLException, ParseException {
        System.out.println("Input ClientId for Client: ");
        int clientId = input.nextInt();
        input.nextLine();
        System.out.println("Input ClientFirstName for Client: ");
        String ClientFirstName = input.nextLine();
        System.out.println("Input ClientLastName for Client: ");
        String clientLastName = input.nextLine();
        System.out.println("Input clientBirthday(yyyy-MM-dd) for Client: ");
        Date clientBirthday = Date.valueOf(input.next());
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date clientBirthday = format.parse(dateString);
        Client entity = new Client(clientId, ClientFirstName, clientLastName, clientBirthday);
        clientController.update(entity);
    }

    private void selectClient() throws SQLException {
        System.out.println("\nTable: Client");
        clientController.select();
    }

    private void findClientByID() throws SQLException {
        System.out.println("Input ID for Client: ");
        int id = input.nextInt();
        input.nextLine();
        clientController.findById(id);
    }

    private void findClientByName() throws SQLException {
        System.out.println("Input name for Client: ");
        String name = input.nextLine();
        clientController.findByName(name);
    }

    private void deleteFromGuide() throws SQLException {
        System.out.println("Input ID for Guide: ");
        int id = input.nextInt();
        input.nextLine();
        guideController.delete(id);
    }

    private void createForGuide() throws SQLException, ParseException {
        System.out.println("Input guideFirstName for Guide: ");
        String guideFirstName = input.nextLine();
        System.out.println("Input guideLastName for Guide: ");
        String guideLastName = input.nextLine();
        System.out.println("Input GuideBirthday for Guide: ");
        Date guideBirthday = Date.valueOf(input.next());
        System.out.println("Input Sex for Guide: ");
        String guideSex = input.next();
        Guide entity = new Guide(0, guideFirstName, guideLastName, guideBirthday, guideSex);
        guideController.create(entity);
    }

    private void updateGuide() throws SQLException, ParseException {
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
        guideController.update(entity);
    }

    private void selectGuide() throws SQLException {
        System.out.println("\nTable: Guide");
        guideController.select();
    }

    private void findGuideByID() throws SQLException {
        System.out.println("Input ID for Guide: ");
        int id = input.nextInt();
        input.nextLine();
        guideController.findById(id);
    }

    private void findGuideByName() throws SQLException {
        System.out.println("Input name for Guide: ");
        String name = input.nextLine();
        guideController.findByName(name);
    }

    private void findGuideBySex() throws SQLException {
        System.out.println("Input sex for Guide: ");
        String sex = input.nextLine();
        guideController.findBySex(sex);
    }

    private void deleteFromHotel() throws SQLException {
        System.out.println("Input ID for Hotel: ");
        int id = input.nextInt();
        input.nextLine();
        hotelController.delete(id);
    }

    private void createForHotel() throws SQLException {
        System.out.println("Input HotelName for Hotel: ");
        String HotelName = input.nextLine();
        System.out.println("Input HotelCityId for Hotel: ");
        int HotelCityId = input.nextInt();
        input.nextLine();
        Hotel entity = new Hotel(0, HotelName, HotelCityId);
        hotelController.create(entity);
    }

    private void updateHotel() throws SQLException {
        System.out.println("Input HotelId for Hotel: ");
        int HotelId = input.nextInt();
        input.nextLine();
        System.out.println("Input HotelName for Hotel: ");
        String HotelName = input.nextLine();
        System.out.println("Input HotelCityId for Hotel: ");
        int HotelCityId = input.nextInt();
        input.nextLine();
        Hotel entity = new Hotel(HotelId, HotelName, HotelCityId);
        hotelController.update(entity);
    }

    private void selectHotel() throws SQLException {
        System.out.println("\nTable: Hotel");
        hotelController.select();
    }

    private void findHotelByID() throws SQLException {
        System.out.println("Input ID for Hotel: ");
        int id = input.nextInt();
        input.nextLine();
        hotelController.findById(id);
    }

    private void findHotelByName() throws SQLException {
        System.out.println("Input name for Hotel: ");
        String name = input.nextLine();
        hotelController.findByName(name);
    }

    private void deleteFromHotelRoom() throws SQLException {
        System.out.println("Input ID for HotelRoom: ");
        int id = input.nextInt();
        input.nextLine();
        hotelRoomController.delete(id);
    }

    private void createForHotelRoom() throws SQLException {
        System.out.println("Input hotelRoomId for HotelRoom: ");
        int hotelRoomId = input.nextInt();
        input.nextLine();
        System.out.println("Input hotelRoomTypeId for HotelRoom: ");
        int hotelRoomTypeId = input.nextInt();
        input.nextLine();
        HotelRoom entity = new HotelRoom(hotelRoomId, hotelRoomTypeId);
        hotelRoomController.create(entity);
    }

    private void updateHotelRoom() throws SQLException {
        System.out.println("Input hotelRoomId for HotelRoom: ");
        int hotelRoomId = input.nextInt();
        input.nextLine();
        System.out.println("Input hotelRoomTypeId for HotelRoom: ");
        int hotelRoomTypeId = input.nextInt();
        input.nextLine();
        HotelRoom entity = new HotelRoom(hotelRoomId, hotelRoomTypeId);
        hotelRoomController.update(entity);
    }

    private void selectHotelRoom() throws SQLException {
        System.out.println("\nTable: HotelRoom");
        hotelRoomController.select();
    }

    private void findHotelRoomByRoomTypeId() throws SQLException {
        System.out.println("Input RoomTypeId for HotelRoom: ");
        int id = input.nextInt();
        input.nextLine();
        hotelRoomController.findByHotelRoomTypeId(id);
    }

    private void findHotelRoomByHotelId() throws SQLException {
        System.out.println("Input HotelId for HotelRoom: ");
        int id = input.nextInt();
        input.nextLine();
        hotelRoomController.findByHotelId(id);
    }

    private void deleteFromRoomType() throws SQLException {
        System.out.println("Input ID for RoomType: ");
        int id = input.nextInt();
        input.nextLine();
        roomTypeController.delete(id);
    }

    private void createForRoomType() throws SQLException {
        System.out.println("Input roomTypeName for RoomType: ");
        String roomTypeName = input.nextLine();
        System.out.println("Input personAmount for RoomType: ");
        int personAmount = input.nextInt();
        input.nextLine();
        RoomType entity = new RoomType(0, roomTypeName, personAmount);
        roomTypeController.create(entity);
    }

    private void updateRoomType() throws SQLException {
        System.out.println("Input roomTypeId for RoomType: ");
        int roomTypeId = input.nextInt();
        input.nextLine();
        System.out.println("Input roomTypeName for RoomType: ");
        String roomTypeName = input.nextLine();
        System.out.println("Input roomTypeCountryId for RoomType: ");
        int personAmount = input.nextInt();
        input.nextLine();
        RoomType entity = new RoomType(roomTypeId, roomTypeName, personAmount);
        roomTypeController.update(entity);
    }

    private void selectRoomType() throws SQLException {
        System.out.println("\nTable: RoomType");
        roomTypeController.select();
    }

    private void findRoomTypeByID() throws SQLException {
        System.out.println("Input ID for RoomType: ");
        int id = input.nextInt();
        input.nextLine();
        roomTypeController.findById(id);
    }

    private void findRoomTypeByName() throws SQLException {
        System.out.println("Input Name for RoomType: ");
        String name = input.nextLine();
        roomTypeController.findRoomTypeByName(name);
    }

    private void findRoomTypeByPersonAmount() throws SQLException {
        System.out.println("Input PersonAmount for RoomType: ");
        int personAmount = input.nextInt();
        input.nextLine();
        roomTypeController.findByPerson(personAmount);
    }

    private void deleteFromRoute() throws SQLException {
        System.out.println("Input ID for Route: ");
        int id = input.nextInt();
        input.nextLine();
        routeController.delete(id);
    }

    private void createForRoute() throws SQLException {
        System.out.println("Input description for Route: ");
        String description = input.nextLine();
        System.out.println("Input routeCountryId for Route: ");
        int routeCountryId = input.nextInt();
        input.nextLine();
        Route entity = new Route(0, description, routeCountryId);
        routeController.create(entity);
    }

    private void updateRoute() throws SQLException {
        System.out.println("Input routeId for Route: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeName for Route: ");
        String routeName = input.nextLine();
        System.out.println("Input routeCountryId for Route: ");
        int routeCountryId = input.nextInt();
        input.nextLine();
        Route entity = new Route(routeId, routeName, routeCountryId);
        routeController.update(entity);
    }

    private void selectRoute() throws SQLException {
        System.out.println("\nTable: Route");
        routeController.select();
    }

    private void findRouteByID() throws SQLException {
        System.out.println("Input ID for Route: ");
        int id = input.nextInt();
        input.nextLine();
        routeController.findById(id);
    }

    private void findRouteByRoomTypeId() throws SQLException {
        System.out.println("Input RoomTypeId for Route: ");
        int id = input.nextInt();
        input.nextLine();
        routeController.findByRoomTypeId(id);
    }

    private void deleteFromRouteGuide() throws SQLException {
        System.out.println("Input ID for RouteGuide: ");
        int id = input.nextInt();
        input.nextLine();
        routeGuideController.delete(id);
    }

    private void createForRouteGuide() throws SQLException {
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
        routeGuideController.create(entity);
    }

    private void updateRouteGuide() throws SQLException {
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
        routeGuideController.update(entity);
    }

    private void selectRouteGuide() throws SQLException {
        System.out.println("\nTable: RouteGuide");
        routeGuideController.select();
    }

    private void findRouteGuideByGuideId() throws SQLException {
        System.out.println("Input GuideId for RouteGuide: ");
        int id = input.nextInt();
        input.nextLine();
        routeGuideController.findByGuideId(id);
    }

    private void findRouteGuideByRouteId() throws SQLException {
        System.out.println("Input RouteId for RouteGuide: ");
        int id = input.nextInt();
        input.nextLine();
        routeGuideController.findByRouteId(id);
    }

    private void deleteFromRouteStopPoint() throws SQLException {
        System.out.println("Input ID for RouteStopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        routeStopPointController.delete(id);
    }

    private void createForRouteStopPoint() throws SQLException {
        System.out.println("Input RouteId for RouteStopPoint: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input stopPointId for RouteStopPoint: ");
        int stopPointId = input.nextInt();
        input.nextLine();
        RouteStopPoint entity = new RouteStopPoint(routeId, stopPointId);
        routeStopPointController.create(entity);
    }

    private void updateRouteStopPoint() throws SQLException {
        System.out.println("Input routeId for RouteStopPoint: ");
        int routeId = input.nextInt();
        input.nextLine();
        System.out.println("Input stopPointId for RouteStopPoint: ");
        int stopPointId = input.nextInt();
        input.nextLine();
        RouteStopPoint entity = new RouteStopPoint(routeId, stopPointId);
        routeStopPointController.update(entity);
    }

    private void selectRouteStopPoint() throws SQLException {
        System.out.println("\nTable: RouteStopPoint");
        routeStopPointController.select();
    }

    private void findRouteStopPointByStopPointId() throws SQLException {
        System.out.println("Input StopPointId for RouteStopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        routeStopPointController.findByStopPointId(id);
    }

    private void findRouteStopPointByRouteId() throws SQLException {
        System.out.println("Input RouteId for RouteStopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        routeStopPointController.findByRouteId(id);
    }


    private void deleteFromRouteType() throws SQLException {
        System.out.println("Input ID for RouteType: ");
        int id = input.nextInt();
        input.nextLine();
        routeTypeController.delete(id);
    }

    private void createForRouteType() throws SQLException {
        System.out.println("Input routeTypeName for RouteType: ");
        String routeTypeName = input.nextLine();
        RouteType entity = new RouteType(0, routeTypeName);
        routeTypeController.create(entity);
    }

    private void updateRouteType() throws SQLException {
        System.out.println("Input routeTypeId for RouteType: ");
        int routeTypeId = input.nextInt();
        input.nextLine();
        System.out.println("Input routeTypeName for RouteType: ");
        String routeTypeName = input.nextLine();
        RouteType entity = new RouteType(routeTypeId, routeTypeName);
        routeTypeController.update(entity);
    }

    private void selectRouteType() throws SQLException {
        System.out.println("\nTable: RouteType");
        routeTypeController.select();
    }

    private void findRouteTypeByID() throws SQLException {
        System.out.println("Input ID for RouteType: ");
        int id = input.nextInt();
        input.nextLine();
        routeTypeController.findById(id);
    }

    private void findRouteTypeByName() throws SQLException {
        System.out.println("Input name for RouteType: ");
        String name = input.nextLine();
        routeTypeController.findByName(name);
    }

    private void deleteFromStopPoint() throws SQLException {
        System.out.println("Input ID for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.delete(id);
    }

    private void createForStopPoint() throws SQLException {
        System.out.println("Input description for StopPoint: ");
        String description = input.nextLine();
        System.out.println("Input stopPointCityId for StopPoint: ");
        int stopPointCityId = input.nextInt();
        input.nextLine();
        System.out.println("Input stopPointHotelId for StopPoint: ");
        int stopPointHotelId = input.nextInt();
        input.nextLine();
        StopPoint entity = new StopPoint(0, description, stopPointCityId, stopPointHotelId);
        stopPointController.create(entity);
    }

    private void updateStopPoint() throws SQLException {
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
        stopPointController.update(entity);
    }

    private void selectStopPoint() throws SQLException {
        System.out.println("\nTable: StopPoint");
        stopPointController.select();
    }

    private void findStopPointByID() throws SQLException {
        System.out.println("Input ID for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.findById(id);
    }

    private void findStopPointByCityId() throws SQLException {
        System.out.println("Input CityId for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.findByCityId(id);
    }

    private void findStopPointByHotelId() throws SQLException {
        System.out.println("Input HotelId for StopPoint: ");
        int id = input.nextInt();
        input.nextLine();
        stopPointController.findByHotelId(id);
    }

    private void deleteFromTourClient() throws SQLException {
        System.out.println("Input ID for TourClient: ");
        int id = input.nextInt();
        input.nextLine();
        tourClientController.delete(id);
    }

    private void createForTourClient() throws SQLException {
        System.out.println("Input tourId for TourClient: ");
        int tourId = input.nextInt();
        input.nextLine();
        TourClient entity = new TourClient(0, tourId);
        tourClientController.create(entity);
    }

    private void updateTourClient() throws SQLException {
        System.out.println("Input clientId for TourClient: ");
        int clientId = input.nextInt();
        input.nextLine();
        System.out.println("Input tourId for TourClient: ");
        int tourId = input.nextInt();
        input.nextLine();
        TourClient entity = new TourClient(clientId, tourId);
        tourClientController.update(entity);
    }

    private void selectTourClient() throws SQLException {
        System.out.println("\nTable: TourClient");
        tourClientController.select();
    }

    private void findTourClientByClientId() throws SQLException {
        System.out.println("Input ClientId for TourClient: ");
        int id = input.nextInt();
        input.nextLine();
        tourClientController.findByClientId(id);
    }

    private void findTourClientByTourId() throws SQLException {
        System.out.println("Input TourId for TourClient: ");
        int id = input.nextInt();
        input.nextLine();
        tourClientController.findByClientId(id);
    }

    private void deleteFromTour() throws SQLException {
        System.out.println("Input ID for Tour: ");
        int id = input.nextInt();
        input.nextLine();
        tourController.delete(id);
    }

    private void createForTour() throws SQLException, ParseException {
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
        tourController.create(entity);
    }

    private void updateTour() throws SQLException, ParseException {
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
        tourController.update(entity);
    }

    private void selectTour() throws SQLException {
        System.out.println("\nTable: Tour");
        tourController.select();
    }

    private void findTourByID() throws SQLException {
        System.out.println("Input ID for Tour: ");
        int id = input.nextInt();
        input.nextLine();
        tourController.findById(id);
    }

    private void findTourByStartDate() throws SQLException {
        System.out.println("Input startDate(yyyy-mm-dd) for Tour: ");
        Date startDate = Date.valueOf(input.next());
        tourController.findByStartDate(startDate);
    }

    private void findTourByEndDate() throws SQLException {
        System.out.println("Input endDate(yyyy-mm-dd) for Tour: ");
        Date endDate = Date.valueOf(input.next());
        tourController.findByEndDate(endDate);
    }

    private void findTourByRouteID() throws SQLException {
        System.out.println("Input routeId for Tour: ");
        int id = input.nextInt();
        input.nextLine();
        tourController.findByRoutelId(id);
    }

    private void findTourByPrice() throws SQLException {
        System.out.println("Input price for Tour: ");
        double price = input.nextDouble();
        input.nextLine();
        tourController.findByPrice(price);
    }

    private void deleteFromCountry() throws SQLException {
        System.out.println("Input ID for Country: ");
        int id = input.nextInt();
        input.nextLine();
        countryController.delete(id);
    }

    private void createForCountry() throws SQLException {
        System.out.println("Input Name for Country: ");
        String countryName = input.nextLine();
        Country entity = new Country(0, countryName);
        countryController.create(entity);
    }

    private void updateCountry() throws SQLException {
        System.out.println("Input Id for Country: ");
        int countryId = input.nextInt();
        input.nextLine();
        System.out.println("Input Name for Country: ");
        String countryName = input.nextLine();
        Country entity = new Country(countryId, countryName);
        countryController.update(entity);
    }

    private void selectCountry() throws SQLException {
        System.out.println("\nTable: Country");
        countryController.select();
    }

    private void findCountryByID() throws SQLException {
        System.out.println("Input ID for Country: ");
        int id = input.nextInt();
        input.nextLine();
        countryController.findById(id);
    }

    private void findCountryByName() throws SQLException {
        System.out.println("Input name for Country: ");
        String name = input.nextLine();
        countryController.findByName(name);
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

