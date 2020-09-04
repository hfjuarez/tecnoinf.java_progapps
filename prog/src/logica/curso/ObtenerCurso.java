public class ObtenerCurso {

    public Curso getCurso(String name) {

        ExisteCurso existeCurso = new ExisteCurso(nombre);
        if (existeCurso.existe()) {
            Curso ret = new Curso();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(Curso.class, nombre);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }
}
