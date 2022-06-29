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

    public final static String table_address_attribute_address_id = "address_id";
    public final static String table_address_attribute_address_title = "address_title";
    public final static String table_address_attribute_city = "city";
    public final static String table_address_attribute_governorate = "governorate";

    public final static String table_company = "company";

    public final static String table_company_attribute_company_id = "company_id";
    public final static String table_company_attribute_company_name = "company_name";
    public final static String table_company_attribute_company_phone = "company_phone";
    public final static String table_company_attribute_company_logo = "company_logo";
    public final static String table_company_attribute_address_id = "address_id";

    public final static String table_delivery_man = "delivery_man";

    public final static String table_delivery_man_attribute_delivery_man_id = "delivery_man_id";
    public final static String table_delivery_man_attribute_delivery_man_name = "delivery_man_name";
    public final static String table_delivery_man_attribute_delivery_man_phone = "delivery_man_phone";
    public final static String table_delivery_man_attribute_delivery_man_lat = "delivery_man_lat";
    public final static String table_delivery_man_attribute_delivery_man_long = "delivery_man_long";
    public final static String table_delivery_man_attribute_delivery_man_national_id = "delivery_man_national_id";
    public final static String table_delivery_man_attribute_delivery_man_total_rate = "delivery_man_total_rate";
    public final static String table_delivery_man_attribute_delivery_man_rate_count = "delivery_man_rate_count";
    public final static String table_delivery_man_attribute_delivery_man_address_id = "delivery_man_address_id";

    public final static String table_drugs = "drugs";

    public final static String table_drugs_attribute_drugs_barcode = "drugs_barcode";
    public final static String table_drugs_attribute_drugs_name = "drugs_name";
    public final static String table_drugs_attribute_type = "type";
    public final static String table_drugs_attribute_dose = "dose";
    public final static String table_drugs_attribute_cost_price = "cost_price";
    public final static String table_drugs_attribute_selling_price = "selling_price";
    public final static String table_drugs_attribute_production_date = "production_date";
    public final static String table_drugs_attribute_expiration_date = "expiration_date";
    public final static String table_drugs_attribute_place = "place";
    public final static String table_drugs_attribute_quantity = "quantity";
    public final static String table_drugs_attribute_company_id = "company_id";

    public final static String table_employee = "employee";

    public final static String table_employee_attribute_emp_id = "emp_id";
    public final static String table_employee_attribute_emp_name = "emp_name";
    public final static String table_employee_attribute_emp_type = "emp_type";
    public final static String table_employee_attribute_emp_phone = "emp_phone";
    public final static String table_employee_attribute_emp_email = "emp_email";
    public final static String table_employee_attribute_emp_password = "emp_password";
    public final static String table_employee_attribute_emp_image = "emp_image";
    public final static String table_employee_attribute_emp_national_id = "emp_national_id";
    public final static String table_employee_attribute_emp_address_id = "emp_address_id";

    public final static String table_logs = "logs";

    public final static String table_logs_attribute_logs_id = "logs_id";
    public final static String table_logs_attribute_action = "action";
    public final static String table_logs_attribute_log_timestamp = "log_timestamp";
    public final static String table_logs_attribute_user_id = "user_id";

    public final static String table_order = "order";

    public final static String table_order_attribute_order_id = "order_id";
    public final static String table_order_attribute_total_cash = "total_cash";
    public final static String table_order_attribute_order_datetime = "order_datetime";
    public final static String table_order_attribute_deliver_status = "deliver_status";
    public final static String table_order_attribute_payment_status = "payment_status";
    public final static String table_order_attribute_order_lat = "order_lat";
    public final static String table_order_attribute_order_long = "order_long";
    public final static String table_order_attribute_employee_id = "employee_id";
    public final static String table_order_attribute_user_id = "user_id";
    public final static String table_order_attribute_delivery_man_id = "delivery_man_id";

    public final static String table_order_info = "order_info";

    public final static String table_order_info_attribute_order_info = "order_info_id";
    public final static String table_order_info_attribute_drug_name = "drug_name";
    public final static String table_order_info_attribute_drug_price = "drug_price";
    public final static String table_order_info_attribute_drug_amount = "drug_amount";
    public final static String table_order_info_attribute_order_id = "order_id";
    public final static String table_order_info_attribute_drugs_barcode = "drugs_barcode";

    public final static String table_uploaded_image = "uploaded_image";

    public final static String table_uploaded_image_attribute_image_id = "image_id";
    public final static String table_uploaded_image_attribute_image_path = "image_path";


    public final static String table_users = "users";

    public final static String table_users_attribute_user_id = "user_id";
    public final static String table_users_attribute_user_name = "user_name";
    public final static String table_users_attribute_user_dob = "user_dob";
    public final static String table_users_attribute_user_phone = "user_phone";
    public final static String table_users_attribute_user_email = "user_email";
    public final static String table_users_attribute_user_password = "user_password";
    public final static String table_users_attribute_user_image = "user_image";
    public final static String table_users_attribute_user_lat = "user_lat";
    public final static String table_users_attribute_user_long = "user_long";
    public final static String table_users_attribute_address_id = "address_id";
}
