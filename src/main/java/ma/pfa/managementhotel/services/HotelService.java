package ma.pfa.managementhotel.services;

import ma.pfa.managementhotel.entities.HotelDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HotelService {

    List<HotelDTO> searchHotels(String location, LocalDate startDate, LocalDate  endDate);
}
