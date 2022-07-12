package de.telran.job_search.repository;

import de.telran.job_search.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
}
