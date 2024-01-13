package com.tallstech.volunteer.repository.query;

public class VolunteerSqlQueries {

    private VolunteerSqlQueries(){}

    public static final String INSERT_QUERY = "INSERT INTO VOLUNTEERS (first_name, last_name, identity_id," +
            "gender, age, nationality, phone_number, blood_group, marital_status, health_problem," +
            "criminal_record, biography, country, city, district, address, graduation_info, work, status)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_QUERY = "SELECT id, first_name, last_name, gender, age, nationality," +
            "phone_number, blood_group, marital_status, health_problem, criminal_record, biography, country," +
            "city, district, address, graduation_info, work, status FROM VOLUNTEERS WHERE id = ?";

}
