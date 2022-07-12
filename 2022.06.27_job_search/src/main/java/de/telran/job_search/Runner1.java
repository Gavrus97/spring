package de.telran.job_search;

import de.telran.job_search.entity.Candidate;
import de.telran.job_search.entity.Interview;
import de.telran.job_search.repository.CandidateRepository;
import de.telran.job_search.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Runner1 implements CommandLineRunner {


    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Candidate candidate = Candidate
                .builder()
                .name("John")
                .build();

        candidateRepository.save(candidate);

        var interviews = generateInterviews(candidate);
        interviewRepository.saveAll(interviews);

    }

    private List<Interview> generateInterviews(Candidate candidate) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Stream
                .generate(() -> Interview.builder()
                        .companyName("company " + atomicInteger.incrementAndGet())
                        .candidate(candidate)
                        .build())
                .limit(5)
                .collect(Collectors.toList());


    }
}
