package Commands;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

    /**
     * Команда "Помощь"
     */
    public class HelpCommand extends ServiceCommand {

        public HelpCommand(String identifier, String description) {
            super(identifier, description);
        }

        @Override
        public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), "",
                    "Я бот, который поможет вам вспомнить расписание\n" +
                            "❗*Список команд*\n" +
                            "/today - расписание на сегодня\n" +
                            "/week - расписание на неделю\n" +
                            "/help - помощь\n"
                            );
    }
}
