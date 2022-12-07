package repository.impl;

import model.Facility;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String SELECT_FACILITY = "select  * from facility \n" +
            "join facility_type on facility_type.id_facility_type = facility.id_facility_type\n" +
            "join rent_type on rent_type.id_rent_type = facility.id_rent_type;";
    private static final String DELETE_FACILITY = "delete from facility where id_facility =?";
    private static final String SEARCH_FACILITY = "select  * from facility \n" +
            "join facility_type on facility_type.id_facility_type = facility.id_facility_type\n" +
            "join rent_type on rent_type.id_rent_type = facility.id_rent_type\n" +
            "where name_facility like ?";
    private static final String SELECT_FACILITY_BY_ID = "select  * from facility \n" +
            "join facility_type on facility_type.id_facility_type = facility.id_facility_type\n" +
            "join rent_type on rent_type.id_rent_type = facility.id_rent_type WHERE id_facility = ?";
    private static final String ADD_FACILITY_VILLA = "insert into facility(id_facility,name_facility, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors,id_facility_type, id_rent_type) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_FACILITY_HOUSE = "insert into facility(id_facility,name_facility, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors,id_facility_type, id_rent_type) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_FACILITY_ROOM = "insert into facility(id_facility,name_facility, area, cost, max_people,pool_area, number_of_floors,facility_free,id_facility_type, id_rent_type) values (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_FACILITY = "update facility set name_facility =?,area=?, cost=?, max_people=?,standard_room=?, description_other_convenience=?,pool_area=?, number_of_floors=?,facility_free=?,id_facility_type=?, id_rent_type=? where id_facility=?";

    @Override
    public List<Facility> selectFacility() throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = connection.prepareStatement(SELECT_FACILITY);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id_facility");
            String name = resultSet.getString("name_facility");
            int area = resultSet.getInt("area");
            double cost = resultSet.getDouble("cost");
            int maxPeople = resultSet.getInt("max_people");
            String standardRoom = resultSet.getString("standard_room");
            String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
            double poolArea = resultSet.getDouble("pool_area");
            int numberOfFloors = resultSet.getInt("number_of_floors");
            String facilityFree = resultSet.getString("facility_free");
            String nameFacilityType = resultSet.getString("name_facility_type");
            String nameRentType = resultSet.getString("name_rent_type");
            facilityList.add(new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, nameFacilityType, nameRentType));
        }
        return facilityList;
    }

    public boolean deleteFacility(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addFacilityVilla(Facility facility) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(ADD_FACILITY_VILLA)) {
            statement.setInt(1, facility.getId());
            statement.setString(2, facility.getName());
            statement.setInt(3, facility.getArea());
            statement.setDouble(4, facility.getCost());
            statement.setInt(5, facility.getMaxPeople());
            statement.setString(6, facility.getStandardRoom());
            statement.setString(7, facility.getDescriptionOtherConvenience());
            statement.setDouble(8, facility.getPoolArea());
            statement.setInt(9, facility.getNumberOfFloors());
            statement.setString(10, facility.getNameFacilityType());
            statement.setString(11, facility.getNameRentType());
            System.out.println(statement);
            statement.executeUpdate();
        }
    }

    @Override
    public void addFacilityRoom(Facility facility) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(ADD_FACILITY_ROOM)) {
            statement.setInt(1, facility.getId());
            statement.setString(2, facility.getName());
            statement.setInt(3, facility.getArea());
            statement.setDouble(4, facility.getCost());
            statement.setInt(5, facility.getMaxPeople());
            statement.setDouble(6, facility.getPoolArea());
            statement.setInt(7, facility.getNumberOfFloors());
            statement.setString(8, facility.getFacilityFree());
            statement.setString(9, facility.getNameFacilityType());
            statement.setString(10, facility.getNameRentType());
            System.out.println(statement);
            statement.executeUpdate();
        }
    }

    @Override
    public void addFacilityHouse(Facility facility) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(ADD_FACILITY_HOUSE)) {
            statement.setInt(1, facility.getId());
            statement.setString(2, facility.getName());
            statement.setInt(3, facility.getArea());
            statement.setDouble(4, facility.getCost());
            statement.setInt(5, facility.getMaxPeople());
            statement.setString(6, facility.getStandardRoom());
            statement.setString(7, facility.getDescriptionOtherConvenience());
            statement.setDouble(8, facility.getPoolArea());
            statement.setInt(9, facility.getNumberOfFloors());
            statement.setString(10, facility.getNameFacilityType());
            statement.setString(11, facility.getNameRentType());
            System.out.println(statement);
            statement.executeUpdate();
        }
    }


    @Override
    public void updateFacility(Facility facility) {
        boolean rowUpdated = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FACILITY)) {
            statement.setString(1,facility.getName());
            statement.setInt(2,facility.getArea());
            statement.setDouble(3,facility.getCost());
            statement.setInt(4,facility.getMaxPeople());
            statement.setString(5,facility.getStandardRoom());
            statement.setString(6,facility.getDescriptionOtherConvenience());
            statement.setDouble(7,facility.getPoolArea());
            statement.setInt(8,facility.getNumberOfFloors());
            statement.setString(9,facility.getFacilityFree());
            statement.setString(10,facility.getNameFacilityType());
            statement.setString(11,facility.getNameRentType());
            statement.setInt(12,facility.getId());
            rowUpdated = statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Facility selectFacility(int id_facility) {
        Facility facility = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_BY_ID)) {
            preparedStatement.setInt(1, id_facility);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameOne = resultSet.getString("name_facility");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                String nameFacilityType = resultSet.getString("name_facility_type");
                String nameRentType = resultSet.getString("name_rent_type");
                facility = new Facility(id_facility, nameOne, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, nameFacilityType, nameRentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public List<Facility> searchName(String name) throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = connection.prepareStatement(SEARCH_FACILITY);
        statement.setString(1, "%" + name + "%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_facility");
            String nameOne = rs.getString("name_facility");
            int area = rs.getInt("area");
            double cost = rs.getDouble("cost");
            int maxPeople = rs.getInt("max_people");
            String standardRoom = rs.getString("standard_room");
            String descriptionOtherConvenience = rs.getString("description_other_convenience");
            double poolArea = rs.getDouble("pool_area");
            int numberOfFloors = rs.getInt("number_of_floors");
            String facilityFree = rs.getString("facility_free");
            String nameFacilityType = rs.getString("name_facility_type");
            String nameRentType = rs.getString("name_rent_type");
            facilityList.add(new Facility(id, nameOne, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, nameFacilityType, nameRentType));
        }
        return facilityList;
    }
}
