package com.tallstech.volunteer.repository.query;

public class CharityAdminSqlQueries {

    private CharityAdminSqlQueries(){}

    public static final String INSERT_QUERY = "INSERT INTO CHARITY_ADMINS (charity_id, first_name, " +
            "last_name, identity_id, password, gender, age, nationality, phone_number, blood_group, " +
            "marital_status, health_problem, criminal_record, biography, country, city, district, " +
            "address, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_QUERY = "SELECT id, charity_id, first_name, last_name, gender, " +
            "age, nationality, phone_number, blood_group, marital_status, health_problem, " +
            "criminal_record, biography, country, city, district, address, status " +
            "FROM CHARITY_ADMINS WHERE id = ?";

    public static final String SELECT_CHARITY_ID = "SELECT charity_id FROM CHARITY_ADMINS WHERE id = ?";

    public static final String SELECT_APPLICATION = "SELECT APPLICATIONS.id, APPLICATIONS.charity_id, " +
            "volunteer_id, event_id, first_name, last_name, gender, age, nationality, phone_number, " +
            "blood_group, marital_status, health_problem, criminal_record, biography, " +
            "VOLUNTEERS.country AS volunteer_country, VOLUNTEERS.city AS volunteer_city, " +
            "VOLUNTEERS.district AS volunteer_district, VOLUNTEERS.address AS volunteer_address, " +
            "graduation_info, VOLUNTEERS.work, EVENTS.name, description, " +
            "EVENTS.country AS event_country, EVENTS.city AS event_city, " +
            "EVENTS.district AS event_district, EVENTS.address AS event_address, " +
            "category, EVENTS.start_date, EVENTS.start_time, duration, requirement, EVENTS.condition, " +
            "number_of_volunteers, event_create_time, event_update_time, application_create_date, application_result, APPLICATIONS.status " +
            "FROM APPLICATIONS, VOLUNTEERS, EVENTS " +
            "WHERE APPLICATIONS.volunteer_id=VOLUNTEERS.id and " +
            "APPLICATIONS.event_id=EVENTS.id and " +
            "APPLICATIONS.charity_id = ?";


}
