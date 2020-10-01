package dk.si.groupproject1.soap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


import localhost._8080.Town;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * In order to provide data to the web service, we created a repository.
 * The repository has hardcoded data or receives it from a database or file.
 */
@Component
public class TownRepository {
    private static final Map<Integer, Town> towns = new HashMap<>();

    @PostConstruct
    public void initData() {
        Town lyngby = new Town();
        lyngby.setName("Lyngby");
        lyngby.setCountry("Danmark");
        lyngby.setZipCode(2800);

        towns.put(lyngby.getZipCode(), lyngby);

        Town valby = new Town();
        valby.setName("Valby");
        valby.setCountry("Danmark");
        valby.setZipCode(2500);

        towns.put(valby.getZipCode(), valby);
    }

    public Town findTown(Integer zipCode) {
        Assert.notNull(zipCode, "The town's zip code must not be null");
        return towns.get(zipCode);
    }
}
