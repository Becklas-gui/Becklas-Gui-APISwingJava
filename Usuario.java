public class Usuario {

    private String nome;
    private String email;
    private int idade;
    private int id;
    private String genero;


    public Usuario(int id, String nome, String genero, String email, int idade){
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.email = email;
        this.idade = idade;
    };

    public int getid() {
        return id;
    };

    public String getnome() {
        return nome;
    };
    public String getgenero() {
        return genero;
    };
   // public String getemail() {
        public String getemail() { 
        return email;
    };
        public int getidade() {
            return idade;
        };
        public void setid(int id) {
            this.id = id;
        };
        public void setnome(String nome) {
            this.nome = nome;
        };
        public void setgenero(String genero){
            this.genero = genero;
        };
        public void setemail(String email){
            this.email = email;
        };
        public void setidade(int idade){
            this.idade = idade;
        };

}
