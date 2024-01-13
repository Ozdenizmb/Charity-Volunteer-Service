package com.tallstech.volunteer.repository.query;

public class EventSqlQueries {

    private EventSqlQueries() {}

    public static final String SELECT_CHARITY_ID = "SELECT charity_id FROM CHARITY_ADMINS WHERE id = ?";

    public static final String INSERT_QUERY = "INSERT INTO EVENTS (charity_id, charity_admin_id, name," +
            "description, country, city, district, address, category, start_date, start_time, duration, requirement," +
            "condition, number_of_volunteers, event_create_time, event_update_time, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_QUERY = "SELECT id, charity_id, charity_admin_id, name, description," +
            "country, city, district, address, category, start_date, start_time, duration, requirement, condition, " +
            "number_of_volunteers, event_create_time, event_update_time, status FROM EVENTS WHERE id = ?";

    public static final String UPDATE_QUERY = "UPDATE EVENTS SET name = ?, description = ?, country = ?, " +
            "city = ?, district = ?, address = ?, category = ?, start_date = ?, start_time = ?, " +
            "duration = ?, requirement = ?, condition = ?, number_of_volunteers = ?, " +
            "event_update_time = ? WHERE id = ?";

    public static final String DELETE_QUERY = "DELETE FROM EVENTS WHERE id = ?";
}
