package Commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;

public class TodayCommand extends BotCommand {
    public TodayCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }


    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        LocalDate date  = LocalDate.now();
        SendMessage answer = null;
        switch (date.getDayOfWeek()){
            case MONDAY: answer = new SendMessage(chat.getId().toString(), "Алгоритмы и структуры данных  3-6\n" +
                    "доц. Ружицкая Е.А.\n" +
                    "\n" +
                    "Алгоритмы и структуры данных  1-1\n" +
                    "доц. Ружицкая Е.А., асс. Киргинцева С.В.\n" +
                    "\n" +
                    "МАТЕМАТИЧЕСКИЙ АНАЛИЗ  к..3 108\n" +
                    "доц. Казимиров Г.Н.\n" +
                    "\n" +
                    "ИНОСТР. ЯЗЫК\n" +
                    "к.3  202\n" +
                    "Короткая М.В.\t\"ИНОСТР. ЯЗЫК\n" +
                    "к.3  130\n" +
                    "Чернякова Е.А.");
                break;
            case TUESDAY: answer = new SendMessage(chat.getId().toString(),"\"КОНСТРУИРОВАНИЕ ПО\n" +
                    "4-1\n" +
                    "доц. Кузьменков Д.С.\n" +
                    "\n" +
                    "ОА и П  1-1\n" +
                    "доц. Кузьменков Д.С.\n" +
                    "ст.пр. Кузьменкова Е.Ю.\n" +
                    "\n" +
                    "МАТ. АНАЛИЗ\n" +
                    "4-6\n" +
                    "доц. Казимиров Г.Н.\t\"МАТ. АНАЛИЗ\n" +
                    "4-13\n" +
                    "доц. Атвиновский А.А.\n" +
                    "\n" +
                    "ФИЗИЧЕСКАЯ КУЛЬТУРА");
                break;
            case WEDNESDAY: answer = new SendMessage(chat.getId().toString(),"\"ОСНОВЫ АЛГОРИТМИЗАЦИИ И ПРОГРАММИРОВАНИЯ\n" +
                    "3-1\n" +
                    "доц. Кузьменков Д.С.\n" +
                    "\n" +
                    "МАТЕМАТИЧЕСКИЙ АНАЛИЗ\n" +
                    "к.3  108\n" +
                    "доц. Казимиров Г.Н.\n" +
                    "\n" +
                    "ЧИСЛЕННЫЕ МЕТОДЫ  1-1\n" +
                    "доц. Березовская Е.М.\n" +
                    "проф. Можаровский В.В.");
                break;
            case THURSDAY:answer = new SendMessage(chat.getId().toString(), "ФИЗИКА  4-5\n" +
                    "проф. Гиргель С.С.\n" +
                    "ИСТОРИЯ БЕЛАРУСИ  к. 3  108\n" +
                    "асс. Артюшко Н.А.\n" +
                    "\n" +
                    "ФИЗИКА\n" +
                    "4-5\n" +
                    "проф. Гиргель С.С.\n" +
                    "\n" +
                    "КОНСТРУИРОВАНИЕ ПО  1-1\n" +
                    "доц. Кузьменков Д.С.\n" +
                    "ст.пр. Кузьменкова Е.Ю.\n" +
                    "\n" +
                    "ФИЗИЧЕСКАЯ КУЛЬТУРА");
                break;
            case FRIDAY:answer = new SendMessage(chat.getId().toString(),"ФИЗИКА  4-5\n" +
                    "проф. Гиргель С.С.\"\n" +
                    "ИСТОРИЯ БЕЛАРУСИ  к. 3  108\n" +
                    "доц. Алексейченко Г.А.\n" +
                    "\n" +
                    "МАТ. АНАЛИЗ\n" +
                    "к.3  124\n" +
                    "доц. Казимиров Г.Н.\"\tМАТ. АНАЛИЗ\n" +
                    "к.3  130\n" +
                    "доц. Атвиновский А.А.\n" +
                    "\n" +
                    "КОРРУПЦИЯ\n" +
                    "3-1\n" +
                    "доц. Воробьёв В.А.\n" +
                    "\n" +
                    "ИНОСТР. ЯЗЫК\n" +
                    "4-13\n" +
                    "Короткая М.В.\tИНОСТР. ЯЗЫК\n" +
                    "4-11\n" +
                    "Чернякова Е.А.");
                break;
            case SATURDAY: answer = new SendMessage(chat.getId().toString(), "ЧИСЛЕННЫЕ МЕТОДЫ\n" +
                    "3-6");
                break;
        }
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
