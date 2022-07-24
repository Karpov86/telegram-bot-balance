import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


class TelegramBotApplication

fun main() {
    TelegramBotsApi(DefaultBotSession::class.java).registerBot(Bot())
}

class Bot : TelegramLongPollingBot() {
    override fun getBotToken() = "1911676689:AAH3KTXoBdHfnFn2NgPvvGzTn3PLKRYfcHQ"

    override fun getBotUsername() = "KarpovBalanceBot"

    override fun onUpdateReceived(update: Update) {
        if (update.message.text == "/start") {
            val sendMessage = SendMessage()
            sendMessage.chatId = update.message.chatId.toString()
            sendMessage.text = "Hi!"
            execute(sendMessage)
        }
    }
}