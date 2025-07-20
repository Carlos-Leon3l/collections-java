package Exercicios_Set.Ordenacao;

public class Contato {
    
    String nome;
    int numero;
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + numero;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numero != other.numero)
            return false;
        return true;
    }
    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }
    @Override
    public String toString() {
        return "AgendaContatos {nome: " + nome + ", numero: " + numero + "}";
    }

    
}