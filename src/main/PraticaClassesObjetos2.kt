package main

// 1. Crie uma classe base chamada Funcionario com as seguintes propriedades:
// - Nome (string): o nome do funcionário.
// - Idade (int): a idade do funcionário.
open class Funcionario(val nome: String, val idade: Int) {
    init {
        println("Novo funcionário registrado: Nome: $nome, Idade: $idade")
    }

    // 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
    // incluindo o nome e a idade.
    open fun apresentar() {
        println("Funcionário: Nome: $nome, Idade: $idade")
    }
}

// 2. Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
// - Setor (string): o setor em que o gerente trabalha.
class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade) {
    // Sobrescrevendo o método apresentar para incluir o setor do gerente.
    override fun apresentar() {
        println("Gerente: Nome: $nome, Idade: $idade, Setor: $setor")
    }
}

// 3. Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
// - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade) {
    // Sobrescrevendo o método apresentar para incluir a linguagem de programação do desenvolvedor.
    override fun apresentar() {
        println("Desenvolvedor: Nome: $nome, Idade: $idade, Linguagem: $linguagem")
    }
}

// 4. Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
// - Area (string): a área de especialização do analista.
class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade) {
    // Sobrescrevendo o método apresentar para incluir a área de especialização do analista.
    override fun apresentar() {
        println("Analista: Nome: $nome, Idade: $idade, Área: $area")
    }
}

fun main() {
    // 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
    // à lista.
    val listaFuncionarios = mutableListOf<Funcionario>()
    listaFuncionarios.add(Gerente("João", 40, "TI"))
    listaFuncionarios.add(Desenvolvedor("Maria", 30, "Kotlin"))
    listaFuncionarios.add(Analista("Carlos", 35, "Financeiro"))

    // 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
    // correspondente.
    for (funcionario in listaFuncionarios) {
        // Verifica o tipo de funcionário e chama o método Apresentar correspondente.
        when (funcionario) {
            is Gerente -> funcionario.apresentar()
            is Desenvolvedor -> funcionario.apresentar()
            is Analista -> funcionario.apresentar()
            else -> funcionario.apresentar() // Se não for nenhum dos tipos específicos, chama o método Apresentar da classe Funcionario.
        }
    }
}
