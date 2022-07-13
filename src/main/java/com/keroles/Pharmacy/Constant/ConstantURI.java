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

    public final static String drugs_uri = base_api_uri+"/drugs";
    public final static String drugs_name_uri = "/n";

    public final static String order_uri = base_api_uri+"/order";
    public final static String order_delivery_man_id_uri = "/DMI";
    public final static String order_delivery_man_national_id_uri = "/DMNI";
    public final static String order_employee_id_uri = "/EI";
    public final static String order_employee_name_uri = "/EN";
    public final static String order_user_id_uri = "/UI";
    public final static String order_user_name_uri = "/UN";
    public final static String order_date_uri = "/D";
    public final static String order_payment_Status_uri = "/PS";
    public final static String order_delivery_status_uri = "/DS";
    public final static String order_total_cash_greater_than_uri = "/TCGT";
    public final static String order_total_cash_less_than_uri = "/TCLT";
    public final static String order_update_delivery_man_id_uri = "/UDMI";
    public final static String order_update_delivery_status_uri = "/UDS";
    public final static String order_update_payment_status_uri = "/UPS";
    public final static String order_update_lat_long_uri = "/ULL";

    //Pages
    public final static String page_uri = "/page";

    //Media
    public final static String upload_image_uri = "/photo";

}
