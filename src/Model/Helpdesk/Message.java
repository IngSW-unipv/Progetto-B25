package Model.Helpdesk;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Message {

    private int message_id;
    private String text;
    private int ticket_id;
    private int admin_id;
    private LocalTime message_time;
    private LocalDate message_date;

    /**
     * costruttore che si usa nel momento della creazione di un nuovo oggetto Message all'interno del db
     * @param text
     * @param ticket_id
     * @param admin_id
     */
    public Message(String text, int ticket_id, int admin_id) {
        this.text = text;
        this.ticket_id = ticket_id;
        this.admin_id = admin_id;
        message_time=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);;
        message_date=LocalDate.now();

    }

    /**
     * costruttore che si usa nel momento di visualizzazione di un oggetto già salvato precedentemente nel db
     * @param message_id
     * @param text
     * @param ticket_id
     * @param admin_id
     * @param message_time
     * @param message_date
     */
    public Message(int message_id, String text, int ticket_id, int admin_id, LocalTime message_time, LocalDate message_date) {
        this.message_id = message_id;
        this.text = text;
        this.ticket_id = ticket_id;
        this.admin_id = admin_id;
        this.message_time = message_time;
        this.message_date = message_date;
    }

    /**
     *
     * @return
     */
    public int getMessage_id() {
        return message_id;
    }

    /**
     *
     * @param message_id
     */
    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public int getTicket_id() {
        return ticket_id;
    }

    /**
     *
     * @param ticket_id
     */
    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    /**
     *
     * @return
     */
    public int getAdmin_id() {
        return admin_id;
    }

    /**
     *
     * @param admin_id
     */
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    /**
     *
     * @return
     */
    public LocalTime getMessage_time() {
        return message_time;
    }

    /**
     *
     * @param message_time
     */
    public void setMessage_time(LocalTime message_time) {
        this.message_time = message_time;
    }

    /**
     *
     * @return
     */
    public LocalDate getMessage_date() {
        return message_date;
    }

    /**
     *
     * @param message_date
     */
    public void setMessage_date(LocalDate message_date) {
        this.message_date = message_date;
    }
}
