package main


class Livro(var titulo: String, var preco: Double) {
    override fun toString(): String {
        return "Livro: Título = $titulo, Preço = $preco"
    }
}

fun menu() {
    println("1 - Cadastrar livro")
    println("2 - Excluir livro")
    println("3 - Buscar livro")
    println("4 - Editar livro")
    println("5 - Listar livros")
    println("6 - Listar livros que começam com letra escolhida")
    println("7 - Listar livros com preço abaixo do informado")
    println("8 - Sair")
}

fun inputTitulo(): String {
    print("Digite o título do livro: ")
    return readLine() ?: ""
}

fun inputPreco(): Double {
    var preco: Double
    while (true) {
        print("Digite o preço do livro: ")
        try {
            preco = readLine()!!.toDouble()
            if (preco < 0) {
                println("O preço não pode ser negativo!")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            println("Por favor, insira um número válido para o preço.")
        }
    }
    return preco
}

fun cadastrarLivro(repositorio: MutableList<Livro>) {
    val titulo = inputTitulo()
    val preco = inputPreco()

    repositorio.add(Livro(titulo, preco))
    println("\nCadastrado com sucesso!\n")
}

fun excluirLivro(repositorio: MutableList<Livro>) {
    val livro = buscarNome(repositorio)
    if (livro != null) {
        repositorio.remove(livro)
        println("Livro removido com sucesso!")
    } else {
        println("Livro não encontrado.")
    }
}

fun buscarNome(repositorio: MutableList<Livro>): Livro? {
    val titulo = inputTitulo()
    return repositorio.find { it.titulo == titulo }
}

fun editarLivro(repositorio: MutableList<Livro>) {
    var livro = buscarNome(repositorio)
    if (livro != null) {
        println("O que você gostaria de editar?")
        println("1 - Título")
        println("2 - Preço")
        print("Digite a opção: ")
        when (readLine()?.toInt() ?: 0) {
            1 -> {
                println("Digite o novo título: ")
                val novoTitulo = readLine() ?: ""
                livro.titulo = novoTitulo
            }
            2 -> {
                val novoPreco = inputPreco()
                livro.preco = novoPreco
            }
            else -> println("Opção inválida.")
        }
    } else {
        println("Livro não encontrado.")
    }
}

fun listar(repositorio: MutableList<Livro>) {
    println("Livros cadastrados:")
    for (livro in repositorio) {
        println(livro)
    }
}

fun listarComLetraInicial(repositorio: MutableList<Livro>) {
    print("Informe a letra: ")
    val letra = readLine()?.firstOrNull() ?: return

    val livros = repositorio.filter { it.titulo.startsWith(letra, ignoreCase = true) }
    if (livros.isNotEmpty()) {
        println("Livros que começam com '$letra':")
        livros.forEach { println(it) }
    } else {
        println("Não há livros que comecem com a letra '$letra'.")
    }
}

fun listarComPrecoAbaixo(repositorio: MutableList<Livro>) {
    val preco = inputPreco()
    val livros = repositorio.filter { it.preco < preco }
    if (livros.isNotEmpty()) {
        println("Livros com preço abaixo de $preco:")
        livros.forEach { println(it) }
    } else {
        println("Não há livros com preço abaixo de $preco.")
    }
}

fun main() {
    val repositorioLivros = mutableListOf<Livro>()
    repositorioLivros.add(Livro("Livro dos Livros", 999999.99))
    repositorioLivros.add(Livro("Turma da Monica", 4.99))
    repositorioLivros.add(Livro("Kotlin for Dummies", 29.99))
    repositorioLivros.add(Livro("A", 59.99))

    var opcao = 0
    while (opcao != 8) {
        menu()
        print("Digite a opção: ")
        opcao = readLine()?.toInt() ?: 8

        when (opcao) {
            1 -> cadastrarLivro(repositorioLivros)
            2 -> excluirLivro(repositorioLivros)
            3 -> {
                val livro = buscarNome(repositorioLivros)
                if (livro != null) {
                    println(livro)
                } else {
                    println("Livro não encontrado.")
                }
            }
            4 -> editarLivro(repositorioLivros)
            5 -> listar(repositorioLivros)
            6 -> listarComLetraInicial(repositorioLivros)
            7 -> listarComPrecoAbaixo(repositorioLivros)
            8 -> println("Até a próxima :)")
            else -> println("Opção inválida.")
        }
        Thread.sleep(3000)
    }
}
