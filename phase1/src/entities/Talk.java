package entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Talk represents Talk in an Event
 * <pre>
 *
 * Entity Talk
 *
 * Responsibilities:
 * Stores information about the Event.
 * Stores time of Event
 * Can return this information
 * Stores the SpeakerAccounts of the talk
 * Stores the AttendeeAccounts of the talk
 * Stores the OrganizerAccounts of the talk
 * Can return this information
 *
 * Collaborators:
 * Accounts
 * </pre>
 */
public class Talk extends Event implements Serializable {
    private String speaker;

    //------------------------------------------------------------
    // Constructors
    //------------------------------------------------------------

    /**
     * Create an Talk with topic, time, speaker, and organizer.
     *
     * <pre>
     * Example
     *
     * Calendar ev_date = Calendar.getInstance();
     * ev_date.set(2020, 03, 23, 10, 12);
     * Account organizer = new Account();
     * Account speaker = new Account();
     *
     * // Create an event
     * Talk event1 =
     *         new Talk("topic1", ev_date,speaker,organizer);
     * System.out.println(event1);
     * </pre>
     * @param topic topic for the talk
     * @param time time for the talk
     * @param speaker speaker for the talk
     * @param organizer organizer for the talk
     */
    public Talk(Integer id, String topic, Calendar time, String location, String organizer, String speaker) {
        super(id, topic, time, location, organizer);
        this.speaker = speaker;
    }

    //------------------------------------------------------------
    // Methods
    //------------------------------------------------------------

    /**
     * Compares for equality.
     *
     * @param other other message to compare
     * @return True if the same Event and speaker are matched.
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Talk){
            Talk o = (Talk)other;
            return super.equals(other) &&
                    getSpeaker().equals(o.getSpeaker());
        }
        return false;
    }

    //------------------------------------------------------------
    // Getters and Setters
    //------------------------------------------------------------

    /**
     * @return speaker
     */
    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
