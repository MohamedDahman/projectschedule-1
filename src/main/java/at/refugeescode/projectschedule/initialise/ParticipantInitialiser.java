package at.refugeescode.projectschedule.initialise;

import at.refugeescode.projectschedule.persistence.Participant;
import at.refugeescode.projectschedule.persistence.ParticipantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParticipantInitialiser {

    @Bean
    ApplicationRunner initialiseParticipants(ParticipantRepository participantRepository){
        return applicationArguments -> {

            Participant ghiath = new Participant();
            ghiath.setName("Ghiath");

            Participant ismael = new Participant();
            ismael.setName("Ismael");

            participantRepository.save(ghiath);
            participantRepository.save(ismael);

            participantRepository.findAll().forEach(System.out::println);
        };
    }

}
