class Cloze(question: String,
            answer: String) : Card(question, answer){
                val fPart = question.subSequence(0, question.indexOf("*"))
                val sPart = question.subSequence(question.indexOf("*"), question.lastIndexOf("*"))
                override fun show(){
                    print("$question (INTRO para ver respuesta)")
                    readln()
                    print("${this.fPart}${answer}${this.sPart} (Teclea 0 -> Difícil 3 -> Dudo 5 -> Fácil): ")
                    quality = readln().toIntOrNull() ?: 0
                }
    override fun toString() :String{
        return "cloze" + super.toString().substring("card".length)
    }

}