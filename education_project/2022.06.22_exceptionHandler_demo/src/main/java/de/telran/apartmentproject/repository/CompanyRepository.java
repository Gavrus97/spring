package de.telran.apartmentproject.repository;

import de.telran.apartmentproject.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
