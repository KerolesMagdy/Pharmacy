/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Constant;

/**
 *
 * @author Keroles Magdy
 */
public class ConstantURI {

    //root api
    private final static String base_api_uri = "/pharmacy";

    //Api
    public final static String user_uri = base_api_uri + "/user";

    public final static String address_uri = base_api_uri + "/user_address";
    public final static String address_governorate_uri = "/governorate";

    public final static String employee_uri = base_api_uri + "/employee";
    public final static String employee_type_uri = "/type";
    public final static String employee_type_id_uri = "/type-id";

    public final static String company_uri = base_api_uri + "/company";
    public final static String company_name_uri = "/n";

    public final static String delivery_man_uri = base_api_uri+"/delivery-man";
    public final static String delivery_man_name_uri = "/n";
    public final static String delivery_man_distance_uri = "/d";

    //Pages
    public final static String page_uri = "/page";

    //Media
    public final static String upload_image_uri = "/photo";

}
