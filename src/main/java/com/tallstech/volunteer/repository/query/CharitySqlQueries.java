package com.tallstech.volunteer.repository.query;

public class CharitySqlQueries {

    private CharitySqlQueries(){}

    public static final String INSERT_QUERY = "INSERT INTO CHARITIES (name, goal, country, city, district, " +
            "address, phone_number, slogan, year_of_foundation, founder, number_of_active_volunteers, " +
            "official_site, awards, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_QUERY = "SELECT id, name, goal, country, city, district, address, " +
            "phone_number, slogan, year_of_foundation, founder, number_of_active_volunteers, " +
            "official_site, awards, status FROM CHARITIES WHERE id = ?";

}
