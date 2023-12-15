package ma.pfa.managementhotel.controllers;


import ma.pfa.managementhotel.entities.Hotel;
import ma.pfa.managementhotel.entities.HotelDTO;
import ma.pfa.managementhotel.services.HotelService;
import ma.pfa.managementhotel.services.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/search")
    public List<HotelDTO> searchHotels(
            @RequestParam String location,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  endDate) {

        return hotelService.searchHotels(location, startDate, endDate);
    }
}
