package com.tallstech.volunteer.repository.query;

public class ApplicationsSqlQueries {

    private ApplicationsSqlQueries() {}

    public static final String SELECT_CHARITY_ID = "SELECT charity_id FROM EVENTS WHERE id = ?";

    public static final String INSERT_QUERY = "INSERT INTO APPLICATIONS (volunteer_id, charity_id," +
            "event_id, application_create_date, application_result, status) VALUES (?, ?, ?, ?, ?, ?)";

}
