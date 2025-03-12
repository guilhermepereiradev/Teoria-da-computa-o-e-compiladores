package src.com.oxd.cmplr;

public class Token {
    String tipo;
    String conteudo;

    public Token(String tipo, String conteudo) {
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return tipo + ": "+conteudo;
    }
}
