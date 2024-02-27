package FlightBooking;
import java.util.ArrayList;

public class Flight {
    static int id = 0;
    int flightID;
    int tickets;
    int price;
    ArrayList<String> passengerDetails;
    ArrayList<Integer> passengerIDs;
    ArrayList<Integer> bookedTicketsPerPassenger;
    ArrayList<Integer> passengerCost;
    public Flight()
    {
        tickets = 50;
        price = 5000;
        id = id + 1;
        flightID = id;
        passengerDetails = new ArrayList<String>();
        passengerIDs = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<Integer>();
        passengerCost = new ArrayList<Integer>();
    }

    public void addPassengerDetails(String passengerDetail,int numberOfTickets,int passengerID)
    {
        passengerDetails.add(passengerDetail);
        bookedTicketsPerPassenger.add(numberOfTickets);
        passengerCost.add(price*numberOfTickets);
        passengerIDs.add(passengerID);
        tickets-=numberOfTickets;
        price+=200*numberOfTickets;
        System.out.println("Booked Successfully!");
        System.out.println();
    }

    public void cancelTicket(int passengerID) {
        //find the index to remove from all lists
        int indexToRemove = passengerIDs.indexOf(passengerID);
        if (indexToRemove < 0) {
            System.out.println("Passenger ID not found!");
            System.out.println();
            return;
        }
        int ticketsToCancel = bookedTicketsPerPassenger.get(indexToRemove);

        tickets+=ticketsToCancel;
        price-=200*ticketsToCancel;

        System.out.println("Refund Amount after cancel : " + passengerCost.get(indexToRemove));
        passengerCost.remove(indexToRemove);
        bookedTicketsPerPassenger.remove(indexToRemove);
        passengerIDs.remove(Integer.valueOf(passengerID));
        passengerDetails.remove(indexToRemove);

        System.out.println("Cancelled Booked Tickets Successfully!");
        System.out.println();
    }

    public void flightSummary()
    {
        System.out.println("Flight ID " + flightID + " --" + "Remaining Tickets " + tickets + " --" +
                "Current Ticket Price " + price);
        System.out.println();
    }

    public void printDetails()
    {
        System.out.println("Flight ID " + flightID + "->");
        for(String detail : passengerDetails)
            System.out.println(detail);
        System.out.println();
    }

}
