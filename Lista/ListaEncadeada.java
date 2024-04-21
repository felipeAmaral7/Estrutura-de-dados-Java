package Secao10.ComportamentoDeMemoria.Aula.Listas.ListaEncadeada;

public class ListaEncadeada <T>{
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    public int getTamanho(){
        return this.tamanho;
    }

    public void inserirInicio(T elemento){

        //cria o No com as informações do elemento
        No<T> novo = new No<>(elemento);

        //verifica se o inicio é nulo
        if(this.inicio == null){
            this.ultimo = novo;
        }
        //caso já exista nos
        else{
            novo.setProximo(this.inicio);           //faz o novo no apontar para o inicio atual
            novo.getProximo().setAnterior(novo);
        }

        System.out.println("Elemento " + elemento + " inserido com sucesso!");
        System.out.println();

        this.inicio = novo;                         //faz o atributo inicio apontar para o novo no
        this.tamanho++;                             //incrementa o tamanho da lista
    }

    public void inserirFim(T elemento){

        //cria um novo no com as informações do elemento
        No<T> novo = new No<T>(elemento);

        //verifica se já existe algum No
        if(this.inicio == null){
            this.inicio = novo;
        }
        //caso ja exista um No
        else{
            this.ultimo.setProximo(novo);           //faz o ultimo atual apontar para o novo No criado
            novo.setAnterior(this.ultimo);          //faz o novo No apontar para o ultimo atual
        }

        System.out.println("Elemento " + elemento + " inserido com sucesso!");
        System.out.println();

        this.ultimo = novo;                         //faz o atributo ultimo apontar para o novo No criado
        this.tamanho++;                             //incrementa o tamanho da lista
    }

    public void insereEmQualquerLugar(T elemento, int posicao){

        //verifica se a posição é valida
        if(posicao < 0 || posicao > this.tamanho){
            System.out.println("Posicao invalida!");
        }
        //insercao no inicio
        else if(posicao == 0){
            inserirInicio(elemento);
        }
        //insercao no final
        else if(posicao == this.getTamanho()){
            inserirFim(elemento);
        }
        else{
            No <T>anterior = buscarPorPosicao(posicao - 1);
            No <T>proximo = anterior.getProximo();
            No<T> novo = new No<>(elemento, proximo);

            proximo.setAnterior(novo);                  //anterior do proximo aponta para o novo
            anterior.setProximo(novo);                  //proximo do anterior aponta para o novo
            novo.setAnterior(anterior);                 //anterior do novo aponta para o anterior

            System.out.println("Elemento " + elemento + " foi adicionado!");
            tamanho++;
        }
    }

    public void imprimeLista(){

       No<T> aux = this.inicio;                       //precisa de um No auxiliar para não perder a referencia
        while(aux != null) {
            System.out.printf(aux.getElemento() + " ");
            aux = aux.getProximo();
        }
        System.out.println();
    }

    public void imprimeAoContrario(){

        No<T> aux = this.ultimo;
        while(aux != null) {
            System.out.printf(aux.getElemento() + " ");
            aux = aux.getAnterior();
        }
        System.out.println();
    }

    public void limparLista1(){
        No<T> aux = this.inicio;
        while(aux != null){
            No<T> temp = aux;
            temp.setElemento(null);
            temp.setProximo(null);
            aux = aux.getProximo();
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void limparLista2(){
        for(No<T> aux = this.inicio; aux != null;){
            No<T> temp = aux.getProximo();
            aux.setElemento(null);
            aux.setProximo(null);
            aux = temp;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    //busca por um elemento e verifica se ele existe na lista
    public boolean buscarElemento(T elemento){
        boolean achou = false;
        int posicao = 0;

        if(this.inicio != null) {
            No <T>aux = this.inicio;
            while (aux != null) {
                if (aux.getElemento().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado na posicao: " + posicao);
                    System.out.println();
                    achou = true;
                }
                posicao++;
                aux = aux.getProximo();
            }
        }
        return achou;
    }

    //busca um no em uma determinada posicao
    public No<T> buscarPorPosicao(int posicao){
        No<T> aux = null;

        if(posicao < 0 || posicao > this.getTamanho()){
            System.out.println("Posicao invalida!");
        }
        else{
            int posicaoAtual = 0;
            aux = this.inicio;
            while (posicaoAtual != posicao) {
                posicaoAtual++;
                aux = aux.getProximo();
            }
        }

        return aux;
    }

    public boolean removerInicio(T elemento){
        boolean removido = false;
        if(this.inicio == null){
            System.out.println("Lista vazia");
        }
        else{
            No<T> aux = this.inicio;
            this.inicio = this.inicio.getProximo();
            if(this.inicio == null) {
                this.ultimo = null;
            }
            else{
                this.inicio.setAnterior(null);
            }

            aux.setProximo(null);
            aux = null;
            removido = true;
        }
        return removido;
    }

    public boolean removerFinal(T elemento){
        boolean removido = false;
        if(this.inicio == null){
            System.out.println("Lista vazia");
        }
        else{
            No<T> aux = this.ultimo;
            this.ultimo = this.ultimo.getAnterior();
            if(this.ultimo == null){
                this.inicio = null;
            }
            else {
                this.ultimo.setProximo(null);
            }
            aux.setAnterior(null);
            aux = null;
            removido = true;
        }
        return removido;
    }

    public boolean removerMeio(T elemento){
        boolean removido = false;

        if(this.inicio != null) {
            No<T> remover = this.inicio;

            //busca o No em que o elemento está
            while (remover != null && remover.getElemento() != elemento) {
                remover = remover.getProximo();
            }
            if (remover != null) {
                No<T> anterior = remover.getAnterior();
                No<T> posterior = remover.getProximo();

                anterior.setProximo(posterior);
                posterior.setAnterior(anterior);

                remover.setProximo(null);
                remover = null;
                removido = true;
            }
        }
        return removido;
    }

    public void removerElemento(T elemento){
        if(buscarElemento(elemento)){
            boolean verifica = false;
            //remove o elemento no inicio
            if(this.inicio.getElemento().equals(elemento)){
                verifica = removerInicio(elemento);
                if(verifica){
                    System.out.println("Elemento " + elemento + " removido!");
                }
            }
            //remove o elemento no final
            else if (this.ultimo.getElemento().equals(elemento)){
                verifica = removerFinal(elemento);
                if(verifica){
                    System.out.println("Elemento " + elemento + " removido!");
                }
            }
            //remove o elemento no meio
            else {
                verifica = removerMeio(elemento);
                if(verifica){
                    System.out.println("Elemento " + elemento + " removido!");
                }
            }
            if(tamanho == 0){
                this.ultimo = null;
            }
            this.tamanho--;
        }
        else{
            System.out.println("Elemento nao existe na lista");
        }
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio=" + inicio +
                ", ultimo=" + ultimo +
                '}';
    }
}