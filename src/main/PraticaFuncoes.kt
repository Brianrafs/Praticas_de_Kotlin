package main


val materiasENotas = mutableMapOf<String, MutableList<Double>>()

fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

fun adicionarVariasNotas(materia:String, vararg nota:Double){
    val notasDaMateria = materiasENotas[materia]

    if (notasDaMateria != null) {
        for (n in nota) {
            notasDaMateria.add(n)
        }
    }
}

fun calcularMedia(notas: MutableList<Double>): Double {
    if (notas.isEmpty()) return 0.0
    var soma = 0.0
    for (nota in notas) {
        soma += nota
    }
    return soma / notas.size
}

fun mostrarNotas(materia:String){
    val notasDaMateria = materiasENotas[materia]

    if (notasDaMateria == null) {
        println("Matéria $materia não encontrada")
    } else {
        println("Matéria: $materia")
        if (notasDaMateria.isEmpty()) {
            println("Não há notas registradas para esta matéria")
        } else {
            var cont = 1
            for (nota in notasDaMateria) {
                println("Nota $cont: $nota")
                cont++
            }
            val media = calcularMedia(notasDaMateria)
            println("Média: $media")
        }
    }
    println()
}

fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("Matemática", mutableListOf(8.5, 7.0, 6.5))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia = "História", notas = mutableListOf(9.0, 7.5, 8.0))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    adicionarDisciplina("Português")

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Geografia")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 9.0)
    adicionarNota("História", 8.5)
    adicionarNota("Geografia", 7.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("História")
    mostrarNotas("Geografia")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Ciências")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    adicionarVariasNotas("Ciências", 6.0, 7.5, 8.0)

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Ciências", 6.0, 7.5, 8.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Ciências")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)
    // 11: calcularMedia -> Implemente a função calcularMedia()

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    println("Média de Matemática: ${calcularMedia(materiasENotas["Matemática"] ?: mutableListOf())}")
    println("Média de História: ${calcularMedia(materiasENotas["História"] ?: mutableListOf())}")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    // Já implementado na função mostrarNotas()

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("Português")
}
