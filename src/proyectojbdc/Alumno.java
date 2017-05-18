
package proyectojbdc;


public class Alumno {
    String nome,apelido,dni;

    public Alumno() {
    }

    public Alumno(String nome, String apelido, String dni) {
        this.nome = nome;
        this.apelido = apelido;
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nome=" + nome + ", apelido=" + apelido + ", dni=" + dni + '}';
    }
    
}
