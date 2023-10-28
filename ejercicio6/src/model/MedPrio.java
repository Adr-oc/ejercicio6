package model;

public class MedPrio implements Ticket{

    //attributes
    protected int horas;
    protected String dia;
    protected String cliente;
    protected String empleado;
    private double comision;
    private double total;


    //constructor
    public MedPrio(int horas, String dia, String empleado,String cliente) {
        this.horas = horas;
        this.dia = dia;
        this.empleado = empleado;
        this.cliente = cliente;
        setTotal(horas);
    }


    //methods
    @Override
    public String getPriority() {
        return "Media";
    }

    @Override
    public void setTotal(int horas) {
        empleado = this.empleado.toLowerCase();
        double totaltemporal = horas * 8;
        switch(empleado) {
            case "a":
                comision = totaltemporal*0.06;
                break;
            case "b":
                comision = totaltemporal*0.08;
                break;
            case "c":
                comision = totaltemporal*0.10;
                break;
            default:
                comision = totaltemporal*0.05;
                break;
        }
        this.total = (horas * 10)+comision;
    }

    @Override
    public double getTotal() {
        return total;
    }

   
    
}
