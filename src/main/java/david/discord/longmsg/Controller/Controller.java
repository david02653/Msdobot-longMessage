package david.discord.longmsg.Controller;

import david.discord.longmsg.Entity.DiscordMessage;
import david.discord.longmsg.Service.DLMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/message")
public class Controller {

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getMessage(@PathVariable String id){
        // get message by id from database
        System.out.println(id);
        DiscordMessage msg = DLMService.getMessage(id);
//        return ResponseEntity.ok(msg.getMessage());
        return ResponseEntity.ok(msg.getId());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<DiscordMessage> addMsg(@RequestBody DiscordMessage msg){
        // add msg in database
        DiscordMessage DMsg = DLMService.addMsg(msg);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/add").build().toUri();
        return ResponseEntity.created(location).body(DMsg);
    }
}
