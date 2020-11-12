package es.unileon.prg1.date;

//La clase publica
public class Date{

    //Declaracion de variables,los atributos de dentro siempre privados.
    private int day;
    private int month;
    private int year;
    
    //Contructor por defecto sin argumentos
    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    //Constructor de la fecha
    Date (int day, int month, int year) throws DateException{ //Propagamos la excepcion
        //this.month = month;
        this.setMonth(month); 
        //this.day = day;
        this.setDay(day); // se pone asi para llamar a las comprobaciones
        //this.year = year;
        this.setYear(year);

    }

    //SETERS

    void setDay(int day){ //Comprobacion de que es un dia valido
     
        int now = this.day;
        this.day = day;
        if (!this.isRightDay()){
            this.day = now;
            //throw new DateException("Dater error: Day "+day);
        }   

    }

    void setMonth(int month) throws DateException { //Comprobacion de que es un mes valido, este metodo lanza excepciones
        if(month>12 || month<1){   //La excepcion DateException la hemos creado nosotros en la clase DateException.java
            throw new DateException("Date error: Not valid month " + month);  //Excepciones (son objetos) el mensaje de error    
        }else{
            this.month = month;
        }   
    }

    void setYear(int year){
        this.year = year;
    }

    //GETERS

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

    public String toString(){
       return this.day + "/" + this.month + "/" + this.year;
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

    private boolean isRightDay(){

        boolean rightDay = false;
        
        switch (this.month){

            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    if (this.day>=1 || this.day <=31){
                        rightDay = true;
                    } 
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    if (this.day>=1 || this.day <=30){
                        rightDay = true;
                    }
            break;

            case 2: 
                    if (this.day>=1 || this.day<=28){  //Sin considerar bisiestos
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

    //FOR
    String getNamesMonthLeft (){
        int monthTemp;
        StringBuilder names;
        names = new StringBuilder();

        monthTemp = this.month; //Creo el temporal sino al modificar directamente this.month(para la llamada al metodo getNameMonth) el mes se cambiaria a 12 para siempre

        for (int i = this.month; i<=12 ; i++){
            //incluir el nombre del mes en names
            this.month = i;
            names.append(this.getNameMonth() + " ");
        }
        this.month = monthTemp; //Devolvemos el valor original del mes 

        return names.toString();
    }

    String getDaysMonthLeft (){
        StringBuilder daysLeft;
        daysLeft = new StringBuilder();

        daysLeft.append("Dias hasta final de mes -->");
        
        switch(this.month){
            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    for (int i = this.day ; i<=31 ; i++){
                        daysLeft.append(i+" ");
                    }
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    for (int i = this.day ; i<=30 ; i++){
                        daysLeft.append(i+" ");
                    }
            break;

            case 2: 
                   for (int i = this.day ; i<=28 ; i++){
                        daysLeft.append(i+" ");
                    }
            break;

        }

        return daysLeft.toString();
    }

    //String getNamesMonthSameDays (){
        //StringBuilder names;
        //names = new StringBuilder();

        //SIN HACER
        //return names.toString;
    //}

    //Dias del mes
    private int getDaysOfMonth(){
        int days=0;

        switch (this.month){
            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                days = 31;
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                days = 30;
            break;

            case 2: 
                 days = 28;
            break;
            
        }
         return days;
    }
    //Dias hasta el 1 de enero
    int getTotalDaysSinceFirst(){
        int days=0;
        for (int i=this.month; i>=1 ; i--){
            //Para sumar los dias de ese mes en la primera vuelta
            if (this.month==i){
                days = days + this.day;
            } else {
                //this.month =this.month-1;//Bajamos un mes porque es el que debemos sumar
                days = days + this.getDaysOfMonth();
                //this.month =this.month+1;//Lo actualizamos para que no cambie su valor
            }
        }
        return days;
    }

}