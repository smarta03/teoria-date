package es.unileon.prg.date;

//La clase publica
public class Date{

    //Declaracion de variables,los atributos de dentro siempre privados.
    private int day;
    private int month;
    private int year;

    //Constructor de la fecha
    Date (int day, int month, int year){
        this.day = day;
        //this.setDay(day,month); // se pone asi para llamar a las comprobaciones
        this.month = month;
        //this.setMonth(month);
        this.year = year;
        //this.setYear(year);

    }

    void setDay(){ //Comprobacion de que es un dia valido
    
        switch (this.month){

            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    if (this.day<=0 || this.day >=31){
                        System.out.println("Dia incorrecto");
                    } else {
                        System.out.println("Dia correcto");
                    }
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    if (this.day<=0 || this.day >=30){
                        System.out.println("Dia incorrecto");
                    } else {
                        System.out.println("Dia correcto");
                    }
            break;

            case 2:if (this.day<=0 || day >= 28){  //Sin considerar bisiestos
                        System.out.println("Dia incorrecto");
                    } else {
                        System.out.println("Dia correcto");
                    }
            
            break;
        }

    }

    void setMonth(int month){ //Comprobacion de que es un mes valido
        if(this.month>12 && this.month<0){
            System.out.println("Mes incorrecto");
        } 

    }


    int getDay() {

        return this.day;

    }

    int getMonth(){
        
        return this.month;

    }


    int getYear(){
        return this.year;
    }


    //IF

    boolean isSameDay (Date anotherDate){

        return this.day == anotherDate.getDay();

    }

    boolean isSameMonth(Date anotherDate){

        return this.month == anotherDate.getMonth();
    
    }

    boolean isSameYear (Date anotherDate){ //Recibe un parametro que es un objeto de tipo fecha (tomorrow) en la priemra llamada y today en la segunda
        //boolean isSame;

        //if(this.year == anotherDate.getYear()){ //primera llamada this sera today y lo conocemos y another date seria tomorow que hay que pedirselo al metodo que devuelve el anno ya qeu no conocemos el objeto
            //isSame = true;


        //} else {
            //isSame = false;

        //}

        //Al no tener VOID significa que devuelve algo por l oque annadimos return;
        //return isSame; //Devolvemos la variable de si es igual


        //AHORA SIN IF COMO DICE EL EJERCICIO

        return this.year == anotherDate.getYear();

    }

    boolean isSame(Date anotherDate){
        boolean isSame;
        if((this.isSameDay(anotherDate)) && (this.isSameMonth(anotherDate)) && (this.isSameYear(anotherDate))){ //Para no repetir el mismo codigo que el primer if llamamos directamente al metodo
            isSame = true;
        } else {
            isSame = false;
        }

        return isSame;
    }


    //SWITCH

    String getNameMonth(){

        String name = "";

        switch (this.month){
            case 1: name = "Enero"; break;
            case 2: name = "Febrero"; break;                
            case 3: name = "Marzo"; break;
            case 4: name = "Abril"; break;
            case 5: name = "Mayo"; break;
            case 6: name = "Junio"; break;
            case 7: name = "Julio"; break;
            case 8: name = "Agosto"; break;
            case 9: name = "Septiembre"; break;
            case 10: name = "Octubre"; break;
            case 11: name = "Noviembre"; break;
            case 12: name = "Diciembre"; break;
            
            //...
            //No ponemos el default ya que se comprueba que sea un mes valido en el constructor           
        }
        
        return name;
    }

    boolean isRightDay(){

        boolean rightDay = false;
        this.day = day;
        this.month = month;

        switch (month){

            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    if (day<=0 || day >=31){
                        rightDay = false;
                    } else {
                        rightDay = true;
                    }
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    if (day<=0 || day >=30){
                        rightDay = false;
                    } else {
                        rightDay = true;
                    }
            break;

            case 2:if (day<=0 || day >= 28){  //Sin considerar bisiestos
                        rightDay = false;
                    } else {
                        rightDay = true;
                    }
            
            break;

    }

     return rightDay;

    }



    String getSeason(){

        String season = "";

        switch (this.month){
            
            case 3: 
                if(this.day>=21){
                    season = "Primavera";
                } else{
                    season = "Invierno";
                }
            break;

            case 4: //next
            case 5: season = "Primavera"; break;
            case 6:
                if(this.day<=20){
                    season = "Primavera";
                } else {
                    season = "Verano";
                }
            break;

            case 7: //next
            case 8: season = "Verano"; break;
            case 9:
                if(this.day<=20){
                    season = "Verano";
                } else {
                    season = "Otonyo";
                }
            break;

            case 10: //next
            case 11: season = "Otonyo"; break;
            case 12:
                if(this.day<=20){
                    season = "Otonyo";
                } else {
                    season = "Invierno";
                }
            break;

            case 1: //next
            case 2: season = "Invierno";
        }

        return season;
    }
}