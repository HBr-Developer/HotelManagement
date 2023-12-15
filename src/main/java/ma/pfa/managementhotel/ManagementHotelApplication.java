package ma.pfa.managementhotel;

import ma.pfa.managementhotel.Repositories.HotelRepository;
import ma.pfa.managementhotel.entities.Hotel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ManagementHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementHotelApplication.class, args);
    }


    @Bean
    public CommandLineRunner initData(HotelRepository hotelRepository) {
        return args -> {
            Hotel hotel1 = new Hotel();
            hotel1.setName("Hotel1");
            hotel1.setLocation("Paris");
            hotel1.setStartDate(LocalDate.now());
            hotel1.setEndDate(LocalDate.now().plusDays(7));
            hotel1.setPrice(123.00);
            hotel1.setRating(5);
            hotel1.setDescription("Cet hôtel offre une vue magnifique sur la ville.");


            Hotel hotel2 = new Hotel();
            hotel2.setName("Hôtel B");
            hotel2.setLocation("New York");
            hotel2.setStartDate(LocalDate.now());
            hotel2.setEndDate(LocalDate.now().plusDays(5));
            hotel2.setPrice(123.00);
            hotel2.setRating(5);
            hotel2.setDescription("Un hôtel de luxe au cœur de New York.");

            hotelRepository.save(hotel1);
            hotelRepository.save(hotel2);
        };
    }


}
