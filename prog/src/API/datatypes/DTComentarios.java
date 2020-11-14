package API.datatypes;

import java.util.ArrayList;
import java.util.List;


import logica.entidades.Comentarios;
import logica.entidades.Curso;

public class DTComentarios {
	public int id;
	public String nick;
	public String Comentario;
	public String edi;
	public List<DTComentarios> Respuestas=null;
	
	public DTComentarios() {super();}
	
	public DTComentarios(Comentarios com)
	{
		this.id = com.getId();
		this.nick = com.getNick();
		this.Comentario = com.getComentario();
		this.edi = com.getEdi();
		
		List<Comentarios> respuestasList = com.getRespuestas();
		List<DTComentarios> respuestasDTList = new ArrayList();

		for (Comentarios p : respuestasList) {
			DTComentarios dtp = new DTComentarios(p);
			respuestasDTList.add(dtp);
		}
		this.Respuestas = respuestasDTList;
	}
}



