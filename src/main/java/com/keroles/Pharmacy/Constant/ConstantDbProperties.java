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
public class ConstantDbProperties {

    public final static String db_name = "pharmacy";

    public final static String table_address = "address";

    public final static String table_address_attribut_address_id = "address_id";
    public final static String table_address_attribut_address_title = "address_title";
    public final static String table_address_attribut_city = "city";
    public final static String table_address_attribut_governorate = "governorate";

    public final static String table_company = "company";

    public final static String table_company_attribut_company_id = "company_id";
    public final static String table_company_attribut_company_name = "company_name";
    public final static String table_company_attribut_company_phone = "company_phone";
    public final static String table_company_attribut_company_logo = "company_logo";
    public final static String table_company_attribut_address_id = "address_id";

    public final static String table_delivery_man = "delivery_man";

    public final static String table_delivery_man_attribut_delivery_man_id = "delivery_man_id";
    public final static String table_delivery_man_attribut_delivery_man_name = "delivery_man_name";
    public final static String table_delivery_man_attribut_delivery_man_phone = "delivery_man_phone";
    public final static String table_delivery_man_attribut_delivery_man_lat = "delivery_man_lat";
    public final static String table_delivery_man_attribut_delivery_man_long = "delivery_man_long";
    public final static String table_delivery_man_attribut_delivery_man_national_id = "delivery_man_national_id";
    public final static String table_delivery_man_attribut_delivery_man_total_rate = "delivery_man_total_rate";
    public final static String table_delivery_man_attribut_delivery_man_rate_count = "delivery_man_rate_count";
    public final static String table_delivery_man_attribut_delivery_man_address_id = "delivery_man_address_id";

    public final static String table_drugs = "drugs";

    public final static String table_drugs_attribut_drugs_barcode = "drugs_barcode";
    public final static String table_drugs_attribut_drugs_name = "drugs_name";
    public final static String table_drugs_attribut_type = "type";
    public final static String table_drugs_attribut_dose = "dose";
    public final static String table_drugs_attribut_cost_price = "cost_price";
    public final static String table_drugs_attribut_selling_price = "selling_price";
    public final static String table_drugs_attribut_production_date = "production_date";
    public final static String table_drugs_attribut_expiration_date = "expiration_date";
    public final static String table_drugs_attribut_place = "place";
    public final static String table_drugs_attribut_quantity = "quantity";
    public final static String table_drugs_attribut_company_id = "company_id";

    public final static String table_employee = "employee";

    public final static String table_employee_attribut_emp_id = "emp_id";
    public final static String table_employee_attribut_emp_name = "emp_name";
    public final static String table_employee_attribut_emp_phone = "emp_phone";
    public final static String table_employee_attribut_emp_email = "emp_email";
    public final static String table_employee_attribut_emp_password = "emp_password";
    public final static String table_employee_attribut_emp_image = "emp_image";
    public final static String table_employee_attribut_emp_national_id = "emp_national_id";
    public final static String table_employee_attribut_emp_address_id = "emp_address_id";

    public final static String table_logs = "logs";

    public final static String table_logs_attribut_logs_id = "logs_id";
    public final static String table_logs_attribut_action = "action";
    public final static String table_logs_attribut_log_timestamp = "log_timestamp";
    public final static String table_logs_attribut_user_id = "user_id";

    public final static String table_order = "order";

    public final static String table_order_attribut_order_id = "order_id";
    public final static String table_order_attribut_total_cash = "total_cash";
    public final static String table_order_attribut_order_datetime = "order_datetime";
    public final static String table_order_attribut_deliver_status = "deliver_status";
    public final static String table_order_attribut_payment_status = "payment_status";
    public final static String table_order_attribut_order_lat = "order_lat";
    public final static String table_order_attribut_order_long = "order_long";
    public final static String table_order_attribut_employee_id = "employee_id";
    public final static String table_order_attribut_user_id = "user_id";
    public final static String table_order_attribut_delivery_man_id = "delivery_man_id";

    public final static String table_order_info = "order_info";

    public final static String table_order_info_attribut_order_info = "order_info_id";
    public final static String table_order_info_attribut_drug_name = "drug_name";
    public final static String table_order_info_attribut_drug_price = "drug_price";
    public final static String table_order_info_attribut_drug_amount = "drug_amount";
    public final static String table_order_info_attribut_order_id = "order_id";
    public final static String table_order_info_attribut_drugs_barcode = "drugs_barcode";

    public final static String table_uploaded_image = "uploaded_image";

    public final static String table_uploaded_image_attribut_image_id = "image_id";
    public final static String table_uploaded_image_attribut_image_path = "image_path";


    public final static String table_users = "users";

    public final static String table_users_attribut_user_id = "user_id";
    public final static String table_users_attribut_user_name = "user_name";
    public final static String table_users_attribut_user_dob = "user_dob";
    public final static String table_users_attribut_user_phone = "user_phone";
    public final static String table_users_attribut_user_email = "user_email";
    public final static String table_users_attribut_user_password = "user_password";
    public final static String table_users_attribut_user_image = "user_image";
    public final static String table_users_attribut_user_lat = "user_lat";
    public final static String table_users_attribut_user_long = "user_long";
    public final static String table_users_attribut_address_id = "address_id";
}
