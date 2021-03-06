package com.betinvest.client.repository;

import com.betinvest.client.domain.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface LeagueRepository extends JpaRepository<League, Integer> {

    List<League> findAll();

    List<League> findByCountryIdAndSportId(int countryId, int sportId);

    List<League> findByIdIn(Set<Integer> idSet);

    @Query(" select l.id from League l")
    Set<Integer> getIdSet();

    @Query(" select l.id from League l where l.name= ?1 and l.country.id = ?2 and l.sport.id = ?3")
    Integer getIdByNameAndCountryIdAndSportId(String name, Integer countryId, Integer sportId);
}
