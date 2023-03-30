package bot.discord.BirthdayBot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import reactor.core.publisher.Mono;

//@SpringBootApplication
public class BirthdayBotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BirthdayBotApplication.class, args);
//	    DiscordClient client = DiscordClient.create("TOKEN");
//	    Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> Mono.empty());
//	    login.block();  
	    
	    BirthdayBotHTTPRequest localtest = new BirthdayBotHTTPRequest();
	    try {
			localtest.startConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Server scheint offline zu sein!");
			e.printStackTrace();
		}
	}

}
