//Meses que quedan hasta final de año

//Añadimos en el main System.out.println(today.gatNamesMonthLeft();)

String getNamesMonthLeft (){
    StringBuilder names;
    names = new StringBuilder();

    for (int i = this.month; i<=12 ; i++){
        //incluir el nombre del mes en names
        names.append(this.getNameMonth() + " ");
    }

    return names.toString();
}