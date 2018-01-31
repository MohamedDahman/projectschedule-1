package at.refugeescode.projectschedule.controller;

import at.refugeescode.projectschedule.persistence.Participant;
import at.refugeescode.projectschedule.persistence.ParticipantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    private ParticipantRepository participantRepository;

    public ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping
    String page(){
        return "participants";
    }

    @PostMapping
    String add(@Valid Participant participant, BindingResult result){
        if(result.hasErrors()){
            return page();
        }
        participantRepository.save(participant);
        return "redirect:" + page();
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {
        participantRepository.delete(id);
        return "redirect:/" + page();
    }

    @ModelAttribute("participants")
    List<Participant> participants(){
        return participantRepository.findAll();
    }

    @ModelAttribute("participant")
    Participant participant(){
        return new Participant();
    }

}
