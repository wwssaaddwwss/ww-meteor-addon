package org.wwss.addon.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

public class hello1234567890 extends Command {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public hello1234567890() {
        super("hello", "Sends a message.");
    }

    @Override
    public void build(LiteralArgumentBuilder<ClientSuggestionProvider> builder) {
        builder.executes(_ -> {
            info("hi");
            return SINGLE_SUCCESS;
        });

        builder.then(literal("name").then(argument("nameArgument", StringArgumentType.word()).executes(context -> {
            String argument = StringArgumentType.getString(context, "nameArgument");
            info("hi, " + argument);
            return SINGLE_SUCCESS;
        })));
    }
}
