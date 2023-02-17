import java.time.LocalDateTime
import java.util.*

class Deck(
    var name: String,
    var id: String = UUID.randomUUID().toString()
){
    fun addCard(){
        println("Añadiendo tarjeta al mazo $name")
        var tipo: Int?
        do{print("Teclea el tipo (0 -> Card 1 -> Cloze): ")
        tipo = readln().toIntOrNull() ?: 0}while((tipo == null) || (tipo !in (0..1)))
        print("  Teclea la pregunta: ")
        var quest = readln()
        print("  Teclea la respuesta: ")
        var awns = readln()
        lateinit var card : Card
        //creamos y añadimos la tarjeta
        when(tipo){
            1 -> {
                //compruebo que la pregunta tenga el espacio para colocar la respuesta
                if(quest.count{it =='*'}==2){
                    card = Cloze(question=quest, answer=awns)
                    card.id_deck=this.id

                }else{
                    println("Sorry malformed question")
                    return
                }
            }
            else -> {
                card = (Card(question=quest, answer=awns))
                card.id_deck=this.id
            }
        }
        //con la tarjeta añadida, la añadimos al colection
        Data.cards.add(card)

        println("Tarjeta añadida correctamente")
    }

    fun listCards(){
        Data.cards.filter {card ->  card.id_deck==this.id}.forEach {
           println(it.question + " -> " + it.answer)
        }
    }

    fun simulate(period: Int) {
        /*println("Simulación del mazo $name:")
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
        }*/
    }
}