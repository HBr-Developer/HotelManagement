package ma.pfa.managementhotel.services;

import ma.pfa.managementhotel.Repositories.HotelRepository;
import ma.pfa.managementhotel.entities.Hotel;
import ma.pfa.managementhotel.entities.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> searchHotels(String location, LocalDate startDate, LocalDate endDate) {

            System.out.println("Searching hotels with location: " + location +
                    ", startDate: " + startDate + ", endDate: " + endDate);

            List<Hotel> hotels = hotelRepository.findByLocationAndStartDateAndEndDate(location, startDate, endDate);

//            startDate = java.sql.Date.valueOf("2023-12-15");
//            endDate = java.sql.Date.valueOf("2023-12-15");
//
//        List<Hotel> hotels = hotelRepository.findByLocationAndStartDateAndEndDate(location, startDate, endDate);

        System.out.println("Found " + hotels.size() + " hotels.");

            // Mapper les entités Hotel en DTO HotelDto
            return hotels.stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
        }
    private HotelDTO mapToDto(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setName(hotel.getName());
        // Mapper d'autres propriétés de l'hôtel si nécessaire
        return dto;
    }
}
