package model;

public class AltaPrio implements Ticket{

    //attributes
    protected int horas;
    protected String dia;
    protected String cliente;
    protected String empleado;
    private double comision;
    private double total;


    //constructor
    public AltaPrio(int horas, String dia, String empleado,String cliente) {
        this.horas = horas;
        this.dia = dia;
        this.empleado = empleado;
        this.cliente = cliente;
        setTotal(horas);
    }


    //methods
    @Override
    public String getPriority() {
        return "Alta";
    }

    @Override
    public void setTotal(int horas) {
        dia = this.dia.toLowerCase();
        double totaltemporal = horas * 8;
        switch(dia) {
            case "lunes":
            case "martes":
            case "miercoles":
            case "jueves":
            case "viernes":
                comision = totaltemporal*0.05;
                break;
            default:
                comision = totaltemporal*0.20;
                break;
        }
        this.total = (horas * 8)+comision;
    }

    @Override
    public double getTotal() {
        return total;
    }

    
}
