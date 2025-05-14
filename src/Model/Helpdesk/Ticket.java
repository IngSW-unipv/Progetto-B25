package Model.Helpdesk;

import java.time.LocalDate;

public class Ticket {

    private int ticket_id;
    private String title;
    private StateTicket state;
    private int user_id;
    private LocalDate creation_date;

    /**
     * costruttore che si usa nel momento della creazione di un nuovo oggetto Ticket all'interno del db
     * @param title
     * @param user_id
     */
    public Ticket(String title, int user_id) {
        this.title = title;
        this.user_id = user_id;
        state=StateTicket.APERTO;
        creation_date=LocalDate.now();
    }

    /**
     * costruttore che si usa nel momento di visualizzazione di un oggetto già salvato precedentemente nel db
     * @param ticket_id
     * @param title
     * @param state
     * @param user_id
     * @param creation_date
     */
    public Ticket(int ticket_id, String title, StateTicket state, int user_id, LocalDate creation_date) {
        this.title = title;
        this.state = state;
        this.user_id = user_id;
        this.ticket_id = ticket_id;
        this.creation_date = creation_date;
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
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public StateTicket getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(StateTicket state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     *
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * @return
     */
    public LocalDate getCreation_date() {
        return creation_date;
    }

    /**
     *
     * @param creation_date
     */
    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }
}
