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
        this.year = 2017;
    }

    //Constructor de la fecha con argumentos
    Date (int day, int month, int year) throws DateException{ //Propagamos la excepcion
    	
    	//Date copyDate = new Date(day,month,year); //Llamada al constructor al que se le pasa como parametro un objeto, para que lo asigne directamente y poder hacer la primera comprobacion
        //System.out.println(copyDate.toString());
    	if (this.isRightDay(day,month)==false) {
        	throw new DateException("Date error: Day " + day + " , month " + this.month);
        }else {
    	
    	//this.year = year;
        this.setYear(year);
        //this.month = month;
        this.setMonth(month); 
        //this.day = day;
        this.setDay(day); // se pone asi para llamar a las comprobaciones y que las fechas sean validas
        }
    }
    
    //Contructor que recibe como parametro otro objeto fecha
    Date (Date date) {
    	this.day = date.day;
    	this.month = date.month;
    	this.year = date.year;
    }

    //SETERS

    void setDay(int day) throws DateException{ //Comprobacion de que es un dia valido
    	
        if ( this.isRightDay(day, this.month)==false)  {
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
    void setYear(int year) throws DateException {
    	if(year<=0) {
    		throw new DateException("Date error: Not valid year "+year);
    	} else {
        this.year = year;
    	}
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
    String getMonthName(){

        String name = "";

        switch (this.month){
            case 1: name = "January"; break;
            case 2: name = "February"; break;                
            case 3: name = "March"; break;
            case 4: name = "April"; break;
            case 5: name = "May"; break;
            case 6: name = "June"; break;
            case 7: name = "July"; break;
            case 8: name = "August"; break;
            case 9: name = "September"; break;
            case 10: name = "October"; break;
            case 11: name = "November"; break;
            case 12: name = "December"; break;
            
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
    private boolean isRightDay(int day, int month){

        boolean rightDay = false;
        	
        if (day<1){
        	rightDay = false;
        } else {
	        switch (month){
	
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
	                    if (day>=1 && day<=this.daysOfMonth()){ 
	                         rightDay = true;
	                    } 
			          
	            break;
	            default: rightDay=false;

	        }
        }
     return rightDay;

    }
    //Devuleve la estacion a la que pertenece la fecha ajustada a los dias
    String getSeasonName(){

        String season = "";

        switch (this.month){
            
            case 3: 
                if(this.day>=21){
                    season = "Spring";
                } else{
                    season = "Winter";
                }
            break;

            case 4: //next
            case 5: season = "Spring"; break;
            case 6:
                if(this.day<=20){
                    season = "Spring";
                } else {
                    season = "Summer";
                }
            break;

            case 7: //next
            case 8: season = "Summer"; break;
            case 9:
                if(this.day<=20){
                    season = "Summer";
                } else {
                    season = "Autumn";
                }
            break;

            case 10: //next
            case 11: season = "Autumn"; break;
            case 12:
                if(this.day<=20){
                    season = "Autumn";
                } else {
                    season = "Winter";
                }
            break;

            case 1: //next
            case 2: season = "Winter";
        }

        return season;
    }

    //FOR
    //Cadena de los meses hasta final de anyo
    String getMonthsLeft (){
        int monthTemp;
        StringBuilder names;
        names = new StringBuilder();

        monthTemp = this.month; //Creo el temporal sino al modificar directamente this.month(para la llamada al metodo getNameMonth) el mes se cambiaria a 12 para siempre

        for (int i = this.month+1; i<=12 ; i++){
            //incluir el nombre del mes en names
            this.month = i;
            names.append(this.getMonthName() + " ");
        }
        this.month = monthTemp; //Devolvemos el valor original del mes 

        return names.toString();
    }
    //Devuleve una cadena de todos los dias que faltan hasta final de mes
    String getDaysLeftOfMonth () throws DateException{
        StringBuilder daysLeft;
        Date copyDate = new Date(this.day,this.month,this.year);
        daysLeft = new StringBuilder();
        
        switch(this.month){
            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                    for (int i = this.day+1 ; i<=31 ; i++){
                        copyDate.setDay(i);
                        daysLeft.append(copyDate.toString()+" ");
                    }
            break;

            case 4: //next
            case 6: //next
            case 9: //next
            case 11:
                    for (int i = this.day+1 ; i<=30 ; i++){
                        copyDate.setDay(i);
                        daysLeft.append(copyDate.toString()+" ");
                    }
            break;

            case 2: 
                if (this.isBisiesto()==true){
                    for (int i = this.day+1 ; i<=29 ; i++){
                        copyDate.setDay(i);
                        daysLeft.append(copyDate.toString()+" ");
                    }
		        } else {
                    for (int i = this.day+1 ; i<=28 ; i++){
                        copyDate.setDay(i);
                        daysLeft.append(copyDate.toString()+" ");
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
    public int daysOfMonth(){
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
    String getMonthsSameDays () throws DateException{
        StringBuilder names = new StringBuilder();
        Date aux = new Date (this.day,this.month,this.year);
        for (int i=1;i<=12;i++){
            aux.setMonth(i);
            if(aux.daysOfMonth()==this.daysOfMonth()){
                names.append(aux.getMonthName()+" ");
            }       
       
        }

         return names.toString();
    }
    
    //Dias hasta el 1 de enero de ese anyo
    int daysPast() throws DateException{
        int days=0;
        Date aux = new Date(this.day,this.month,this.year);
        for (int i=aux.month; i>=1 ; i--){
            //Para sumar los dias de ese mes en la primera vuelta
            if (aux.month==i){
                days = days + aux.day -1;
            } else {
                aux.setMonth(i);
                days = days + aux.daysOfMonth();
            }
        }
        return days;
    }

    //Intentos fecha aleatoria para acertar la fecha introducida (en ese anyo)
    int numRandomTriesEqualDate(){
        int randomMonth=1, randomDay=1, intentos=1;
        
        //Date randomDate;
		//try { //Quitamos la creacion de objeto sino entra en conflicto con la fecha copia
			randomMonth =(int)(Math.random()*12+1);
	        randomDay = (int)(Math.random()*28+1);
			//randomDate = new Date(randomDay,randomMonth,this.year);
			while(randomMonth!=this.month || randomDay!=this.day){
            randomMonth =(int)(Math.random()*12+1);
            //randomDate.setMonth(randomMonth);
            randomDay = (int)(Math.random()*31+1);
            //randomDate.setDay(randomDay);
            intentos++;
        //}
		//} catch (DateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

        //Generamos un mes aleatorio valido y un dia para ese mes
        
            
        return intentos;
    }
    //DEvuleve el nombre del dia de la semana recibiendo como parametro el dia de la semana del 01/01 de ese anyo
    //1-Lunes,2-Martes,3-Miercoles,4-Jueves,5-Viernes,6-Sabado,7-Domingo
String dayOfWeek(int primerDia)throws DateException{
        
        String diaSemana="";
        int totalDays;
        

        totalDays=this.daysPast();

        switch(primerDia){
            case 1:
            switch(totalDays%7){
                case 0: diaSemana = "Monday"; break;
                case 1: diaSemana = "Tuesday"; break;
                case 2: diaSemana = "Wednesday"; break;
                case 3: diaSemana = "Thursday"; break;
                case 4: diaSemana = "Friday"; break;
                case 5: diaSemana = "Saturday"; break;
                case 6: diaSemana = "Sunday"; break;
            }
            break;
            case 2:
            switch(totalDays%7){
                case 0: diaSemana = "Tuesday"; break;
                case 1: diaSemana = "Wednesday"; break;
                case 2: diaSemana = "Thursday"; break;
                case 3: diaSemana = "Friday"; break;
                case 4: diaSemana = "Saturday"; break;
                case 5: diaSemana = "Sunday"; break;
                case 6: diaSemana = "Monday"; break;
            }
            break;
            case 3:
            switch(totalDays%7){
                case 0: diaSemana = "Wednesday"; break;
                case 1: diaSemana = "Thursday"; break;
                case 2: diaSemana = "Friday"; break;
                case 3: diaSemana = "Saturday"; break;
                case 4: diaSemana = "Sunday"; break;
                case 5: diaSemana = "Monday"; break;
                case 6: diaSemana = "Tuesday"; break;
            }
            break;
            case 4:
            switch(totalDays%7){
                case 0: diaSemana = "Thursday"; break;
                case 1: diaSemana = "Friday"; break;
                case 2: diaSemana = "Saturday"; break;
                case 3: diaSemana = "Sunday"; break;
                case 4: diaSemana = "Monday"; break;
                case 5: diaSemana = "Tuesday"; break;
                case 6: diaSemana = "Wednesday"; break;
            }
            break;
            case 5:
            switch(totalDays%7){
                case 0: diaSemana = "Friday"; break;
                case 1: diaSemana = "Saturday"; break;
                case 2: diaSemana = "Sunday"; break;
                case 3: diaSemana = "Monday"; break;
                case 4: diaSemana = "Tuesday"; break;
                case 5: diaSemana = "Wednesday"; break;
                case 6: diaSemana = "Thursday"; break;
            }
            break;
            case 6:
            switch(totalDays%7){
                case 0: diaSemana = "Saturday"; break;
                case 1: diaSemana = "Sunday"; break;
                case 2: diaSemana = "Monday"; break;
                case 3: diaSemana = "Tuesday"; break;
                case 4: diaSemana = "Wednesday"; break;
                case 5: diaSemana = "Thursday"; break;
                case 6: diaSemana = "Friday"; break;
            }
            break;
            case 7:
            switch(totalDays%7){
                case 0: diaSemana = "Sunday"; break;
                case 1: diaSemana = "Monday"; break;
                case 2: diaSemana = "Tuesday"; break;
                case 3: diaSemana = "Wednesday"; break;
                case 4: diaSemana = "Thursday"; break;
                case 5: diaSemana = "Friday"; break;
                case 6: diaSemana = "Saturday"; break;
            }
            break;
        }

        return diaSemana;
    }

	public Date tomorrow() {
		Date tomorrowDate = null;
		
		try {
			if (this.day==this.daysOfMonth() && this.month==12) {
				tomorrowDate = new Date(01,01,this.year+1);
			} else  if(this.day==daysOfMonth() && this.month!=12){
				tomorrowDate = new Date(01,this.month+1,this.year);
			} else {
			tomorrowDate = new Date(this.day+1,this.month,this.year);
			}
		} catch (DateException e) {		
			System.out.println(e.getMessage());
		}
		return tomorrowDate;
	}

}