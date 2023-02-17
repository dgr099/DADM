class Deck(
    var name: String,
    var id: String = UUID.randomUUID().toString()
){
    var cards = mutableListOf<Card>()
    fun addCard(){
        println("Añadiendo tarjeta al mazo $name")
        print("  Teclea la pregunta: ")
        var pregunta = readln()
        print("  Teclea la respuesta: ")
        var respuesta = readln()
        //creamos y añadimos la tarjeta 
        this.cards.add(Card(question="To wake up", answer="Despertarse"))
        println("Tarjeta añadida correctamente")
    }

    fun listCards(){
        for(card in cards){
            println(card.question + " -> " + card.answer)
        }
    }

    fun simulate(period: Int) {
        println("Simulación del mazo $name:")
        var now = LocalDateTime.now()
        for(day in 0.rangeTo(period)){
            println("Fecha: ${now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}")
            for(card in cards){
                if(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(card.nextPracticeDate.format((DateTimeFormatter.ofPattern("yyyy-MM-dd"))))){
                    card.show()
                    card.update(now)
                    card.details()
                }
            }
            now = now.plusDays(1)
        }
    }
}