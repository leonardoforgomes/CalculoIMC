package calc;

public class IMC {
    private Double altura;
    private Double peso;
    private Double valor; // Valor do IMC
    private String resultado; // Classificação do IMC

    // Getters e Setters
    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public String getResultado() {
        return resultado;
    }

    public String calcularIMC() {
        this.valor = peso / (altura * altura);

        if (valor < 18.5) {
            resultado = "Baixo peso";
        } else if (valor >= 18.5 && valor <= 24.9) {
            resultado = "Peso adequado";
        } else if (valor >= 25 && valor <= 29.9) {
            resultado = "Sobrepeso";
        } else if (valor >= 30 && valor <= 34.9) {
            resultado = "Obesidade grau 1";
        } else if (valor >= 35 && valor <= 39.9) {
            resultado = "Obesidade grau 2";
        } else {
            resultado = "Obesidade extrema";
        }
        
        return resultado;
    }
}
