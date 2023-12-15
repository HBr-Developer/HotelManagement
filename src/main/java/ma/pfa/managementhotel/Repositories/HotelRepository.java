package ma.pfa.managementhotel.Repositories;

import ma.pfa.managementhotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

//    List<Hotel> findByLocationAndStartDateAndEndDate(
//            String location, Date startDate, Date endDate
//    );


    @Query("SELECT h FROM Hotel h WHERE h.location = :location AND h.startDate = :startDate AND h.endDate = :endDate")
    List<Hotel> findByLocationAndStartDateAndEndDate(
            @Param("location") String location,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate  endDate
    );
}
