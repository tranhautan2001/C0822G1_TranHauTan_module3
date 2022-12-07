package repository;

import model.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityRepository {
    List<Facility> selectFacility() throws SQLException;
    boolean deleteFacility(int id) throws SQLException;
    void addFacilityVilla(Facility facility)throws SQLException;

    void addFacilityRoom(Facility facility)throws SQLException;

    void addFacilityHouse(Facility facility)throws SQLException;

    void updateFacility(Facility facility) throws SQLException;

    Facility selectFacility(int id_facility);

    List<Facility> searchName(String name) throws SQLException;

}
