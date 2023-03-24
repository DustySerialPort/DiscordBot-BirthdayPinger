package bot.discord.BirthdayBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;

public class BotConfig {

	
    @Value("${token}")
    private String token = "MTA4ODY5NTEyMjU5OTg4MjgyNA.GfPpil.XwQJGshHpzM_ZnjcNuKDXnIJyTl582cdlmKIxc";

    @Bean
    public GatewayDiscordClient gatewayDiscordClient() {
        return DiscordClientBuilder.create(token)
          .build()
          .login()
          .block();
    }
}
