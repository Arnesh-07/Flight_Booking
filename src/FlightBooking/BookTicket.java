package FlightBooking;
import java.util.*;

public class BookTicket {
    public static void book(Flight currentFlight,int tickets,int passengerID)
    {
        String passengerDetail= "Passenger ID " + passengerID + " -- " + " Number of Tickets Booked "
                + tickets + " -- " + "Total cost " + currentFlight.price * tickets;

        currentFlight.addPassengerDetails(passengerDetail,tickets,passengerID);

        currentFlight.flightSummary();
        currentFlight.printDetails();

    }

    public static void cancel(Flight currentFlight, int passengerID)
    {
        // calling cancel function on the flight object
        currentFlight.cancelTicket(passengerID);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void print(Flight f)
    {
        f.printDetails();
    }


    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 2; i++)
            flights.add(new Flight());

        int passengerID = 1;
        boolean looper=true;

        while (looper) {
            System.out.println("Welcome to Zeus Airlines");
            System.out.println("1. Book 2. Cancel 3. Print 4.Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();


            switch (choice) {
                //booking Tickets
                case 1: {
                    System.out.println("Enter Flight ID");
                    int fid = sc.nextInt();

                    if (fid > flights.size()) {
                        System.out.println("Invalid flight ID");
                        System.out.println();
                        break;
                    }

                    Flight currentFlight = null;
                    for (Flight f : flights) {
                        if (f.flightID == fid) {
                            currentFlight = f;
                            f.flightSummary();
                            break;
                        }
                    }

                    System.out.println("Enter number of tickets");
                    int t = sc.nextInt();

                    if (t > currentFlight.tickets) {
                        System.out.println("Not Enough Tckets");
                        System.out.println();
                        break;
                    }

                    book(currentFlight, t, passengerID);
                    System.out.println();

                    passengerID = passengerID + 1;
                    break;
                }

                case 2: {
                    System.out.println("Enter flight ID and passenger ID to cancel booking");
                    int fid = sc.nextInt();

                    //check if flight id is valid
                    if (fid > flights.size()) {
                        System.out.println("Invalid flight ID");
                        System.out.println();
                        break;
                    }

                    Flight currentFlight = null;
                    for (Flight f : flights) {
                        if (f.flightID == fid) {
                            currentFlight = f;
                            break;
                        }
                    }
                    int id = sc.nextInt();

                    cancel(currentFlight,id);
                    System.out.println();
                    break;
                }
                case 3:
                {

                    for(Flight f : flights)
                    {

                        if(f.passengerDetails.size() == 0)
                        {
                            System.out.println("No passenger Details for  - Flight " + f.flightID);

                        }
                        else
                            print(f);
                    }

                    break;
                }
                case 4:
                {
                    looper=false;
                }
            }
        }
    }
}
