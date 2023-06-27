package com.maadi.flightticketbooking.utilities;



import com.maadi.flightticketbooking.models.City;
import com.maadi.flightticketbooking.models.User;

import java.util.ArrayList;
import java.util.List;

public class ECONSTANT {
    //
    public static User logedUser;
    public static List<City> cityList = new ArrayList<>();

    public static final String TAG = "TAG";
    private static final String IP = "http://192.168.1.5//";
            private static final String BASE_URL = IP + "flight_ticket_boooking_api/";
    private static final String BASE_IMAGE_URL = IP + "flight_ticket_boooking_api/";

    public static final String URL_SIGNUP = BASE_URL + "signup.php";
    public static final String URL_GET_CITY = BASE_URL + "getcity.php";
    public static final String URL_SEARCH_VEHICLE = BASE_URL + "searchvehicle.php";
    public static final String URL_IMG_USER = BASE_IMAGE_URL + "images/user/";
    public static final String URL_LOGIN = BASE_URL + "login.php";
    public static String URL_Book_TICKET = BASE_URL + "bookticket.php";
    public static final String URL_BOOKING = BASE_URL + "getmybooking.php" ;
    public static final String URL_GET_BANNER = BASE_URL + "getbanner.php";
    public static final String URL_IMG_BANNERS = BASE_IMAGE_URL + "images/banners/";
    public static final String URL_GET_BID = BASE_URL + "getbookingid.php";
    public static final String URL_ADDP = BASE_URL + "addpas.php";
    public static final String URL_GETPAS = BASE_URL + "getpassengers.php";
    public static String URL_Contact_US = BASE_URL + "addcontactus.php";
    public static final String KEY_LOGED_USER = "KEY_LOGED_USER";


}
