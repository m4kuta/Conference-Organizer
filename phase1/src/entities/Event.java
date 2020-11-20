package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Event represents any events such as talk, presentation, and so on
 *
 *<pre>
 * Entity Event
 *
 * Responsibilities:
 * Stores information about the Event.
 * Stores time of Event
 * Can return this information
 *
 * Collaborators:
 * None
 *</pre>
 */
public class Event implements Serializable, Comparable<Event> {
    private String topic;
    private String location;
    private Calendar time;
    private String organizer;
    private ArrayList<String> attendees = new ArrayList<>();
    private int id;

    //------------------------------------------------------------
    // Constructors
    //------------------------------------------------------------

    /**
     * Creates an event with topic and time.
     * @param topic event topic.
     * @param time event time.
     */
    public Event(Integer id, String topic, Calendar time, String location, String organizer) {
        this.topic = topic;
        this.time = time;
        this.location = location;
        this.organizer = organizer;
        this.id = id;
    }

    //------------------------------------------------------------
    // Methods
    //------------------------------------------------------------

    /**
     * Gets the Event info.
     * @return  Event info.
     */

    public int compareTo(Event event) {
        return this.time.compareTo(event.time);
    }

    /**
     * Compares for equality.
     *
     * @param other other message to compare
     * @return True if the same topic, time, location, and organizer are matched.
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Event){
            Event o = (Event)other;
            return
                    getTopic().equals(o.getTopic()) &&
                            getTime().getTimeInMillis() == o.getTime().getTimeInMillis() &&
                            getLocation().equals(o.getLocation()) &&
                            getOrganizer().equals(o.getOrganizer());
        }
        return false;
    }

    /**
     * @return hash code
     */
    @Override
    public int hashCode(){
        return topic.hashCode() / 10 + getOrganizer().hashCode() % 1000;
    }

    //------------------------------------------------------------
    // Getters and Setters
    //------------------------------------------------------------

    /**
     * @return topic
     */
    public String getTopic() {
        return topic;
    }
    /**
     * @return time
     */
    public Calendar getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public int getId() {
        return id;
    }

    /**
     * @param topic event topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @param time event start time
     */
    public void setTime(Calendar time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setId(int id) {
        this.id = id;
    }
}

