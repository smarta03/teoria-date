/* Teoria Clase Date,
Sergio Martinez Aguero 71529484-J
smarta03@estudiantes.unileon.es PRG1 Universidad de Leon
*/

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

    //Constructor de la fecha con argumentos
    Date (int day, int month, int year) throws DateException{ //Propagamos la excepcion
        //this.year = year;
        this.setYear(year);
        //this.month = month;
        this.setMonth(month); 
        //this.day = day;
        this.setDay(day); // se pone asi para llamar a las comprobaciones y que las fechas sean validas
        
    }

    //SETERS

    void setDay(int day) throws DateException{ //Comprobacion de que es un dia valido
    
        if ( this.isRightDay(day)==false ) {
			throw new DateException("Date error: Day " + day + " , month " + this.month + " of year " + this.year +": not valid");			
		} else {
		this.day = day;
        } 

    }
    //Comprobacion de que es un mes valido, este metodo lanza excepciones
    void setMonth(int month) throws DateException { 
        if(month>12 || month<1){   //La excepcion DateException la hemos creado nosotros en la clase DateException.java
            throw new DateException("Date error: Not valid month " + month);  //Excepciones (son objetos) el mensaje de error    
        }else{
            this.month = month;
        }   
    }
    //Comprobacion de que es un anyo valido
    void setYear(int year){
        this.year = year;
    }

    //GETERS
    //Devuelve dia
    int getDay() {

        return this.day;

    }
    //Devuleve mes
    int getMonth(){
        
        return this.month;

    }
    //Devulve anyo
    int getYear(){
        return this.year;
    }

    //IF
    //Dos dias de dos objetos fecha son iguales
    boolean isSameDay (Date anotherDate){

        return this.day == anotherDate.getDay();

    }
    //Dos meses de dos objetos fecha son iguales
    boolean isSameMonth(Date anotherDate){

        return this.month == anotherDate.getMonth();
    
    }
    //Dos anyos de dos objetos fecha son iguales
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
    //Dos objetos fecha son iguales
    boolean isSame(Date anotherDate){
        boolean isSame;
        if((this.isSameDay(anotherDate)) && (this.isSameMonth(anotherDate)) && (this.isSameYear(anotherDate))){ //Para no repetir el mismo codigo que el primer if llamamos directamente al metodo
            isSame = true;
        } else {
            isSame = false;
        }

        return isSame;
    }
    //Imprime la fehca en formato String
    public String toString(){
       return this.day + "/" + this.month + "/" + this.year;
    }


    //SWITCH
    //Devuelve el nomre del mes
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
    //True = es una anyo bisiesto
    private boolean isBisiesto(){
        boolean isBisiesto=false;

        if ((this.year%400 == 0) || (this.year%4 == 0 && this.year%100!=0)){
            isBisiesto = true;
        }

        return isBisiesto;
    }

    //Comprobacion de que es un dia correcto dentro del mes y anyo seleccionado
    private boolean isRightDay(int day){

        boolean rightDay = false;

        switch (this.month){

            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    if (day>=1 && day <=31){
                        rightDay = true;
                    } 
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    if (day>=1 && day <=30){
                        rightDay = true;
                    }
            break;

            case 2: 
                    if (day>=1 && day<=this.getDaysOfMonth()){ 
                         rightDay = true;
                    } 
		          
            break;
            default: rightDay=false;

    }
     return rightDay;

    }
    //Devuleve la estacion a la que pertenece la fecha ajustada a los dias
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
    //Cadena de los meses hasta final de anyo
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
    //Devuleve una cadena de todos los dias que faltan hasta final de mes
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
                if (this.isBisiesto()==true){
                    for (int i = this.day ; i<=29 ; i++){
                        daysLeft.append(i+" ");
                    }
		        } else {
                    for (int i = this.day ; i<=28 ; i++){
                        daysLeft.append(i+" ");
                    }
		        }
                //    for (int i = this.day ; i<=28 ; i++){
                //         daysLeft.append(i+" ");
                //     }
            break;

        }

        return daysLeft.toString();
    }
    //Devuleve los dias del mes al que pertene la fecha
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
                 //days = 28;
                if (this.isBisiesto()==true){
                    days = 29;
		        } else {
                    days = 28;
		        }
                 
            break;
            
        }
         return days;
    }
    //Devuleve una cadena con todos los meses que tienen los mismos dias que el mes de la fecha
    String getNamesMonthSameDays () throws DateException{
        StringBuilder names = new StringBuilder();
        Date aux = new Date (this.day,this.month,this.year);
        for (int i=1;i<=12;i++){
            aux.setMonth(i);
            if(aux.getDaysOfMonth()==this.getDaysOfMonth() && aux.getMonth()!=this.getMonth()){
                names.append(aux.getNameMonth()+" ");
            }       
       
        }

         return names.toString();
    }
    
    //Dias hasta el 1 de enero de ese anyo
    int getTotalDaysSinceFirst() throws DateException{
        int days=0;
        Date aux = new Date(this.day,this.month,this.year);
        for (int i=aux.month; i>=1 ; i--){
            //Para sumar los dias de ese mes en la primera vuelta
            if (aux.month==i){
                days = days + aux.day;
            } else {
                aux.setMonth(i);
                days = days + aux.getDaysOfMonth();
            }
        }
        return days;
    }

    //Intentos fecha aleatoria para acertar la fecha introducida (en ese anyo)
    int attemptsRandomDate()throws DateException{
        int randomMonth=1, randomDay=1, intentos=1;
        randomMonth =(int)(Math.random()*12+1);
        randomDay = (int)(Math.random()*28+1);
        Date randomDate = new Date(randomDay,randomMonth,this.year);

        //Generamos un mes aleatorio valido y un dia para ese mes
        while(randomMonth!=this.month || randomDay!=this.day){
            randomMonth =(int)(Math.random()*12+1);
            randomDate.setMonth(randomMonth);
            randomDay = (int)(Math.random()*randomDate.getDaysOfMonth()+1);
            randomDate.setDay(randomDay);
            intentos++;
        }
        
        return intentos;
    }
    //DEvuleve el nombre del dia de la semana recibiendo como parametro el dia de la semana del 01/01 de ese anyo
    //1-Lunes,2-Martes,3-Miercoles,4-Jueves,5-Viernes,6-Sabado,7-Domingo
    String getNameWeekday(int primerDia)throws DateException{
        
        String diaSemana="";
        int totalDays;

        totalDays=this.getTotalDaysSinceFirst();

        switch(primerDia){
            case 2:
            switch(totalDays%7){
                case 0: diaSemana = "Lunes"; break;
                case 1: diaSemana = "Martes"; break;
                case 2: diaSemana = "Miercoles"; break;
                case 3: diaSemana = "Jueves"; break;
                case 4: diaSemana = "Viernes"; break;
                case 5: diaSemana = "Sabado"; break;
                case 6: diaSemana = "Domingo"; break;
            }
            break;
            case 3:
            switch(totalDays%7){
                case 0: diaSemana = "Martes"; break;
                case 1: diaSemana = "Miercoles"; break;
                case 2: diaSemana = "Jueves"; break;
                case 3: diaSemana = "Viernes"; break;
                case 4: diaSemana = "Sabado"; break;
                case 5: diaSemana = "Domingo"; break;
                case 6: diaSemana = "Lunes"; break;
            }
            break;
            case 4:
            switch(totalDays%7){
                case 0: diaSemana = "Miercoles"; break;
                case 1: diaSemana = "Jueves"; break;
                case 2: diaSemana = "Viernes"; break;
                case 3: diaSemana = "Sabado"; break;
                case 4: diaSemana = "Domingo"; break;
                case 5: diaSemana = "Lunes"; break;
                case 6: diaSemana = "Martes"; break;
            }
            break;
            case 5:
            switch(totalDays%7){
                case 0: diaSemana = "Jueves"; break;
                case 1: diaSemana = "Viernes"; break;
                case 2: diaSemana = "Sabado"; break;
                case 3: diaSemana = "Domingo"; break;
                case 4: diaSemana = "Lunes"; break;
                case 5: diaSemana = "Martes"; break;
                case 6: diaSemana = "Miercoles"; break;
            }
            break;
            case 6:
            switch(totalDays%7){
                case 0: diaSemana = "Viernes"; break;
                case 1: diaSemana = "Sabado"; break;
                case 2: diaSemana = "Domingo"; break;
                case 3: diaSemana = "Lunes"; break;
                case 4: diaSemana = "Martes"; break;
                case 5: diaSemana = "Miercoles"; break;
                case 6: diaSemana = "Jueves"; break;
            }
            break;
            case 7:
            switch(totalDays%7){
                case 0: diaSemana = "Sabado"; break;
                case 1: diaSemana = "Domingo"; break;
                case 2: diaSemana = "Lunes"; break;
                case 3: diaSemana = "Martes"; break;
                case 4: diaSemana = "Miercoles"; break;
                case 5: diaSemana = "Juerves"; break;
                case 6: diaSemana = "Viernes"; break;
            }
            break;
            case 1:
            switch(totalDays%7){
                case 0: diaSemana = "Domingo"; break;
                case 1: diaSemana = "Lunes"; break;
                case 2: diaSemana = "Martes"; break;
                case 3: diaSemana = "Miercoles"; break;
                case 4: diaSemana = "Jueves"; break;
                case 5: diaSemana = "Viernes"; break;
                case 6: diaSemana = "Sabado"; break;
            }
            break;
        }

        return diaSemana;
    }

}