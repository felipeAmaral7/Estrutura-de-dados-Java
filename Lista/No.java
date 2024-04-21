package Secao10.ComportamentoDeMemoria.Aula.Listas.ListaEncadeada;

public class No <T>{
    private T elemento;             //elemento que sera passado como parametro
    private No<T> proximo;          //proximo No que ira apontar (inicilizamos com null)
    private No<T> anterior;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public No(T elemento, No<T> proximo, No<T> anterior) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }

}
