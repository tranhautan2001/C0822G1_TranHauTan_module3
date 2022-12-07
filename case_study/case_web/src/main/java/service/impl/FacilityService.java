package service.impl;

import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.List;

public class FacilityService implements IFacilityService {
    IFacilityRepository iFacilityRepository = new FacilityRepository();
    @Override
    public List<Facility> selectFacility() throws SQLException {
        return iFacilityRepository.selectFacility();
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        return iFacilityRepository.deleteFacility(id);
    }

    @Override
    public void addFacilityVilla(Facility facility) throws SQLException {
        iFacilityRepository.addFacilityVilla(facility);
    }

    @Override
    public void addFacilityRoom(Facility facility) throws SQLException {
       iFacilityRepository.addFacilityRoom(facility);
    }

    @Override
    public void addFacilityHouse(Facility facility) throws SQLException {
       iFacilityRepository.addFacilityHouse(facility);
    }


    @Override
    public void updateFacility(Facility facility) throws SQLException {
        iFacilityRepository.updateFacility(facility);
    }

    @Override
    public Facility selectFacility(int id_facility) {
        return iFacilityRepository.selectFacility(id_facility);
    }

    @Override
    public List<Facility> searchName(String name) throws SQLException {
        return iFacilityRepository.searchName(name);
    }
}
