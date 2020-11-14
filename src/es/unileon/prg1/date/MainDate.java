package es.unileon.prg1.date;

public class MainDate{

    public static void main (String args[]){

        Date today,tomorrow; //Creamos objetos de tipo fecha para compararlos

        try{

            today = new Date(29,02,2016); //Llamada al contructor de la fecha que se llama desde Date y se le pasan directamente los parametros
            //tomorrow = new Date(21,12,2020);

            System.out.println(today.toString());
            //System.out.println(tomorrow.toString());
            System.out.println("Today es correcto: " + today.isRightDay()); 
            System.out.println(today.getDaysOfMonth());
            System.out.println(today.getNamesMonthLeft());
            System.out.println(today.getDaysMonthLeft());
            System.out.println(today.getTotalDaysSinceFirst()+" dias hasta principio de anyo");
            System.out.println(today.attemptsRandomDate()+" intentos");
            System.out.println("Dia de la semana today "+today.getNameWeekday());
            System.out.println("Meses con mismos dias--> "+today.getNamesMonthSameDays());
            //System.out.println(randomDate.toString());
            //System.out.println("Today es correcto: " + tomorrow.isRightDay());
            System.out.println("El mes de today es: " + today.getNameMonth()); //No se le pasa parametros porque ya se pasa el objeto today
            //System.out.println("El mes de tomorrow es: " + tomorrow.getNameMonth());
            System.out.println("La estacion de today es: " + today.getSeason());
            //System.out.println("La estacion de tomorrow es: " + tomorrow.getSeason());

            //COMPARAR DIA
            //System.out.println("today.isSameDay(tomorrow): " + today.isSameDay(tomorrow));
            //COMPARA MONTH
            //System.out.println("today.isSameMonth(tomorrow): " + today.isSameMonth(tomorrow));
            //COMPARA YEAR
            //System.out.println("today.isSameYear(tomorrow): " + today.isSameYear(tomorrow));
            //o tomorrow.isSameYear(today); es lo mismo ya que compara lo mismo
            //System.out.println("tomorrow.isSameYear(today): " + tomorrow.isSameYear(today));
            //COMPARA FECHA
            //System.out.println("today.isSame(tomorrow): " + today.isSame(tomorrow));
            System.out.println(today.toString());

        } catch(DateException e){
            System.out.println(e.getMessage());
        }

    }
    
}