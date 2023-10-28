package model;

public class BajPrio implements Ticket{
    
    //attributes
    protected int horas;
    protected String dia;
    protected String cliente;
    protected String empleado;
    private double total;


    //constructor
    public BajPrio(int horas, String dia, String empleado,String cliente) {
        this.horas = horas;
        this.dia = dia;
        this.empleado = empleado;
        this.cliente = cliente;
        setTotal(horas);
    }


    //methods
    @Override
    public String getPriority() {
        return "Baja";
    }

    @Override
    public void setTotal(int horas) {
        this.total = (horas * 10);
    }

    @Override
    public double getTotal() {
        return total;
    }

   
    
}
