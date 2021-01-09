package david.discord.longmsg.Service;

import david.discord.longmsg.Entity.DiscordMessage;
import david.discord.longmsg.NotFoundException;
import david.discord.longmsg.Repository.DiscordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DLMService {
    @Autowired
    private static DiscordRepository discordRepository;

    public DLMService(DiscordRepository discordRepository){
        this.discordRepository = discordRepository;
    }

    public static DiscordMessage getMessage(String id){
        return discordRepository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    public static DiscordMessage addMsg(DiscordMessage msg){
        DiscordMessage DMsg = new DiscordMessage();
        DMsg.setMessage(msg.getMessage());

        // add in database
        discordRepository.insert(DMsg);
        return DMsg;
    }
}
