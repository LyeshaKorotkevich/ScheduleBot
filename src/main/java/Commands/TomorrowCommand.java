package Commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;

public class TomorrowCommand extends BotCommand {
    public TomorrowCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        LocalDate date = LocalDate.now();
        SendMessage answer = null;
        switch (date.getDayOfWeek().plus(1)) {
            case MONDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("MONDAY"));
                break;
            case TUESDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("TUESDAY"));
                break;
            case WEDNESDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("WEDNESDAY"));
                break;
            case THURSDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("THURSDAY"));
                break;
            case FRIDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("FRIDAY"));
                break;
            case SATURDAY:
                answer = new SendMessage(chat.getId().toString(), DBCommand.getDay("SATURDAY"));
                break;
        }
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
