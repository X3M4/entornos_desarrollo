/*MODIFICO EL ARCHIVO CON UN COMENTARIO PARA PODER HACER UN CAMBIO EN LA RAMA */
import java.util.Arrays;
public class Cliente {
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;
    private int codigo_paciente;
    private static int[] num_paciente = new int[1];
    static int contador = 0;

    //CONSTRUCTORES
    public Cliente(String nombre, int edad, char sexo, double peso, double altura){
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        setPeso(peso);
        setAltura(altura);
        generaNumPaciente();
    }
    public Cliente(String nombre, int edad, char sexo){
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
    }
    public Cliente(){
        generaNumPaciente();
    }
    
    //SETTERS PARA TODOS LOS PARÁMETROS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setSexo(char sexo){
        this.sexo = comprobarSexo(sexo);
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public int getEdad(){
        return edad;
    }
 

    //MÉTODOS
    public int calcularIMC(){
        double imc = peso / (Math.pow((altura/100), 2));
        int valor;
        if(imc < 20) valor = -1;
        else if(imc >= 20 && imc <= 25) valor = 0;
        else valor = 1;
        return valor;
    }
    public boolean mayorDeEdad(){
        boolean mayor;
        if(getEdad() >= 18){
            mayor = true;
        }else {
            mayor = false;
        }
        return mayor;
    }
    public char comprobarSexo(char sexo){
        char uppersexo = Character.toUpperCase(sexo);
        if(uppersexo == 'H' || uppersexo == 'M'){
            uppersexo = Character.toUpperCase(sexo);
        }else{
            uppersexo = Character.toUpperCase('H');
        }
        return uppersexo;
    }
    private void generaNumPaciente(){
        num_paciente[contador] = contador +1;
        contador++;
        codigo_paciente = num_paciente[num_paciente.length-1];
        num_paciente = Arrays.copyOf(num_paciente, num_paciente.length+1);
    }
    @Override
    public String toString(){
        return String.format("ID_Paciente: %d - Nombre: %s - Edad: %d - Sexo: %s - Peso: %1.2f - Altura: %1.2f - IMC: %d\n\n", 
            codigo_paciente,nombre, edad, sexo, peso, altura, calcularIMC());
    }  
}
