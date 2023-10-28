package controller;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import utils.CSVReader;
import model.*;

public class Controller {
    
    private List<Ticket> Tickets;
    
    public Controller() throws IOException {
        setTickets("src/data/db.csv");
    }

    private List<List<String>> readCSV(String filePath) throws IOException {
        CSVReader reader = new CSVReader(filePath);
        return reader.read();
    }

    public void setTickets(String filePath) throws IOException {
        List<List<String>> data = readCSV(filePath);
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (List<String> row : data) {
            String priority = row.get(0);
            priority = priority.toLowerCase();
            int hours = Integer.parseInt(row.get(1));
            String day = row.get(2);
            String employee = row.get(3);
            String client = row.get(4);
            switch (priority) {
                case "alta":
                    tickets.add(new AltaPrio(hours, day, employee, client));
                    break;
                case "media":
                    tickets.add(new MedPrio(hours, day, employee, client));
                    break;
                case "baja":
                    tickets.add(new BajPrio(hours, day, employee, client));
                    break;
                default:
                    break;
            }
        }
        this.Tickets = tickets;
    }

    //cantidad tickets por cada prioridad
    public int[] getTicketsPriority() {
        int[] ticketsByPriority = new int[3];
        for (Ticket ticket : this.Tickets) {
            if (ticket instanceof AltaPrio) {
                ticketsByPriority[2]++;
            } else if (ticket instanceof MedPrio) {
                ticketsByPriority[1]++;
            } else if (ticket instanceof BajPrio) {
                ticketsByPriority[0]++;
            }
        }
        return ticketsByPriority;
    }

    //prioridad de tickets con mas suma de totales
    public String getTopPriority(){
        double totalAlta = 0;
        double totalMed = 0;
        double totalBaja = 0;
        String topPriority = "";

        for (Ticket ticket : this.Tickets) {
            if (ticket instanceof AltaPrio) {
                totalAlta += ticket.getTotal();
            } else if (ticket instanceof MedPrio) {
                totalMed += ticket.getTotal();
            } else if (ticket instanceof BajPrio) {
                totalBaja += ticket.getTotal();
            }
        }

        if (totalAlta > totalMed && totalAlta > totalBaja) {
            topPriority = "Alta con $" + totalAlta;
        } else if (totalMed > totalAlta && totalMed > totalBaja) {
            topPriority = "Media con $" + totalMed;
        } else if (totalBaja > totalAlta && totalBaja > totalMed) {
            topPriority = "Baja con $" + totalBaja;
        } else {
            topPriority = "No hay prioridad con mas suma de totales";
        }  

        return topPriority;
    }


}
