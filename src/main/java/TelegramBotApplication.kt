import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


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
        if (update.message.text == "/but") {
            val keyboard = ReplyKeyboardMarkup()
            keyboard.keyboard = listOf(
                KeyboardRow().apply {
                    add(KeyboardButton("Balance"))
                }
            )
        }
    }
}