
package fr.ece.autoloc;

import fr.ece.autoloc.domain.Vehicule;
import fr.ece.autoloc.domain.CategorieVehicule;
import fr.ece.autoloc.domain.StatutVehicule;
import fr.ece.autoloc.repository.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*@Component
public class DataInitializer implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;

    public DataInitializer(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Vehicule vehicule1 = new Vehicule(
                null, "AA-123-BB", "Renault", "Clio",
                CategorieVehicule.CITADINE,
                new BigDecimal("35.00"),
                StatutVehicule.DISPONIBLE
        );

        Vehicule vehicule2 = new Vehicule(
                null, "CC-456-DD", "Peugeot", "3008",
                CategorieVehicule.SUV,
                new BigDecimal("60.00"),
                StatutVehicule.DISPONIBLE
        );

        Vehicule vehicule3 = new Vehicule(
                null, "EE-789-FF", "Mercedes", "Classe C",
                CategorieVehicule.BERLINE,
                new BigDecimal("75.00"),
                StatutVehicule.LOUE
        );

        if (vehiculeRepository.count() == 0) {

            // Tes trois véhicules ici

            vehiculeRepository.save(vehicule1);
            vehiculeRepository.save(vehicule2);
            vehiculeRepository.save(vehicule3);
        }
    }
}*/
