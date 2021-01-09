package david.discord.longmsg.Repository;

import david.discord.longmsg.Entity.DiscordMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscordRepository extends MongoRepository<DiscordMessage, String> {
    DiscordMessage findDiscordById(String id);
}
