object Data{
    var decks = mutableListOf<Deck>()
    var cards = mutableListOf<Card>()

}

fun main(){
    var opt : Int?
    Data.decks.add(Deck(name = "Ingles"))
    do {
        do {
            print(
                """    1. Añadir tarjeta
    2. Lista de tarjetas
    3. Simulación
    4. Salir
    Elige una opción: """
            )
            opt = readln().toIntOrNull() ?: 0
        } while (opt == null || !(opt in 1..4))
        when(opt){
            1-> {
                Data.decks.first().addCard()
            }
            2 -> {
                Data.decks.first().listCards()
            }
            else -> {
                opt = 4
            }
        }
    }while(opt!=4)

}
