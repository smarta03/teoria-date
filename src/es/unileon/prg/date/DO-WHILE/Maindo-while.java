class MainDate{
    public static void main (String args[]){
        Date today;

        today = new Date(4,11,2020);
        tomorrow = new Date (5,11,2020);
        today.equals(tomorrow);
        today.numRandomDateAttemps(); //Llamada al metodo para contar los intentos

    }
}