package logica.instituto;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Instituto;
import logica.datatypes.DTInstituto;

import javax.persistence.*;

public class ListaInstitutos {

    public List<Instituto> getList() {
        List<Instituto> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Instituto as i");
        list = (List<Instituto>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTInstituto> getDataTypeList() {
        List<Instituto> list = getList();
        List<DTInstituto> listOfDT = new ArrayList();
        for (Instituto instituto : list) {
            DTInstituto dtInstituto = new DTInstituto(instituto);
            listOfDT.add(dtInstituto);
        }
        return listOfDT;
    }
}