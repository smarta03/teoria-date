class Date {
   private int day; //Atributos 
   private int month;
   private int year;

    //Corregir constructor ya que genera fechas no validas porque no hay una validacion (como en la clase buena es)
    //Para que sea correcto hay que llamar a los setDay, setMonth y setYear
    Date (int day, int month, int year){

        //this.day = day;
        //this.month = month;
        //this.year = year;

        this.setMonth (month);
        this.setDay (day);
        this.setYear (year);
    }

    //faltan excepciones (30 de febrero por ejemplo)
    Date(int year){ //Contructor por defecto cuando no recibe parametros por lo que generamos una fehca eleatoria
        this.setMonth(Math.random()); //se verifica el numero aleatorio generado en intervalo 0-1 por loque hay que hacer ajuste para que de hasta 12
        this.setDay(Math.random());
        this.setYear(year);
    }

    void setDay(int day){

    }

    void setMonth(int month){
        
    }

    void setYear(int year){
        this.year = year; //Porque no hay ninguna restriccion
    }

    boolean equals (Date anotherDate){
        boolean equals;
        equals = (this.day == anotherDay.getDay()) && (this.month == anotherDay.getMonth()) && (this.year == anotherDay.getYear());
        return equals;
    }


//SOLO CON WHILE
    int numRandomDateAttempts(){ //Metodo que cuenta los intentos, no recibe parametros ya que se invoca el metodo sobre el objeto
        int counter = 1; //por si la primera fecha generada es correcta
        Date randomDate;

        randomDate = new Date(this.year);// Se genera tambien esta fecha aleatoria para poder entrar en el bucle

        //Mientras que las fehcas sean distintas
        while (this.equals(randomDate())){ //montamos el metodo equals para comparar las fehcas 
            //genero una nueva fecha aleatoriamente
            randomDate = new Date(this.year); //genera una fecha aleatoria en el mismo anyo
            //incrementar el contador
            counter++;

        }


        return counter;
    } 


}