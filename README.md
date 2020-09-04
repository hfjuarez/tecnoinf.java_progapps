# README

### Orden de los casos de uso:

1.  Alta instituto -- LISTO
2.  Alta usuario -- LISTO
3.  Modificar usuario --TESTEO
4.  Alta curso -- TESTEO
5.  Alta edición de un Curso -- POR COMENZAR
6.  Crear programa formación -- POR COMENZAR
7.  Agregar curso programa formación
8.  Inscripcion edicion de Curso
9.  Consulta edicion de Curso
10.  Consulta de Programa de Formacion (Necesita del siguiente)
11.  Consulta de Curso (Necesita del anterior)
12.  Consulta Usuario

*A su vez se necesitan funciones complementarias para realizar los casos de uso. Ejemplo: Lista de cursos, entre otras.*

---

# Package: logica

## logica.entidades

Contiene todas las clases entidades.

*   Instituto
*   Usuario
*   Docente
*   Estudiante
*   Curso
*   Edición
*   Formación

## Package: logica.institutos

​	Contiene todo lo necesario para  manejar la clase entidad Intituto.

###### ExisteInstituto



##### Clase: AltaInstituto

Esta clase contiene un main donde por asignación a la variable "nombreInstituto" (de tipo String) se crea un Instituto nuevo con el valor que contenga la variable previamente mencionada. 

**Dependencias:**

*   Instituto (clase entidad).

*   ExisteInstituto - Se usa para consultar si ya existe un instituto con igual nombre.







### logica.usuarios

*   Alta Usuario (NOS FALTA LA IMAGEN)
*   Modificar Usuario (NOS FALTA LA IMAGEN)
*   Consulta usuario (NOS FALTA LA IMAGEN)

**Funciones auxiliares pero necesarias:**

*   Lista de Usuarios
*   obtener Usuario(Busca por parámetro recibido el usuario y lo devuelve)
*   existe Usuario

### logica.cursos

*   Alta curso
*   Alta Edición curso
*   inscripción a edición curso
*   consulta edición curso
*   Consulta curso

**Funciones auxiliares pero necesarias:**

*   Lista ediciones (por curso)
*   Lista de cursos (por instituto)
*   obtener Curso (Busca por parámetro recibido el curso y lo devuelve)
*   obtener Edición (Busca por parámetro recibido el edición y lo devuelve)
*   Existe Curso
*   Existe Edición

### logica.formacion

*   Crear programa formación
*   Agregar Curso a formación
*   Consulta programa formación

**Funciones auxiliares pero necesarias:**

*   Lista formaciones
*   Lista Cursos en Formación
*   existe curso en formación
*   existe formación
*   obtener Formación  (Busca por parámetro recibido la formación y lo devuelve)

### logica.inscripciones

*   Inscripción a edición curso
*   inscripción formación (no hay un caso de uso como tal)

**Funciones auxiliares pero necesarias:**

*   obtener inscripción Formación
*   obtener inscripción edición
*   lista Inscripción edición (por edición, curso)
*   lista inscripción formación (por formación)

# Package: API

**Contiene:**

*   Interface
*   Controller

# Package: GUI

*   Contiene la Estación de Trabajo hecha con swing.

**IMPORTANTE:**

*   Imagenes como vamos a hacer (se deben almacenar en una carpeta especifica)	
    *   [https://www.tutorialspoint.com/how-to-create-a-new-directory-by-using-file-object-in-java#:~:text=Creating%20a%20new%20directory,represented%20by%20the%20current%20object.&text=Instantiate%20the%20File%20class%20by,the%20above%20created%20file%20object.](https://www.tutorialspoint.com/how-to-create-a-new-directory-by-using-file-object-in-java#:~:text=Creating a new directory,represented by the current object.&text=Instantiate the File class by,the above created file object.)
    *   

---